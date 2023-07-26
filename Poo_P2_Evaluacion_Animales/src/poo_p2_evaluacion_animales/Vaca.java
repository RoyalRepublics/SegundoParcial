package poo_p2_evaluacion_animales;

public class Vaca extends Animales {
String Raza;
String Colores;
String codigoLetra;

    public Vaca(String Raza, String Colores, String codigoLetra, String Especie, String Habitat, String horario, String Dieta, int numPatas) {
        super(Especie, Habitat, horario, Dieta, numPatas);
        this.Raza = Raza;
        this.Colores = Colores;
        this.codigoLetra = codigoLetra;
    }
    
    @Override
    public void mostrarDatos(){
        System.out.println("Info del Animal:");
        System.out.println("Especie: " + this.getEspecie());
        System.out.println("Habitat: " + this.getHabitat());
        System.out.println("Horario: " + this.getHorario());
        System.out.println("Dieta: " + this.getDieta());        
        System.out.println("Numero de Patas: " + this.getNumPatas());
        System.out.println("Raza: " + this.getRaza());
        System.out.println("Colores: " + this.getColores());
        System.out.println("codigo de Letras: " + this.getCodigoLetra());
    }
    
    public String getRaza() {
        return Raza;
    }

    public void setRaza(String Raza) {
        this.Raza = Raza;
    }

    public String getColores() {
        return Colores;
    }

    public void setColores(String Colores) {
        this.Colores = Colores;
    }

    public String getCodigoLetra() {
        return codigoLetra;
    }

    public void setCodigoLetra(String codigoLetra) {
        this.codigoLetra = codigoLetra;
    }

}