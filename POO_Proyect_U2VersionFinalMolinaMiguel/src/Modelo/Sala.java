package Modelo;

public class Sala extends ModeloCine{
    private int capacidadS;
    private boolean tipoS;

    public Sala(int capacidadS, boolean tipoS, String Nombre) {
        super(Nombre);
        this.capacidadS = capacidadS;
        this.tipoS = tipoS;
    }


    public int getCapacidadS() {
        return capacidadS;
    }

    public void setCapacidadS(int capacidadS) {
        this.capacidadS = capacidadS;
    }

    public boolean getTipoS() {
        return tipoS;
    }

    public void setTipoS(boolean tipoS) {
        this.tipoS = tipoS;
    }

    
}
