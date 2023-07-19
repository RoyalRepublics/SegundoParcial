package jerarquia_empleados;
import java.util.Date;
import java.util.Scanner;

public class Director extends Empleado {
    private String departamento;
    private int personal;

    public Director(String nombre, int edad, Date fechaIngreso, double salario, String departamento, int personal) {
        super(nombre, edad, fechaIngreso, salario);
        this.departamento = departamento;
        this.personal = personal;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getPersonal() {
        return personal;
    }

    public void setPersonal(int personal) {
        this.personal = personal;
    }

    @Override
    public void incentivar() {
        if (getFechaIngreso().getMonth() >= 30 && getPersonal() > 20) {
            setSalario(getSalario() + (2 * BONO));
        } else if (getFechaIngreso().getMonth() >= 30 || getPersonal() > 20) {
            setSalario(getSalario() + BONO);
        }
    }

    @Override
    public Empleado crearEmpleado(Scanner scanner) {
        System.out.println("CREAR DIRECTOR");
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();
        System.out.print("Ingrese la fecha de ingreso (en formato yyyy-MM-dd): ");
        String fechaIngresoStr = scanner.next();
        Date fechaIngreso = java.sql.Date.valueOf(fechaIngresoStr);
        System.out.print("Ingrese el salario: ");
        double salario = scanner.nextDouble();
        System.out.print("Ingrese el departamento: ");
        String departamento = scanner.next();
        System.out.print("Ingrese el numero de personal a cargo: ");
        int personal = scanner.nextInt();

        return new Director(nombre, edad, fechaIngreso, salario, departamento, personal);
    }
}
