/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaherencia;

/**
 *
 * @author miguel
 */
public class Automovil extends Vehiculo{
    boolean parabrisas;

    
    public void setOnStatus(boolean onStatus) {
        onStatus=true;
        System.out.println("Encendido");
        
        
    }
    public void setOffStatus(boolean onStatus) {
        this.onStatus = false;
        
        System.out.println("Apagado");
    }}