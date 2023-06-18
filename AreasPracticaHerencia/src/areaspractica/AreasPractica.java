package areaspractica;
import java.util.Scanner;
public class AreasPractica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion=0;
    while (opcion!=5){
        // Mostrar el menú de opciones
        System.out.println("1. Cuadrado");
        System.out.println("2. Pentagono");
        System.out.println("3. Rectangulo");
        System.out.println("4. Triangulo");
        System.out.println("5. Salir");
        System.out.println("Seleccione una opcion:");
        opcion = sc.nextInt();
        // Realizar acciones según la opción seleccionada
        switch (opcion) {
            case 1:
                Cuadrado cuadrado = new Cuadrado();
                cuadrado.leerDatos();
                cuadrado.calcularArea();
                cuadrado.calcularPerimetro();
                cuadrado.mostrarResultados();
                break;
            case 2:
                Pentagono pentagono = new Pentagono();
                pentagono.leerDatos();
                pentagono.calcularArea();
                pentagono.calcularPerimetro();
                pentagono.mostrarResultados();
                break;
            case 3:
                Rectangulo rectangulo = new Rectangulo();
                rectangulo.leerDatos();
                rectangulo.calcularArea();
                rectangulo.calcularPerimetro();
                rectangulo.mostrarResultados();
                break;
            case 4:
                Triangulo triangulo = new Triangulo();
                triangulo.leerDatos();
                triangulo.calcularArea();
                triangulo.calcularPerimetro();
                triangulo.mostrarResultados();
                break;
            case 5:
                System.out.println("Ha salido del programa...");
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
    }
        sc.close();
    }
}