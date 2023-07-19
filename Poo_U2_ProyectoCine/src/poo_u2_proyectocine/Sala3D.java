package poo_u2_proyectocine;
public class Sala3D extends Sala {
    private boolean lentesIncluidos;

    public Sala3D(String nombre, int capacidad, boolean lentesIncluidos) {
        super(nombre, capacidad);
        this.lentesIncluidos = lentesIncluidos;
    }

    public boolean isLentesIncluidos() {
        return lentesIncluidos;
    }

    public void setLentesIncluidos(boolean lentesIncluidos) {
        this.lentesIncluidos = lentesIncluidos;
    }

    @Override
    public String toString() {
        return super.toString() + ", Lentes Incluidos: " + lentesIncluidos;
    }
}