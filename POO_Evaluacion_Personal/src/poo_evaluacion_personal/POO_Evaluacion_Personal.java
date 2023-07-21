package poo_evaluacion_personal;

import java.util.Scanner;

public class POO_Evaluacion_Personal {
    public static void main(String[] args) {
        //instancia del metodo scanner para registrar por teclado
        Scanner sc=new Scanner(System.in);
        
            //inicializacion de los objetos que se van a registrar
        Docente dc=new Docente("","",0,"",0,0);
        Tecnico tc=new Tecnico("","",0,"",0,0);
        Administrativo ad=new Administrativo("","",0,"",0,0);
        Limpieza lim=new Limpieza("","",0,"",0,0);

        int op=0,aux=0;
        while(op!=6){
            //menu para la generacion de los registros
            System.out.println("Menu de opciones");
            System.out.println("1. Calcular el sueldo de un empleado Docente");
            System.out.println("2. Calcular el sueldo de un empleado Tecnico");
            System.out.println("3. Calcular el sueldo de un empleado Administrativo");
            System.out.println("4. Calcular el sueldo de un empleado de Limpieza");
            System.out.println("5. Mostrar ultimo registro");
            System.out.println("6. Salir");
            System.out.println("Escoja su opcion: ");
        op=sc.nextInt();
            switch(op){
                //programacion del caso 1
                case 1:
                    aux=1;
                    System.out.println("Ingrese el nombre del docente:");
                    sc.nextLine(); //consumo de linea
                    dc.setNombre(sc.nextLine());
                    System.out.println("Ingrese el numero de cedula del docente: ");
                    dc.setCedula(sc.nextLong());
                    sc.nextLine();
                    
                    System.out.println("Ingrese el correo del docente: ");
                    dc.setCorreo(sc.nextLine());
                    System.out.println("Ingrese el titulo del docente: ");
                    dc.setTitulo(sc.nextLine());
                    dc.calcularsueldo();
                    
                    break;
                    //programacion del caso 2 
                case 2:
                    System.out.println("Ingrese el nombre del tecnico:");
                    sc.nextLine(); //consumo de linea
                    tc.setNombre(sc.nextLine());
                    System.out.println("Ingrese el numero de cedula del tecnico: ");
                    tc.setCedula(sc.nextLong());
                    sc.nextLine();
                    System.out.println("Ingrese el correo del tecnico: ");
                    tc.setCorreo(sc.nextLine());
                    System.out.println("Ingrese la especialidad del tecnico: ");
                    tc.setEspecialidad(sc.nextLine());
                    tc.calcularsueldo();
                   
                    aux=2;
                    break;
                   //programacion del caso3
                case 3:
                    aux=3;
                   
                    System.out.println("Ingrese el nombre del Administrativo:");
                    sc.nextLine(); //consumo de linea
                    ad.setNombre(sc.nextLine());
                    System.out.println("Ingrese el numero de cedula del Administrativo: ");
                    ad.setCedula(sc.nextLong());
                    sc.nextLine();
                    System.out.println("Ingrese el correo del Administrativo: ");
                    ad.setCorreo(sc.nextLine());
                    System.out.println("Ingrese el area del Administrativo: ");
                    ad.setArea(sc.nextLine());
                    ad.calcularsueldo();
                    
                    break;
                    //programacion del caso4
                case 4:
                    aux=4;
                    System.out.println("Ingrese el nombre del Limpieza:");
                    sc.nextLine(); //consumo de linea
                    lim.setNombre(sc.nextLine());
                    System.out.println("Ingrese el numero de cedula del Limpieza: ");
                    lim.setCedula(sc.nextLong());
                    sc.nextLine();
                    System.out.println("Ingrese el correo del Limpieza: ");
                    lim.setCorreo(sc.nextLine());
                    System.out.println("Ingrese la empresa del Limpieza: ");
                    lim.setEmpresa(sc.nextLine());
                    lim.calcularsueldo();
                    
                    break;
                    //programacion del caso5
                case 5:
                    //en el caso 5 se hace un switch con la variable auxiliar que ha cambiado de valor segun los casos del
                    //switch principal.
                    switch(aux){
                        case 1:
                    System.out.println("Docente nombre: "+dc.getNombre());
                    System.out.println("Docente cedula: "+dc.getCedula());
                    System.out.println("Docente correo: "+dc.getCorreo());
                    System.out.println("Docente Titulo: "+dc.getTitulo());
                    System.out.println("Docente sueldo: "+dc.getSueldo());
                    break;
                        case 2:
                            System.out.println("Tecnico nombre: "+tc.getNombre());
                    System.out.println("Tecnico cedula: "+tc.getCedula());
                    System.out.println("Tecnico correo: "+tc.getCorreo());
                    System.out.println("Tecnico especialidad: "+tc.getEspecialidad());
                    System.out.println("Tecnico sueldo: "+tc.getSueldo());
                    break;
                    
                    case 3:
                            System.out.println("Administrativo nombre: "+ad.getNombre());
                    System.out.println("Administrativo cedula: "+ad.getCedula());
                    System.out.println("Administrativo correo: "+ad.getCorreo());
                    System.out.println("Administrativo Area: "+ad.getArea());
                    System.out.println("Administrativo sueldo: "+ad.getSueldo());
                    break;
                    case 4:
                            System.out.println("Limpieza nombre: "+lim.getNombre());
                    System.out.println("Limpieza cedula: "+lim.getCedula());
                    System.out.println("Limpieza correo: "+lim.getCorreo());
                    System.out.println("Limpieza empresa: "+lim.getEmpresa());
                    System.out.println("Limpieza sueldo: "+lim.getSueldo());
                    break;
                    default:
                    System.out.println("No se han ingresado datos");}
                    break;
                default:
                   
                    System.out.println("Opcion incorrecta");
                    break;
                    
        }
        }
        }
    }
