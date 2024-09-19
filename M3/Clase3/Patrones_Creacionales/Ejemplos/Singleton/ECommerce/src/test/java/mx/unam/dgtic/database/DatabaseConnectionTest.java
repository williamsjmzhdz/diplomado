package mx.unam.dgtic.database;

import org.junit.Before;
import org.junit.Test;
import org.junit.*;

import javax.xml.crypto.Data;
import java.sql.Connection;

import static junit.framework.TestCase.*;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class DatabaseConnectionTest {

    @Before
    public void setUp() {
    }

    @Test
    public void checkIfDatabaseConnectionIsSingleton(){
        // Given
        var connectionInstance=DatabaseConnection.getInstance();
        // When
        Connection connection=connectionInstance.getConnection();
        // Then
        assertNotNull(connection);
        assertTrue(connectionInstance instanceof  DatabaseConnection);
        assertTrue(DatabaseConnection.getInstance() instanceof DatabaseConnection );
        // The same object
        assertTrue(connectionInstance.equals(DatabaseConnection.getInstance()));
    }

    @Test
    public void checkIfDatabaseConnectionIsNull(){
        // Given
        var connectionInstance=DatabaseConnection.getInstance();
        // When
        Connection connection=connectionInstance.getConnection();
        connection=null;
        // Then
        assertNull(connection);
        // The same object
    }
}