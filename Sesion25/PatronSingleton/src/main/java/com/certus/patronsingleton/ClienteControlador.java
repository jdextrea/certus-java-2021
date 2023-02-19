/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.certus.patronsingleton;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jdextre
 */
public class ClienteControlador {
    CallableStatement stmt;
    ResultSet rs;
    
    public int validarClientesSP(Connection con, String correo, String clave) throws SQLException {
        String Query= "{CALL validarCliente(?,?)}";
        stmt = con.prepareCall(Query);
        stmt.setString(1, correo);
        stmt.setString(2, clave);
        rs = stmt.executeQuery();
            int contador = 0;
                while (rs.next()) {
                contador++;
                }
         return contador;       
        
    }
    
    public void listarClientesSP(Connection con) throws SQLException {
        String Query= "{CALL listarCliente()}";
        stmt = con.prepareCall(Query);
        rs = stmt.executeQuery();
    }
    public void insertarRegistrosSP (Connection con, Integer cod, String nom, String correo, String clave) throws SQLException {
        String Query  = "{CALL insertarCliente(?,?,?,?)}";
        stmt = con.prepareCall(Query);
        stmt.setInt(1, cod);
        stmt.setString(2, nom);
        stmt.setString(3, correo);
        stmt.setString(4, clave);
        rs = stmt.executeQuery();
    }
}
