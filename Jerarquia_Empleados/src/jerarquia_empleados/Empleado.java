package jerarquia_empleados;
import java.util.Date;
import java.util.Scanner;

public abstract class Empleado {
    private String nombre;
    private int edad;
    private Date fechaIngreso;
    private double salario;
    public static final double BONO = 1000.0;

    public Empleado(String nombre, int edad, Date fechaIngreso, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public abstract void incentivar();

    public abstract Empleado crearEmpleado(Scanner scanner);
}