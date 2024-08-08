/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author WJavier
 */
public class InsertarDatos {
    // Método para crear la tabla si no existe
    public void crearTabla(Connection conn) {
        String createTableSQL = "IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='ResultadosPicoYPlaca' AND xtype='U') " +
                                "CREATE TABLE ResultadosPicoYPlaca (" +
                                "Id INT PRIMARY KEY IDENTITY(1,1), " +
                                "Placa VARCHAR(10), " +
                                "Fecha DATE, " +
                                "Hora TIME, " +
                                "PuedeCircular BIT)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar el resultado en la base de datos
    public void guardarResultado(Connection conn, PicoYPlaca picoYPlaca, boolean puedeCircular) {
        String insertSQL = "INSERT INTO ResultadosPicoYPlaca (Placa, Fecha, Hora, PuedeCircular) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, picoYPlaca.getPlaca());
            pstmt.setString(2, picoYPlaca.getFecha());
            pstmt.setString(3, picoYPlaca.getHora());
            pstmt.setBoolean(4, puedeCircular);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
