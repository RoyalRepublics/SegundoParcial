package poo_practica13_Abstract;

/**
 *
 * @author miguel
 */
public class Cuadrado extends Figura {
double lado;
    public Cuadrado() {
    }

    public Cuadrado(double x, double y) {
        super(x, y);
        this.lado=lado;
    }
    
    
@Override
public double CalcularArea(){
    double resul=lado*lado;
return resul;
}
 
}
