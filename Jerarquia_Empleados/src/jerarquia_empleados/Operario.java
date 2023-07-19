package jerarquia_empleados;

import java.util.Date;
import java.util.Scanner;

public class Operario extends Empleado {
    private int nivel;

    public Operario(String nombre, int edad, Date fechaIngreso, double salario, int nivel) {
        super(nombre, edad, fechaIngreso, salario);
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public void incentivar() {
        if (getEdad() > 30 && getNivel() > 2) {
            setSalario(getSalario() + (2 * BONO));
        } else if (getEdad() > 30 || getNivel() > 2) {
            setSalario(getSalario() + BONO);
        }
    }

    @Override
    public Empleado crearEmpleado(Scanner scanner) {
        System.out.println("CREAR OPERARIO");
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();
        System.out.print("Ingrese la fecha de ingreso (en formato yyyy-MM-dd): ");
        String fechaIngresoStr = scanner.next();
        Date fechaIngreso = java.sql.Date.valueOf(fechaIngresoStr);
        System.out.print("Ingrese el salario: ");
        double salario = scanner.nextDouble();
        System.out.print("Ingrese el nivel de seguridad (entre 1 y 5): ");
        int nivel = scanner.nextInt();

        return new Operario(nombre, edad, fechaIngreso, salario, nivel);
    }

    public void actualizarNivel() {
        if (getNivel() < 5) {
            setNivel(getNivel() + 1);
        }
    }
}