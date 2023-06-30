package areaspractica;
import java.util.Scanner;
class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;
    private double lado1;
    private double lado2;
    public Triangulo() {
        base = 0.0;
        altura = 0.0;
        lado1 = 0.0;
        lado2 = 0.0;
    }
    public void setBase(double base) {
        this.base = base;
    }
    public double getBase() {
        return base;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getAltura() {
        return altura;
    }
    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }
    public double getLado1() {
        return lado1;
    }
    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }
    public double getLado2() {
        return lado2;
    }
    public void leerDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de la base (lado): ");
        base = sc.nextDouble();
        System.out.println("Ingrese el valor de la altura: ");
        altura = sc.nextDouble();
        System.out.println("Ingrese el valor del lado 1: ");
        lado1 = sc.nextDouble();
        System.out.println("Ingrese el valor del lado 2: ");
        lado2 = sc.nextDouble();
    }
    @Override
    public void calcularArea() {
        setArea((base * altura) / 2);
    }
    @Override
    public void calcularPerimetro() {
        setPerimetro(base + lado1 + lado2);
    }
}