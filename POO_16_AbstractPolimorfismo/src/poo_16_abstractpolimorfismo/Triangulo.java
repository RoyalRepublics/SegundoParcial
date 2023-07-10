/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_16_abstractpolimorfismo;

/**
 *
 * @author miguel
 */
public class Triangulo extends Figura{
    private int base;
    private int altura;

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Triangulo(int base, int altura, String color) {
        super(color);
        this.base = base;
        this.altura = altura;
    }
    public double superficie(){
    return base*altura/2;
    }
}
