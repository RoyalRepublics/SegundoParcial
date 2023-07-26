package poo_p2_evaluacion_animales;
public class Animales {
    String Especie;
    String Habitat;
    String horario;
    String Dieta;
    int numPatas;

    public Animales(String Especie, String Habitat, String horario, String Dieta, int numPatas) {
        this.Especie = Especie;
        this.Habitat = Habitat;
        this.horario = horario;
        this.Dieta = Dieta;
        this.numPatas = numPatas;
    }
public void mostrarDatos(){
        System.out.println("Info del Animal:");
        System.out.println("Especie: " + this.getEspecie());
        System.out.println("Habitat: " + this.getHabitat());
        System.out.println("Horario: " + this.getHorario());
        System.out.println("Dieta: " + this.getDieta());        
        System.out.println("Numero de Patas: " + this.getNumPatas());
    }
    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String Especie) {
        this.Especie = Especie;
    }

    public String getHabitat() {
        return Habitat;
    }

    public void setHabitat(String Habitat) {
        this.Habitat = Habitat;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDieta() {
        return Dieta;
    }

    public void setDieta(String Dieta) {
        this.Dieta = Dieta;
    }

    public int getNumPatas() {
        return numPatas;
    }

    public void setNumPatas(int numPatas) {
        this.numPatas = numPatas;
    }
            
}