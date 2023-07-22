package com.mycompany.evaluacionformativamolinamiguel;
public abstract class Laboratorio {
private String nombre;
private int capacidad;
private int equipos;
private String encargado;
private String profesor;
private String asignatura;
private String carrera;
private String horario;
    public Laboratorio(String nombre, int capacidad, int equipos, String encargado, String profesor, String Asignatura, String Carrera) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.equipos = equipos;
        this.encargado = encargado;
        this.profesor = profesor;
        this.asignatura = asignatura;
        this.carrera = carrera;
        this.horario=horario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEquipos() {
        return equipos;
    }

    public void setEquipos(int equipos) {
        this.equipos = equipos;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String Asignatura) {
        this.asignatura = Asignatura;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String Carrera) {
        this.carrera = carrera;
    }

public abstract void verificarDisponibilidad();
}
