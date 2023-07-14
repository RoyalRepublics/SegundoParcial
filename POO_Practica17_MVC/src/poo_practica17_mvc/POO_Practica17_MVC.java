package poo_practica17_mvc;

import Controller.Controlador;
import Model.Modelo;
import Vista.Vista;

/**
 *
 * @author miguel
 */
public class POO_Practica17_MVC {
 public static void main(String[] args) {
        Modelo mod = new Modelo();
        Vista vis = new Vista();
        Controlador con= new Controlador(vis,mod);
        con.Inicio();
        vis.setVisible(true);
    }
    
}
