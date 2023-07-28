package Modelo;


public abstract class ModeloCine{
    private String Nombre;

    public ModeloCine(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
   
 
  
}
