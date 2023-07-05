package poo_practica13_Abstract;

/**
 *
 * @author miguel
 */
public abstract class Figura {
    double x;
    double y;
public Figura() {
 
    }
    public Figura(double x, double y) {
        this.x = x;
        this.y = y;
    }
   public abstract double CalcularArea(); 
}
