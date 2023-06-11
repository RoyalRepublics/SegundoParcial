package practica4_readfile;
import java.io.*;

public class POO_P2_PRACT4_TRYCATCHLEERARCHIVOS {

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = null;
        String filePath = "fichero.txt";
        br = new BufferedReader(new FileReader(filePath));
        String linea;
        try {
            while((linea=br.readLine()) != null ){
                System.out.println(linea);
            }
        } catch (FileNotFoundException e){
            System.out.println("no existe el archivo");
        } catch (IOException e){
            System.out.println("Mmmm.. valio la plena");
        } catch (Exception e){
            System.out.println("Mmmm.. valio la plena Default");
        }
    }
    
}
