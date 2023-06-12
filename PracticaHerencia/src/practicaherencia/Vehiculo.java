
package practicaherencia;
public class Vehiculo {
String Placa;
int numRuedas;
boolean onStatus;
String Status;

    public Vehiculo(String Placa, int numRuedas, boolean onStatus, String Status) {
        this.Placa = Placa;
        this.numRuedas = numRuedas;
        this.onStatus = onStatus;
        this.Status = Status;
    }

    public void setOnStatus(boolean onStatus) {
        onStatus=true;
        System.out.println("Encendido");
        
        
    }
    public void setOffStatus(boolean onStatus) {
        this.onStatus = false;
        
        System.out.println("Apagado");
    }
}
 