package com.mycompany.evaluacionformativamolinamiguel;
import java.util.Scanner;
public class LaboratorioComputacion extends Laboratorio{
    Scanner sc=new Scanner(System.in);
    String tipo;
    String espacio;
    String lugar;

    public LaboratorioComputacion(String tipo, String espacio, String lugar, String nombre, int capacidad, int equipos, String encargado, String profesor, String Asignatura, String Carrera) {
        super(nombre, capacidad, equipos, encargado, profesor, Asignatura, Carrera);
        this.tipo = tipo;
        this.espacio = espacio;
        this.lugar = lugar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspacio() {
        return espacio;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public void verificarDisponibilidad() {
        if(getHorario()==sc.nextLine()){
        System.out.println("laboratorio disponible para este horario");}
        else{
        System.out.println("Laboratorio no disponible para el horario");}
        
    }
    
}
