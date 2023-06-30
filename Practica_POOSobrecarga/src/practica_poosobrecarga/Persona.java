
package practica_poosobrecarga;
public class Persona {
    String nombre;
    int edad;
    long cedula;
        //Sobrecarga de constructores...
    public Persona (String nombre, int edad){
    this.nombre=nombre;
    this.edad=edad;
    }
    public Persona(long cedula){
    this.cedula=cedula;
    }
    //metodos
    public void jugar(){
    System.out.println("Mi nombre es: "+nombre+" voy a jugar.");
    
    }
    public void jugar(String juego){
    System.out.println("voy a jugar "+juego+", me gusta mucho");
    }
}
