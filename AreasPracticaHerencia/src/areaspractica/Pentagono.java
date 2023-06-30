package areaspractica;
import java.util.Scanner;
class Pentagono extends FiguraGeometrica {
    private double lado;

    public Pentagono() {
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
        setArea((5 * lado * lado) / (4 * Math.tan(Math.PI / 5)));
    }

    @Override
    public void calcularPerimetro() {
        setPerimetro(5 * lado);
    }
}