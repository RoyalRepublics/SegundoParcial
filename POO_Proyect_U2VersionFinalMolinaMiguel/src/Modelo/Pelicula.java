package Modelo;
public class Pelicula extends ModeloCine{
  String rateP;
  String directorP;
  String duracionP;
    public Pelicula(String rateP, String directorP, String duracionP, String Nombre) {
        super(Nombre);
        this.rateP = rateP;
        this.directorP = directorP;
        this.duracionP = duracionP;
    }
    public String getRateP() {
        return rateP;
    }

    public void setRateP(String rateP) {
        this.rateP = rateP;
    }
    public String getDirectorP() {
        return directorP;
    }
    public void setDirectorP(String directorP) {
        this.directorP = directorP;
    }
    public String getDuracionP() {
        return duracionP;
    }
    public void setDuracionP(String duracionP) {
        this.duracionP = duracionP;
    }  
}
