package mx.unam.dgtic.models;

import mx.unam.dgtic.database.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class ShopModel {
    private Connection connection;

    public ShopModel(){
        connection= DatabaseConnection.getInstance().getConnection();
    }
    public String getShopDetails() throws SQLException {
       CallableStatement stmt= connection.prepareCall("SELECT * FROM shop");
       return stmt.getResultSet().getString(0);
    }
}
