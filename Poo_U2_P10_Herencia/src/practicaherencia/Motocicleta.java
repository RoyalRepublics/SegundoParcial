/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaherencia;

/**
 *
 * @author miguel
 */
public class Motocicleta extends Vehiculo{
    int patadas;
@Override
 public void setOnStatus() {
        onStatus=true;
        System.out.println("Encendido");
        
        
    }
    public void setOffStatus() {
        this.onStatus = false;
        
        System.out.println("Apagado");
    }}