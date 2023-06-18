package areaspractica;
import java.util.Scanner;
class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;
    public Rectangulo() {
        base = 0.0;
        altura = 0.0;
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
    public void leerDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de la base: ");
        base = sc.nextDouble();
        System.out.println("Ingrese el valor de la altura: ");
        altura = sc.nextDouble();
    }
    @Override
    public void calcularArea() {
        setArea(base * altura);
    }
    @Override
    public void calcularPerimetro() {
        setPerimetro(2 * (base + altura));
    }
}