package poo_u2_proyectocine;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorCine {
    private List<Sala> salas;
    private List<Pelicula> cartelera;
    private VistaCine vista;
    private String salasFilePath;

    public ControladorCine(String salasFilePath) {
        this.salasFilePath = salasFilePath;
        salas = cargarSalasDesdeArchivo();
        cartelera = new ArrayList<>();
        vista = new VistaCine();
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public List<Pelicula> getCartelera() {
        return cartelera;
    }

    public void setCartelera(List<Pelicula> cartelera) {
        this.cartelera = cartelera;
    }

    public VistaCine getVista() {
        return vista;
    }

    public void setVista(VistaCine vista) {
        this.vista = vista;
    }

    public String getSalasFilePath() {
        return salasFilePath;
    }

    public void setSalasFilePath(String salasFilePath) {
        this.salasFilePath = salasFilePath;
    }

    public void agregarSala(Sala sala) {
        salas.add(sala);
        guardarSalasEnArchivo();
    }

    public void editarSala(String nombreSala, Sala salaEditada) {
        for (Sala sala : salas) {
            if (sala.getNombre().equals(nombreSala)) {
                sala.setNombre(salaEditada.getNombre());
                sala.setCapacidad(salaEditada.getCapacidad());

                if (sala instanceof SalaCine && salaEditada instanceof SalaCine) {
                    ((SalaCine) sala).setFormatoPantalla(((SalaCine) salaEditada).getFormatoPantalla());
                } else if (sala instanceof Sala3D && salaEditada instanceof Sala3D) {
                    ((Sala3D) sala).setLentesIncluidos(((Sala3D) salaEditada).isLentesIncluidos());
                }

                guardarSalasEnArchivo();
                break;
            }
        }
    }

    public void mostrarCartelera() {
        vista.mostrarCartelera(cartelera);
    }

    public void agregarPelicula(Pelicula pelicula) {
        cartelera.add(pelicula);
    }

    public void mostrarSalas() {
        vista.mostrarSalas(salas);
    }

    private void guardarSalasEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(salasFilePath))) {
            oos.writeObject(salas);
        } catch (IOException e) {
            System.out.println("Error al guardar las salas en el archivo.");
            e.printStackTrace();
        }
    }

    private List<Sala> cargarSalasDesdeArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(salasFilePath))) {
            return (List<Sala>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar las salas desde el archivo. Se creará una nueva lista.");
        }

        return new ArrayList<>();
    }
}