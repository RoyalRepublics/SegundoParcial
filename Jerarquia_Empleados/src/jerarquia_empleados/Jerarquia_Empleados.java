package jerarquia_empleados;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Jerarquia_Empleados {
    public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);
        int opcion;
        List<Empleado> empleados = new ArrayList<>();

        do {
            System.out.println("MENU");
            System.out.println("1. Crear Director");
            System.out.println("2. Crear Operario");
            System.out.println("3. Incentivar Empleado");
            System.out.println("4. Actualizar Nivel del Operario");
            System.out.println("5. Mostrar Datos de Empleados");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    empleados.add(new Director("", 0, null, 0, "", 0).crearEmpleado(scanner));
                    System.out.println("Director creado.");
                    break;
                case 2:
                    empleados.add(new Operario("", 0, null, 0, 0).crearEmpleado(scanner));
                    System.out.println("Operario creado.");
                    break;
                case 3:
                    System.out.println("Seleccione un empleado para incentivar:");
                    mostrarEmpleados(empleados);
                    int empleadoIndex = scanner.nextInt();
                    if (empleadoIndex >= 0 && empleadoIndex < empleados.size()) {
                        Empleado empleadoSeleccionado = empleados.get(empleadoIndex);
                        empleadoSeleccionado.incentivar();
                        System.out.println("Empleado incentivado: " + empleadoSeleccionado.getNombre());
                    } else {
                        System.out.println("Opcion inválida.");
                    }
                    break;
                case 4:
                    System.out.println("Seleccione un operario para actualizar el nivel:");
                    mostrarOperarios(empleados);
                    int operarioIndex = scanner.nextInt();
                    if (operarioIndex >= 0 && operarioIndex < empleados.size()) {
                        Empleado empleadoSeleccionado = empleados.get(operarioIndex);
                        if (empleadoSeleccionado instanceof Operario) {
                            Operario operario = (Operario) empleadoSeleccionado;
                            operario.actualizarNivel();
                            System.out.println("Nivel del operario actualizado: " + operario.getNombre());
                        } else {
                            System.out.println("El empleado seleccionado no es un operario.");
                        }
                    } else {
                        System.out.println("Opcion inválida.");
                    }
                    break;
                case 5:
                    mostrarEmpleados(empleados);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion inválida.");
            }

            System.out.println();
        } while (opcion != 6);
    }

    public static void mostrarEmpleados(List<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("DATOS DE EMPLEADOS:");
            for (int i = 0; i < empleados.size(); i++) {
                Empleado empleado = empleados.get(i);
                System.out.println((i + 1) + ". Empleado:");
                System.out.println("   Nombre: " + empleado.getNombre());
                System.out.println("   Edad: " + empleado.getEdad());
                System.out.println("   Fecha de Ingreso: " + empleado.getFechaIngreso());
                System.out.println("   Salario: " + empleado.getSalario());
                if (empleado instanceof Director) {
                    Director director = (Director) empleado;
                    System.out.println("   Departamento: " + director.getDepartamento());
                    System.out.println("   Personal a Cargo: " + director.getPersonal());
                } else if (empleado instanceof Operario) {
                    Operario operario = (Operario) empleado;
                    System.out.println("   Nivel: " + operario.getNivel());
                }
                System.out.println();
            }
        }
    }

    public static void mostrarOperarios(List<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("OPERARIOS DISPONIBLES:");
            for (int i = 0; i < empleados.size(); i++) {
                Empleado empleado = empleados.get(i);
                if (empleado instanceof Operario) {
                    System.out.println((i + 1) + ". " + empleado.getNombre());
                }
            }
        }
    }
}