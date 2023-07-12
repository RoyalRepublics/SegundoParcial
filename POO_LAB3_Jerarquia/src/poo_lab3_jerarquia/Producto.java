package poo_lab3_jerarquia;

/**
 *
 * @author miguel
 */
//clase abstracta producto
public abstract class Producto {
    private String Nombre;
    private double Precio;
    
    public Producto(){
}
// constructor clase producto
    public Producto(String Nombre, double Precio) {
        this.Nombre = Nombre;
        this.Precio = Precio;
    }
// getters and setters
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    //metodo abstracto de la clase producto.
    public abstract double obtenePrecioPedido(Double Precio);
}
