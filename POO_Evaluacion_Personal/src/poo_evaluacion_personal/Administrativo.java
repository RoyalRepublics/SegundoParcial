package poo_evaluacion_personal;
//clase de personal administrativo, registra el area de trabajo del personal administrativo
public class Administrativo extends Personal2{
private String Area;

    public Administrativo(String Area, String nombre, long cedula, String Correo, double sueldo, double cantidadbonos) {
        super(nombre, cedula, Correo, sueldo, cantidadbonos);
        this.Area = Area;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }
//sobreescritura del metodo calcular sueldo
    @Override
    public double calcularsueldo() {
    setSueldo(calcularmeritos()+600);
        return getSueldo();
    }
//sobreescritura dle metodo calcular meritos
    @Override
    public double calcularmeritos() {
        double valor;
        System.out.println("tiene el administrativo incentivos? (1 para si, 2 para no)");
        if((sc.nextInt())==1){
        System.out.println("Ingrese el valor por merito del administrativo");
        valor=sc.nextDouble();
        System.out.println("Ingrese la cantidad de meritos del administrativo");
        setCantidadbonos(sc.nextInt());
        valor=getCantidadbonos()*valor;}
                    else{valor=0;}
        return valor;
    }
}
