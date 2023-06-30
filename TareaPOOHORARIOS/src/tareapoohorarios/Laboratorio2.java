/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareapoohorarios;

/**
 *
 * @author miguel
 */
public class Laboratorio2 extends Laboratorio {
    private String lugar;

    public Laboratorio2(String nombre, int capacidad, String[] equipos, String lugar) {
        super(nombre, capacidad, equipos);
        this.lugar = lugar;
    }

    public String getLugar() {
        return lugar;
    }
}