package poo_p2_pract3_try.pkgcatch.buffer;
import java.io.*;

public class POO_P2_PRACT3_TRYCATCHBUFFER {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String nombre = br.readLine();
            if (nombre.isEmpty()) { // Força um erro se a linha lida estiver vazia
                throw new IOException("Linha vazia");
            }
            System.out.println("Se ejecutó");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Hubo un error");
        }
    }
    
}
