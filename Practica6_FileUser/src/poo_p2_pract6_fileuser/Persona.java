package poo_p2_pract6_fileuser;

public class Persona {
    private String nombre;
    private String telefon;
    private String email;
    
    public Persona(String nombre, String telefono, String email){
        this.nombre = nombre;
        this.telefon = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
