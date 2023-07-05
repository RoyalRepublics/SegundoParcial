package poo_practica13_Abstract;

/**
 *
 * @author miguel
 */
public class Circulo extends Figura{
double r;
public Circulo(){}

    public Circulo(double r) {
        this.r = r;
    }

    public Circulo(double r, double x, double y) {
        super(x, y);
        this.r = r;
    }

    @Override
    public double CalcularArea() {
        double area=Math.PI*r*r;
        return area;
    }
    
}
