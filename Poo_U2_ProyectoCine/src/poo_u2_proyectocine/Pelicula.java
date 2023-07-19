package poo_u2_proyectocine;
import java.io.Serializable;

public class Pelicula implements Serializable {
    private String titulo;
    private String genero;
    private int duracion;

    public Pelicula(String titulo, String genero, int duracion) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Película: " + titulo + ", Género: " + genero + ", Duración: " + duracion + " minutos";
    }
}