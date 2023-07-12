package poo_lab3_jerarquia;

import java.util.Scanner;

/**
 *
 * @author miguel
 */
//clase main donde se ejecuta un menu
public class POO_LAB3_Jerarquia {
    public static void main(String[] args) {
        int op=0;
        double aux=0;
       Scanner sc=new Scanner(System.in);
       //inicializacion de los objetos.
        Estandar es=new Estandar("","",0);
        Ofertado of=new Ofertado(0,"",0);
        //bucle para el menu
        while(op!=3){
            System.out.println("Jerarquia de productos: ");
            System.out.println("1. Registrar una venta de un producto Ofertado.");
            System.out.println("2. Regitrar una venta de un producto Estandar.");
            System.out.println("3. Salir");
            System.out.println("Ingrese la opcion que desea: ");
            op=sc.nextInt();
        //switch que va a ejecutar calculos segun el tipo de producto.
            switch (op){
            case 1:
                //caso del producto ofertado.
                System.out.println("Ingerse el percio del producto en Oferta:");
                System.out.println("El valor a pagar es: " + of.obtenePrecioPedido(sc.nextDouble()));
            break;
            case 2:
                //caso del producto estandar.
                System.out.println("Ingrese el precio del producto Estandar");
                System.out.println("El valor a pagar es: "+ es.obtenePrecioPedido(sc.nextDouble()));
            break;
            case 3:
                System.out.println("Ha salido con exito...");
            break;
            default:
                System.out.println("Opcion Incorrecta.");
        }
        }
    }
    
}
