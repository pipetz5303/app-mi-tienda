/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoappmitienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class Conexion {
    Connection conex = null;
    String usuario = "sqlUsuario";
    String contrasena = "root";
    String db = "App_Mi_Tienda";
    String puerto = "1433";
    
    public Connection ObtenerConexion(){
        try {
            String cadena ="jdbc:sqlserver://localhost:"+puerto+";"+"databaseName="+db+";"+"encrypt=true;trustServerCertificate=true";
            conex = DriverManager.getConnection(cadena, usuario, contrasena);
          //JOptionPane.showMessageDialog(null, "Conexion realizada");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :"+ex);
            System.out.println(ex);
        }
        return conex;
    }
    
    
    public static void conectarseALaBaseDeDatos(){
        Conexion con = new Conexion();
        Connection condb = con.ObtenerConexion();
        CRUDSqlServer crud = new CRUDSqlServer();
       }

    
}
