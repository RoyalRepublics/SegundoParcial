package poo_u2_15_ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author miguel
 */
public class ManejoArchivos {
    public static void crearArchivo(String nombArchivo){
        File Archivo = new File(nombArchivo);
        try{
            PrintWriter salida = new PrintWriter(Archivo);
            salida.close();
            System.out.println("Se creo el archivo correctamente");
            
        }catch(FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }
    public static void leerArchivo(String nombArchivo, String contenido){
        File Archivo = new File(nombArchivo);
        try{
            BufferedReader entrada = new BufferedReader(new FileReader(Archivo));
            String lectura=entrada.readLine();
            while(lectura!=null);{System.out.println(lectura);
        lectura=entrada.readLine();
        }
            entrada.close();
            System.out.println("archivo leido");
            
        }catch(FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
        catch(IOException ex){
            ex.printStackTrace(System.out);
        }
    }
    public static void eliminarArchivo(String nombArchivo, String contenido){
        File Archivo = new File(nombArchivo);
        System.out.println(Archivo.exists());
        Archivo.delete();
        System.out.println("Archivo eliminado...");
        
    }
    
}
