package poo_u2_proyectocine;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author AnitaVit
 */
public class Poo_U2_ProyectoCine {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
       ControladorCine controlador = new ControladorCine("salas.dat");
        VistaCine vista = new VistaCine(controlador);
    }
}