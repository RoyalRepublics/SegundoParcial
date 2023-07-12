package poo_lab3_jerarquia;

import java.util.Scanner;

/**
 *
 * @author miguel
 */
//Clase Ofertado que hereda de la clase producto
public class Ofertado extends Producto{
    //funcion Scanner para ingesar por teclado.
    Scanner sc=new Scanner(System.in);
    int dias;
    double descuento=0.0;
//getter y setter de la clase Ofertado

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
//constructores de la clase Ofertado con el uper de la clase producto.

    public Ofertado(int dias) {
        this.dias = dias;
    }

    public Ofertado(int dias, String Nombre, double Precio) {
        super(Nombre, Precio);
        this.dias = dias;
    }

//Sobrecarga del metodo abstracto obtenerpreciopedido.
    @Override
    public double obtenePrecioPedido(Double Precio) {
    System.out.println("Ingrese la cantidad del producto: ");
    int Cantidad=sc.nextInt();
    System.out.println("Ingrese los dias de oferta del producto: ");
    int dias=sc.nextInt();
    Descuento(dias);
    return Precio*Cantidad-Precio*Cantidad*descuento;
    }
    //metodo para calcular el porcentaje de descuento
    public void Descuento(int dias){
    switch (dias){
            case 0: descuento=0;
            break;
            case 1: descuento=0.2;
            break;
            case 2: descuento=0.15;
            break;
            case 3: descuento=0.15;
            break;
            default:
            descuento=0.1;
        break;
    }}
}
