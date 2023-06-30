/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareapoohorarios;

/**
 *
 * @author miguel
 */
public class Laboratorio1 extends Laboratorio {
    private String espacio;

    public Laboratorio1(String nombre, int capacidad, String[] equipos, String espacio) {
        super(nombre, capacidad, equipos);
        this.espacio = espacio;
    }

    public String getEspacio() {
        return espacio;
    }
}