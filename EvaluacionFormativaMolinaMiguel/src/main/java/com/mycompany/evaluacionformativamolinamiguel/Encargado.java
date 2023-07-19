package com.mycompany.evaluacionformativamolinamiguel;

import java.util.Scanner;

public class Encargado extends Personal{
    Scanner sc=new Scanner(System.in);
    private String contrato;

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public Encargado(String contrato, String nombre, long cedula, int edad, String correo) {
        super(nombre, cedula, edad, correo);
        this.contrato = contrato;
    }


    @Override
    public void registroPersonal() {
        System.out.println("Ingrese el nombre del Encargado");
        setNombre(sc.nextLine());
        System.out.println("Ingrese la cedula del Encargado");
        setCedula(sc.nextLong());
        System.out.println("Ingrese la edad del Encargado");
        setEdad(sc.nextInt());
        System.out.println("Ingrese el correo del Encargado");
        setCorreo(sc.nextLine());        
        System.out.println("Ingrese el tipo de contrato del Encargado");
        setContrato(sc.nextLine());
    }
    
}
