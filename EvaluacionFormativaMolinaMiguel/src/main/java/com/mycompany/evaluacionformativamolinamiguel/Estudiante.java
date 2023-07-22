package com.mycompany.evaluacionformativamolinamiguel;

import java.util.Scanner;

public class Estudiante extends Personal{
    private int semestre;
    private String Carrera;
    Scanner sc=new Scanner(System.in);
    public Estudiante(int semestre, String Carrera, String nombre, long cedula, int edad, String correo) {
        super(nombre, cedula, edad, correo);
        this.semestre = semestre;
        this.Carrera = Carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
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
        setSemestre(sc.nextInt());      
        System.out.println("Ingrese la carrera del Estudiante");
        setCarrera(sc.nextLine());
    }
    
}
