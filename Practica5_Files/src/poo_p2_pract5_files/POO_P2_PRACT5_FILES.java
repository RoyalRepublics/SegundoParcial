package poo_p2_pract5_files;
import java.io.*;
public class POO_P2_PRACT5_FILES {
    public static void main(String[] args) throws IOException {

        String filePath = "fichero.txt";
        
        try{
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            
            bw.write("Hola que tal");
            bw.newLine();
            bw.write("Hi");
            bw.newLine();
            bw.write("Jjoto");
            bw.flush();
            bw.close();
            
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            
            String linea = br.readLine();
            while (linea != null){
                System.out.println(linea);
                linea = br.readLine();
            };
            br.close();
            System.out.println("Se ejecuto ");
                
        } catch (FileNotFoundException e){
            System.out.println("No se encuentra el archivo... " + e);
        } catch (IOException e){
            System.out.println("Hubo un error con el IO " + e);
        } catch (Exception e){
            System.out.println("Hubo un error " + e);
        }
                
    }
    
}
