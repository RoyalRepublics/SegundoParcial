package poo_evaluacion_personal;
//clase abstracta de la clase padre para las clases hijas
import java.util.Scanner;

public abstract class Personal2 implements Personal{
    //atributos heredables para las clases hijas
    Scanner sc=new Scanner(System.in);
private String nombre;
    private long cedula;
    private String Correo;
    private double sueldo;
    private double cantidadbonos;
    //constructor de la clase padre
    public Personal2(String nombre, long cedula, String Correo, double sueldo, double cantidadbonos) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.Correo = Correo;
        this.sueldo = sueldo;
        this.cantidadbonos = cantidadbonos;
    }
//getters y setters 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getCantidadbonos() {
        return cantidadbonos;
    }

    public void setCantidadbonos(double cantidadbonos) {
        this.cantidadbonos = cantidadbonos;
    }
    
}
