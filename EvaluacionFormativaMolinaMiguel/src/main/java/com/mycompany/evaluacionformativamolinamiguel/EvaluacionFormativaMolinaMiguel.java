package com.mycompany.evaluacionformativamolinamiguel;

import java.util.Scanner;

public class EvaluacionFormativaMolinaMiguel {

    public static void main(String[] args) {
        int op=0;
        Scanner sc=new Scanner(System.in);
        Encargado en=new Encargado("","",0,0,"");
        Profesor pr=new Profesor("","","",0,0,"");
        Estudiante es=new Estudiante(0,"","",0,0,"");
        LaboratorioCiencias labc=new LaboratorioCiencias("","","","",0,0,"","","","");
        LaboratorioComputacion labCom=new LaboratorioComputacion("","","","",0,0,"","","","");
        while(op!=5){
            System.out.println("Escoja la opcion que desea.");
            System.out.println("1. Añadir Encargado");
            System.out.println("2. Añadir Profesor.");
            System.out.println("3. Añadir Estudiante.");
            System.out.println("Escoja la opcion que desea.");
            
            switch (op){
                case 1:
                    en.registroPersonal();
                    break;
                case 2:
                    
            
            
            }
        }
    }
}
