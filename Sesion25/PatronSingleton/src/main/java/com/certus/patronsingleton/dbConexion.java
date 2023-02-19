package com.certus.patronsingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbConexion {
    ResourceBundle messages = ResourceBundle.getBundle("conexion"); 
    
    private static Connection con=null;
    
    //Constructor privado
    private dbConexion() {
        String driver = messages.getString("driver");
        String url = messages.getString("url");
        String pwd = messages.getString("clave");            
        String usr = messages.getString("usuario");   
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usr, pwd);
            System.out.println("Conexion satisfactoria");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }    
    }
        //Crear el metodo estatico
    public static Connection devolverConexion() {
            if (con==null) {
                new dbConexion();
            }
           return con; 
        }
    
}
