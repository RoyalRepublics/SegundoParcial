package practicapoo_banksystem;
import java.util.Scanner;
public class PracticaPOO_BANKSYSTEM {   
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Indique el monto del retiro:");
        Cuentalimitada c1=new Cuentalimitada(0.0);
        c1.salidaCapital(sc.nextDouble());

    }
}