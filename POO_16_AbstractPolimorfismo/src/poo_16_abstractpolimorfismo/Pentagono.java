package poo_16_abstractpolimorfismo;

/**
 *
 * @author miguel
 */
public class Pentagono extends Figura {
    int lado;

    public Pentagono(int lado) {
        this.lado = lado;
    }

    public Pentagono(int lado, String color) {
        super(color);
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    @Override
    public double superficie() {
        return (5 * lado * lado) / (4 * Math.tan(Math.PI / 5));
    }
}
    
    
