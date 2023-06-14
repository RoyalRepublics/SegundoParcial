
package practicaherencia;

public class PracticaHerencia {

    public static void main(String[] args) {

        Automovil auto = new Automovil();
        Vehiculo vehi= new Vehiculo();
        Motocicleta moto=new Motocicleta();
        auto.Placa="PZM0353";
        auto.numRuedas=4;
        auto.setOnStatus();
        auto.Placa="TBD06703";
        auto.numRuedas=2;
        auto.setOffStatus();
        
               System.out.println(auto.Placa+" "+auto.numRuedas+" "+auto.onStatus);
               
               System.out.println(moto.onStatus);
               
               System.out.println(vehi.onStatus);
               
    }
    
}
