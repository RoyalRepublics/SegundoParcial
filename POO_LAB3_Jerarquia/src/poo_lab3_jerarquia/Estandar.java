
package poo_lab3_jerarquia;

import java.util.Scanner;

/**
 *
 * @author miguel
 */
//clase estadar que hereda de la clase abstracta Producto.
public class Estandar extends Producto {
       Scanner sc=new Scanner(System.in);
    private String Seccion;
//getter y setters de la clase estandar
    public String getSeccion() {
        return Seccion;
    }

    public void setSeccion(String Seccion) {
        this.Seccion = Seccion;
    }
//constructores de la clase estandar
    public Estandar(String Seccion) {
        this.Seccion = Seccion;
    }

    public Estandar(String Seccion, String Nombre, double Precio) {
        super(Nombre, Precio);
        this.Seccion = Seccion;
    }
 
//sobrecarga del metodo obtenerpreciopedido
    @Override
    public double obtenePrecioPedido(Double Precio) {
        int Cantidad;
        System.out.println("Ingrese la cantidad de productos: ");
        Cantidad=sc.nextInt();
        if (Cantidad>=5){
        return Precio*Cantidad*0.9;}else{
        return Precio*Cantidad;}
       
    }
    
}
