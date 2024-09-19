package mx.unam.dgtic.prototype;

import mx.unam.dgtic.FullTimeEmployee;
import mx.unam.dgtic.HalfTimeEmployee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/

public class EmployeeTest {

    private FullTimeEmployee employee;
    private HalfTimeEmployee halfTimeEmployee;

    @Before
    public void setUp() {
        employee=new FullTimeEmployee("name","department",20);
        halfTimeEmployee=new HalfTimeEmployee("name2","department2",22);
    }

    @Test
    public void givenObjectWhenObjectIsPrototypeThenCheckIfIsPrototype(){
        //Given
        FullTimeEmployee employeTest=employee;


        //When
        FullTimeEmployee prototype=(FullTimeEmployee) employeTest.clone();
        HalfTimeEmployee prototype2=(HalfTimeEmployee) halfTimeEmployee.clone();

        //Then
        assertTrue(prototype instanceof FullTimeEmployee);
        assertTrue(prototype2 instanceof HalfTimeEmployee);
        assertFalse(prototype.equals(employeTest));
        assertFalse(prototype2.equals(halfTimeEmployee));

    }


}