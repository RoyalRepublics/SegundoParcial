
package poo_14_interface;
public class Circulo implements Figura,Dibujar,Rotar{
double r;
public Circulo (double r){
this.r=r;}
@Override
public double CalcularArea(){  
    double resul=Math.PI*r*r;
    return resul;}
@Override
public void Dibujar(){
    System.out.println("Usted va a dibujar");}
@Override
public void Rotar(){
    System.out.println("Usted va a rotar");
    }
}