package mx.unam.dgtic.database;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection(){
        try{
            connection= DriverManager.getConnection("jdbc:h2:~/test");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance(){
        if(instance==null)
            instance=new DatabaseConnection();
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }
}
