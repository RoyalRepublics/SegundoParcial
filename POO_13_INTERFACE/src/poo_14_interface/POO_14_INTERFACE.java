package poo_14_interface;

import java.util.Scanner;

public class POO_14_INTERFACE {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double aux;
        int op=0;
        Cuadrado cuad=new Cuadrado(0);
        Circulo cir=new Circulo(0);
        Pentagono pent=new Pentagono(0);
        while (op!=4){
            System.out.println("Escoja su opcion: ");
            System.out.println("1. Calcular area circulo. ");
            System.out.println("2. Calcular area cuadrado. ");
            System.out.println("3. Calcular area pentagono. ");
            System.out.println("4. Salir ");
            op=sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("Ingrese el radio del circulo: ");
                    cir.r=(sc.nextDouble());
                    System.out.println("El area del circulo es :"+ cir.CalcularArea());
                    cir.Dibujar();
                    cir.Rotar();
                    break;
                case 2:
                    System.out.println("Ingrese el lado del cuadrado: ");
                    cuad.lado=(sc.nextDouble());
                    System.out.println("El area del cuadrado es: "+cuad.CalcularArea());
                    break;
                case 3:
                    System.out.println("Ingrese el lado del Pentagono: ");
                    pent.lado=(sc.nextDouble());
                    System.out.println("El area del cuadrado es: " + pent.CalcularArea());
                    pent.Dibujar();
                    pent.Rotar();
                    break;
                default:
                    System.out.println("OpcionIncorrecta");
                    break;
    
    
    
    }
    
    
    }
    
    
}}
