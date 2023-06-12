
package poo_u2_p8_herencia2;

public class Deportista extends Persona {
    String Deporte;
    public Deportista(String nombre){
    super.setNombre(nombre);
    
    }   
public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
