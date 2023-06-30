/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica_poosobrecarga;

/**
 *
 * @author miguel
 */
public class Practica_POOSobrecarga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona persona1= new Persona("Pepe",15);
        persona1.jugar();
        Persona persona2= new Persona(1721020822);
        persona2.jugar("Fuchibol");
    }
    
}
