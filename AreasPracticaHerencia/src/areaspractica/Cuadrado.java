package areaspractica;
import java.util.Scanner;
class Cuadrado extends FiguraGeometrica {
    private double lado;

    public Cuadrado() {
        lado = 0.0;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void leerDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor del lado: ");
        lado = sc.nextDouble();
    }

    @Override
    public void calcularArea() {
        setArea(lado * lado);
    }

    @Override
    public void calcularPerimetro() {
        setPerimetro(4 * lado);
    }
}