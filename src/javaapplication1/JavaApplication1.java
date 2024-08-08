/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;


import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author WJavier
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Datos de ejemplo
        String placa = "EBB1231";
        String fecha = "2024-08-07";
        String hora = "08:30";

        PicoYPlaca picoYPlaca = new PicoYPlaca(placa, fecha, hora);
        boolean puedeCircular = picoYPlaca.puedeCircular();

        BaseDeDatos baseDeDatos = new BaseDeDatos();
        InsertarDatos insertarDatos = new InsertarDatos();

        // Obtener la conexión
        try (Connection conn = baseDeDatos.getConnection()) {
            if (conn != null) {
                // Crear la tabla si no existe
                insertarDatos.crearTabla(conn);

                // Guardar el resultado
                insertarDatos.guardarResultado(conn, picoYPlaca, puedeCircular);

                System.out.println("Resultado guardado exitosamente.");
            } else {
                System.out.println("No se pudo establecer la conexión a la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}
