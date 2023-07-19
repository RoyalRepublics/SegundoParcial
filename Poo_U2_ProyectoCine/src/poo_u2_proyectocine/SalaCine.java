package poo_u2_proyectocine;
public class SalaCine extends Sala {
    private String formatoPantalla;

    public SalaCine(String nombre, int capacidad, String formatoPantalla) {
        super(nombre, capacidad);
        this.formatoPantalla = formatoPantalla;
    }

    public String getFormatoPantalla() {
        return formatoPantalla;
    }

    public void setFormatoPantalla(String formatoPantalla) {
        this.formatoPantalla = formatoPantalla;
    }

    @Override
    public String toString() {
        return super.toString() + ", Formato de Pantalla: " + formatoPantalla;
    }
}