package tareapoohorarios;

import java.util.Scanner;

public class TareaPOOHORARIOS {
  private static Scanner scanner = new Scanner(System.in);
    private static Laboratorio[] laboratorios;
    private static Asignatura[] asignaturas;
    private static int cantidadLaboratorios;
    private static int cantidadAsignaturas;
    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }

    private static void mostrarMenuPrincipal() {
        boolean salir = false;

        while (!salir) {
            System.out.println("          INSTITUCION EDUCATIVA \n JUNTOS POR LA EDUCACIÓN TECNOLÓGICA SUPERIOR");
            System.out.println("--- Menú Principal ---");
            System.out.println("1. Agregar laboratorios");
            System.out.println("2. Asignar horarios a asignaturas");
            System.out.println("3. Mostrar información de los laboratorios");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción deseada: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarLaboratorios();
                    break;
                case 2:
                    asignarHorarios();
                    break;
                case 3:
                    mostrarInformacionLaboratorios();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private static void agregarLaboratorios() {
        System.out.print("Ingrese la cantidad de laboratorios: ");
        cantidadLaboratorios = scanner.nextInt();
        scanner.nextLine(); 

        laboratorios = new Laboratorio[cantidadLaboratorios];

        for (int i = 0; i < cantidadLaboratorios; i++) {
            System.out.println("Laboratorio " + (i + 1));

            System.out.print("Ingrese el nombre del laboratorio: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la capacidad máxima de estudiantes: ");
            int capacidad = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Ingrese la cantidad de equipos: ");
            int cantidadEquipos = scanner.nextInt();
            scanner.nextLine(); 

            String[] equipos = new String[cantidadEquipos];
            for (int j = 0; j < cantidadEquipos; j++) {
                System.out.print("Ingrese el nombre del equipo " + (j + 1) + ": ");
                equipos[j] = scanner.nextLine();
            }

            System.out.print("Ingrese el tipo de laboratorio (1 o 2): ");
            int tipoLaboratorio = scanner.nextInt();
            scanner.nextLine();

            if (tipoLaboratorio == 1) {
                System.out.print("Ingrese el espacio del laboratorio 1: ");
                String espacio = scanner.nextLine();
                laboratorios[i] = new Laboratorio1(nombre, capacidad, equipos, espacio);
            } else if (tipoLaboratorio == 2) {
                System.out.print("Ingrese el lugar del laboratorio 2: ");
                String lugar = scanner.nextLine();
                laboratorios[i] = new Laboratorio2(nombre, capacidad, equipos, lugar);
            } else {
                System.out.println("Tipo de laboratorio inválido");
            }
        }
    }

    private static void asignarHorarios() {
        System.out.print("Ingrese la cantidad de asignaturas: ");
        cantidadAsignaturas = scanner.nextInt();
        scanner.nextLine(); 

        asignaturas = new Asignatura[cantidadAsignaturas];

        for (int i = 0; i < cantidadAsignaturas; i++) {
            System.out.println("Asignatura " + (i + 1));

            System.out.print("Ingrese el nombre de la asignatura: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el horario de la asignatura: ");
            String horario = scanner.nextLine();

            System.out.print("Ingrese el número del laboratorio asignado (1-" + cantidadLaboratorios + "): ");
            int numeroLaboratorio = scanner.nextInt();
            scanner.nextLine(); 

            if (numeroLaboratorio >= 1 && numeroLaboratorio <= cantidadLaboratorios) {
                Laboratorio laboratorioAsignado = laboratorios[numeroLaboratorio - 1];
                asignaturas[i] = new Asignatura(nombre, horario, laboratorioAsignado);
            } else {
                System.out.println("Número de laboratorio inválido");
            }
        }
    }

    private static void mostrarInformacionLaboratorios() {
        System.out.println("\nInformación de los laboratorios:");

        for (Laboratorio laboratorio : laboratorios) {
            System.out.println("Nombre: " + laboratorio.getNombre());
            System.out.println("Capacidad: " + laboratorio.getCapacidad());
            System.out.println("Equipos:");

            for (String equipo : laboratorio.getEquipos()) {
                System.out.println("- " + equipo);
            }

            if (laboratorio instanceof Laboratorio1) {
                Laboratorio1 lab1 = (Laboratorio1) laboratorio;
                System.out.println("Espacio: " + lab1.getEspacio());
            } else if (laboratorio instanceof Laboratorio2) {
                Laboratorio2 lab2 = (Laboratorio2) laboratorio;
                System.out.println("Lugar: " + lab2.getLugar());
            }

            System.out.println();
        }
    }
}