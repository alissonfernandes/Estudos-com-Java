package br.com.java.database.interaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    final static String urlConnection = "jdbc:mysql://localhost/db_teste";
    
    
    static Connection con = null;
    
    public static Connection getConnection(){
        try {
            con = DriverManager.getConnection(urlConnection, "root", "123456");
            return con;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
