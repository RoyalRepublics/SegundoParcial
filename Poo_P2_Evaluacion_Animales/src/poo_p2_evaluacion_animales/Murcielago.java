package poo_p2_evaluacion_animales;

public class Murcielago extends Animales{
    String vision;
    String Region;
    String subEspecie;

    public Murcielago(String vision, String Region, String subEspecie, String Especie, String Habitat, String horario, String Dieta, int numPatas) {
        super(Especie, Habitat, horario, Dieta, numPatas);
        this.vision = vision;
        this.Region = Region;
        this.subEspecie = subEspecie;
    }
    @Override
    public void mostrarDatos(){
        System.out.println("Info del Animal:");
        System.out.println("Especie: " + this.getEspecie());
        System.out.println("Habitat: " + this.getHabitat());
        System.out.println("Horario: " + this.getHorario());
        System.out.println("Dieta: " + this.getDieta());        
        System.out.println("Numero de Patas: " + this.getNumPatas());
        System.out.println("Vision: " + this.getVision());
        System.out.println("Region: " + this.getRegion());
        System.out.println("sub Especie: " + this.getSubEspecie());
    }
    
    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getSubEspecie() {
        return subEspecie;
    }

    public void setSubEspecie(String subEspecie) {
        this.subEspecie = subEspecie;
    }
}