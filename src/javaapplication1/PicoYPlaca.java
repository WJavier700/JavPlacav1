/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author WJavier
 */
public class PicoYPlaca {
    private String placa;
    private LocalDate fecha;
    private LocalTime hora;

    private static final Map<Integer, int[]> RESTRICCIONES = new HashMap<>();
    private static final LocalTime INICIO_MANANA = LocalTime.of(6, 0);
    private static final LocalTime FIN_MANANA = LocalTime.of(9, 30);
    private static final LocalTime INICIO_TARDE = LocalTime.of(16, 0);
    private static final LocalTime FIN_TARDE = LocalTime.of(20, 00);

    static {
        RESTRICCIONES.put(1, new int[]{1, 2});
        RESTRICCIONES.put(2, new int[]{3, 4});
        RESTRICCIONES.put(3, new int[]{5, 6});
        RESTRICCIONES.put(4, new int[]{7, 8});
        RESTRICCIONES.put(5, new int[]{9, 0});
        RESTRICCIONES.put(6, new int[]{}); // Sábado, sin restricciones
        RESTRICCIONES.put(0, new int[]{}); // Domingo, sin restricciones
    }

    public PicoYPlaca(String placa, String fecha, String hora) {
        if (!placa.matches("[A-Za-z]{3}[0-9]{4}")) {
            throw new IllegalArgumentException("Formato de placa inválido. Debe ser 3 letras seguidas de 4 números.");
        }
        this.placa = placa;
        this.fecha = LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE);
        this.hora = LocalTime.parse(hora, DateTimeFormatter.ISO_LOCAL_TIME);
    }

    public boolean puedeCircular() {
        int ultimoDigito = Character.getNumericValue(placa.charAt(placa.length() - 1));
        int diaSemana = fecha.getDayOfWeek().getValue();

        int[] restriccionDia = RESTRICCIONES.get(diaSemana % 7);

        for (int restriccion : restriccionDia) {
            if (ultimoDigito == restriccion) {
                if ((hora.isAfter(INICIO_MANANA) && hora.isBefore(FIN_MANANA)) ||
                    (hora.isAfter(INICIO_TARDE) && hora.isBefore(FIN_TARDE))) {
                    return false;
                }
            }
        }
        return true;
    }

    // Getters
    public String getPlaca() {
        return placa;
    }

    public String getFecha() {
        return fecha.toString();
    }

    public String getHora() {
        return hora.toString();
    }
    
}
