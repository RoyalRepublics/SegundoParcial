package poo_u2_proyectocine;
import java.io.Serializable;

public abstract class Sala implements Serializable {
    private String nombre;
    private int capacidad;

    public Sala(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Sala: " + nombre + ", Capacidad: " + capacidad;
    }
}