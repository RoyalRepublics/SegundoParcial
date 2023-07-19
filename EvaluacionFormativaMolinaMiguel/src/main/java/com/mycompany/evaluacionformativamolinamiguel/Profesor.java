package com.mycompany.evaluacionformativamolinamiguel;

import java.util.Scanner;

public class Profesor extends Personal{
    private String asignatura;
    private String titulo;
    Scanner sc=new Scanner(System.in);
    public Profesor(String asignatura, String titulo, String nombre, long cedula, int edad, String correo) {
        super(nombre, cedula, edad, correo);
        this.asignatura = asignatura;
        this.titulo = titulo;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Override
    public void registroPersonal() {
        System.out.println("Ingrese el nombre del Estudiante");
        setNombre(sc.nextLine());
        System.out.println("Ingrese la cedula del Estudiante");
        setCedula(sc.nextLong());
        System.out.println("Ingrese la edad del Estudiante");
        setEdad(sc.nextInt());
        System.out.println("Ingrese el correo del Estudiante");
        setCorreo(sc.nextLine());        
        System.out.println("Ingrese el semestre del Estudiante");
        setAsignatura(sc.nextLine());      
        System.out.println("Ingrese la carrera del Estudiante");
        setTitulo(sc.nextLine());
    }
}
