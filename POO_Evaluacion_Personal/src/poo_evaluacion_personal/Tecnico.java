package poo_evaluacion_personal;
//clase de personal tecnico registra la especialidad del tecnico
public class Tecnico  extends Personal2{
    private String especialidad;
//constructor para la clase tecnico combina el construtor de la clase padre
    public Tecnico(String especialidad, String nombre, long cedula, String Correo, double sueldo, double cantidadbonos) {
        super(nombre, cedula, Correo, sueldo, cantidadbonos);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
//sobre escritura del metodo calcularsueldo.
    @Override
    public double calcularsueldo() {
    setSueldo(calcularmeritos()+700);
        return getSueldo();
    }
//sobre escritura del metodo calcular meritos.
    @Override
    public double calcularmeritos() {
        double valor;
        System.out.println("tiene el tecnico incentivos? (1 para si, 2 para no)");
        
        if((sc.nextInt())==1){
        System.out.println("Ingrese el valor por merito del tecnico");
        valor=sc.nextDouble();
        System.out.println("Ingrese la cantidad de meritos del tecnico");
        setCantidadbonos(sc.nextInt());
        valor=getCantidadbonos()*valor;}
                    else{valor=0;}
        return valor;
    }
}
