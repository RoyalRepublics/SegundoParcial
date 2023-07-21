package poo_evaluacion_personal;
//clase de personal de docente registra el titulo, que es lo mas importante de un docente comparado a los otros empleados
public class Docente extends Personal2{
    private String titulo;

    public Docente(String titulo, String nombre, long cedula, String Correo, double sueldo, double cantidadbonos) {
        super(nombre, cedula, Correo, sueldo, cantidadbonos);
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    //sobreesctritura del metodo calcular sueldo
    @Override
    public double calcularsueldo() {
    setSueldo(calcularmeritos()+1000);
        return getSueldo();
    }
//sobreesctritura del metodo calcularmeritos
    @Override
    public double calcularmeritos() {
        double valor;
        System.out.println("tiene el docente incentivos? (1 para si, 2 para no)");
        
        if((sc.nextInt())==1){
        System.out.println("Ingrese el valor por merito del docente");
        valor=sc.nextDouble();
        System.out.println("Ingrese la cantidad de meritos del docente");
        setCantidadbonos(sc.nextInt());
        valor=getCantidadbonos()*valor;}
                    else{valor=0;}
        return valor;
    }
    
}