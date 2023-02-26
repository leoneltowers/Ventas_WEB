
package com.app.productos.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectarBD {
    Connection con;
//    private static final String URL = "jdbc:mysql://localhost:3306/bd_productos?serverTimezone=UTC";
//    private static final String USER = "root";
//    private static final String PASS = "1309";
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bd_productos";
    private static final String USER = "root";
    private static final String PASS = "1809";

  
    public static Connection Conectar() {
        Connection conex = null;
        try {
            Class.forName(DRIVER);
            conex = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de Conexion a Base de Datos : " + e);
        }
        return conex;

    }
}
