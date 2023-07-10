/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_16_abstractpolimorfismo;

/**
 *
 * @author miguel
 */
public class Circulo extends Figura{
    private int Radio;

    public Circulo(int Radio,String color) {
        super(color);
        this.Radio = Radio;
    }

    public int getRadio() {
        return Radio;
    }

    public void setRadio(int Radio) {
        this.Radio = Radio;
    }



  
    
    @Override
    public double superficie() {
        return Math.PI*Radio*Radio;
        }
    
}
