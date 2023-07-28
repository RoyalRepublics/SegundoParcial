package poo_proyect_u2;
import Controlador.*;
import Modelo.*;
import Vista.*;
/**
 *
 * @author AnitaVit
 */
public class POO_Proyect_U2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaCine vista = new VistaCine(); // Instanciar la clase VistaCine
        Pelicula pelicula = new Pelicula("","","",""); // Instanciar la clase Pelicula
        Sala sala = new Sala(0,false,""); // Instanciar la clase Sala

        ControladorCine controlador = new ControladorCine(vista,pelicula,sala); // Instanciar el controlador

        vista.setVisible(true); // Mostrar la interfaz gráfica
    }
    }
    

