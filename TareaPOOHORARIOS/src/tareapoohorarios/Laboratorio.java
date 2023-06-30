/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareapoohorarios;

/**
 *
 * @author miguel
 */
public class Laboratorio {

    private String nombre;
    private int capacidad;
    private String[] equipos;

    public Laboratorio(String nombre, int capacidad, String[] equipos) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.equipos = equipos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String[] getEquipos() {
        return equipos;
    }

    public boolean verificarDisponibilidad(String horario) {
        
        return true; 
    }
}

