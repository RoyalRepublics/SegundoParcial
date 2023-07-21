package poo_evaluacion_personal;
//clase de personal de limpieza, va a registrar de que empresa viene este empleado, ya que por lo general son tercerizados
public class Limpieza extends Personal2{

    public Limpieza(String empresa, String nombre, long cedula, String Correo, double sueldo, double cantidadbonos) {
        super(nombre, cedula, Correo, sueldo, cantidadbonos);
        this.empresa = empresa;
    }
    
   private String empresa;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
   //sobreescritura del metodo de calcular el sueldo
    @Override
    public double calcularsueldo() {
    setSueldo(calcularmeritos()+500);
        return getSueldo();
    }
//sobre escritura del metodo de calcular los meritos que ha ganado el empleado
    @Override
    public double calcularmeritos() {
        double valor;
        System.out.println("tiene el limpieza incentivos? (1 para si, 2 para no)");
        
        if((sc.nextInt())==1){
        System.out.println("Ingrese el valor por merito del limpieza");
        valor=sc.nextDouble();
        System.out.println("Ingrese la cantidad de meritos del limpieza");
        setCantidadbonos(sc.nextInt());
        valor=getCantidadbonos()*valor;}
                    else{valor=0;}
        return valor;
    }
}
