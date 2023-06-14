
package areaspractica;

import java.util.Scanner;

public class AreasPractica {

    public static void main(String[] args) {
        Scanner nw=new Scanner(System.in);
        Cuadrado cd= new Cuadrado();
        System.out.println("Figuras Geometricas:");
        System.out.println("Cuadrado.");
        System.out.println("ingrese la longitud del lado");
        cd.lado=nw.nextDouble();
        cd.Area();
        cd.Perimetro();
        System.out.println("El area es: "+cd.Ar);
        
        System.out.println("El perimetro es: "+cd.Per);
    }
    
}
