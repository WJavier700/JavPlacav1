/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author WJavier
 */
public class BaseDeDatos {
    
     // URL de conexión a la base de datos
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=db_trafico;user=root;password=root;loginTimeout=30;";
    
    // Método para obtener la conexión a la base de datos
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
