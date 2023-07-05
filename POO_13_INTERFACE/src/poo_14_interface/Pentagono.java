
package poo_14_interface;

/**
 *
 * @author miguel
 */
public class Pentagono implements Figura,Dibujar,Rotar{
    double lado;
    public Pentagono(double lado){
    this.lado=lado;}
            
    @Override
    public double CalcularArea() {
        double resul =(5 * lado * lado) / (4 * Math.tan(Math.PI / 5));
        return resul;
    }
    @Override
public void Dibujar(){
    System.out.println("Usted va a dibujar");}
@Override
public void Rotar(){
    System.out.println("Usted va a rotar");
    }
}
