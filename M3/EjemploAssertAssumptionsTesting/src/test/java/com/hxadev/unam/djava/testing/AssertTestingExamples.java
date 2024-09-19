package com.hxadev.unam.djava.testing;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * @author hxa.dev
 */
public class AssertTestingExamples {
    @Test
    public void testAssertEquals(){
        int result=5*2;
        assertEquals(10,result);
    }

    @Test
    public void testAssertTrue(){
        int number=2*10;
        int limit=10;
        assertTrue(number>limit);
    }

    @Test
    public void testAssertFalse(){
        int number=2*10;
        int limit=10;
        assertFalse(number<limit);
    }

    @Test
    public void testAssertNotNull(){
        String description=new StringBuffer().append("Hi").append("World").append("This is your java course").toString();
        assertNotNull(description);
    }

    @Test
    public void testAssertNull(){
        String description=new StringBuffer().append("Hi").append("World").append("This is your java course").toString();
        description=null;
        assertNull(description);
    }

    @Test
    public void testAssertSame(){
        String name=new String("Hi im an String!");
        String nameDuplicated=name;


        assertSame(name,nameDuplicated);
    }

    @Test
    public void testNotAssertSame(){
        String name=new String("Hi im an String!");
        String nameDuplicated=new String("Hi im an String!");


        assertNotSame(name,nameDuplicated);
    }

    @Test
    public void testAssertThrows(){

        Assert.assertThrows(NumberFormatException.class,()->{
            Integer.parseInt("One");
        });

        Assert.assertThrows(ArithmeticException.class,()->{
            double result=32/0;
        });

        Assert.assertThrows(NullPointerException.class,()->{
            Integer number1=null;
            Integer number2=2;

            Integer result=number1+number2;
        });

        Assert.assertThrows(IndexOutOfBoundsException.class,()->{
            Integer[] numbers=new Integer[2];
            numbers[0]=new Integer(1);
            numbers[1]=new Integer(2);
            numbers[2]=new Integer(3);
        });
    }

}
