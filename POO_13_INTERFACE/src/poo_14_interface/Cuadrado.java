package poo_14_interface;

/**
 *
 * @author miguel
 */
public class Cuadrado implements Figura{
double lado;
public Cuadrado (double lado){
this.lado=lado;}
    @Override
   public double CalcularArea(){
   double resul=lado*lado;
       return resul;
   }
    
}
