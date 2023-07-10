package poo_16_abstractpolimorfismo;

import java.util.Scanner;

public class POO_16_AbstractPolimorfismo {

    public static void main(String[] args) {
        Circulo ci=new Circulo(0,null);
        Scanner sc=new Scanner(System.in);
        Triangulo tr=new Triangulo(0,0,null);
        Pentagono pen=new Pentagono(0,null);
        System.out.println("Ingrese el radio del Circulo");
        ci.setRadio(sc.nextInt());
        sc.nextLine();
        System.out.println("Ingrese el color del circulo");
        ci.setColor(sc.nextLine());
        System.out.println("Ingrese la base del triangulo");
        tr.setBase(sc.nextInt());
        System.out.println("Ingrese altura del triangulo");
        tr.setAltura(sc.nextInt());
        sc.nextLine();
        System.out.println("Ingrese el color del triangulo");
        tr.setColor(sc.nextLine());
        System.out.println("Intrese el lado del pentagono");
        pen.setLado(sc.nextInt());
        sc.nextLine();
        System.out.println("Intrese el color del pentagono");
        pen.setColor(sc.nextLine());
        System.out.println("datos del circulo");
        mostraDatosFiguras(ci);
        System.out.println("datos del triangulo");
        mostraDatosFiguras(tr);
        System.out.println("datos del pentagono");
        mostraDatosFiguras(pen);
    }
    private static void mostraDatosFiguras(Figura f){
    System.out.println("Color: "+f.getColor());
    System.out.println("Superficie: "+f.superficie());
    }
}
