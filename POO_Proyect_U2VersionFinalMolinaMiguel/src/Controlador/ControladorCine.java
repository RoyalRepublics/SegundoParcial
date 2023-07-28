package Controlador;
import Modelo.Pelicula;
import Modelo.Sala;
import Vista.VistaCine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ControladorCine implements ActionListener {
    private VistaCine view;
    private Pelicula peli;
    private Sala sal;
private List<Pelicula> peliculas = new ArrayList<>();

     private List<Sala> salas = new ArrayList<>();

    public ControladorCine(VistaCine view, Pelicula peli, Sala sal) {
        this.view = view;
        this.peli = peli;
        this.sal = sal;
        this.view.btnAP.addActionListener(this);
        this.view.btnEP.addActionListener(this);
        this.view.btnDP.addActionListener(this);
        this.view.btnAS.addActionListener(this);
        this.view.btnES.addActionListener(this);
        this.view.btnDS.addActionListener(this);
        this.view.btnS.addActionListener(this);
        view.tbPeli.getSelectionModel().addListSelectionListener(new PeliculaTableSelectionListener());
        view.tbSala.getSelectionModel().addListSelectionListener(new SalaTableSelectionListener());
        cargarPeliculasDesdeArchivo();
        cargarSalasDesdeArchivo();
    }

    public void Inicio() {
        view.setTitle("Registro de Datos");
        view.setLocationRelativeTo(null);
        view.txt1.setText(String.valueOf(peli.getNombre()));
        view.txt2.setText(String.valueOf(peli.getRateP()));
        view.txt3.setText(String.valueOf(peli.getDirectorP()));
        view.txt4.setText(String.valueOf(peli.getDuracionP()));
        view.txt5.setText(String.valueOf(sal.getNombre()));
        view.txt6.setText(String.valueOf(sal.getCapacidadS()));
        view.txt5.setText(String.valueOf(sal.getTipoS()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        peli.setNombre(view.txt1.getText());
        peli.setRateP(view.txt2.getText());
        peli.setDirectorP(view.txt3.getText());
        peli.setDuracionP(view.txt4.getText());
        sal.setNombre(view.txt5.getText());
        String capacidadSText = view.txt6.getText();
        if (!capacidadSText.isEmpty()) {
            sal.setCapacidadS(Integer.parseInt(view.txt6.getText()));
        }
        
        if (view.cmbox1.getSelectedItem().equals("Sala Normal")) {
            sal.setTipoS(false);
        } else {
            sal.setTipoS(true);
        }
        // Código para identificar qué botón se ha presionado
        if (e.getSource() == view.btnAP) {
            anadirPelicula();
        } else if (e.getSource() == view.btnEP) {
            editarPelicula();
        } else if (e.getSource() == view.btnDP) {
            eliminarPelicula();
        } else if (e.getSource() == view.btnAS) {
            anadirSala();
        } else if (e.getSource() == view.btnES) {
            editarSala();
        } else if (e.getSource() == view.btnDS) {
           eliminarSala();
        }
        // Validación para la división por 0
    }

    // Método para añadir una película
public void anadirPelicula() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Peliculas.txt", true))) {
        
        writer.write(peli.getNombre() + "," + peli.getRateP() + "," + peli.getDirectorP() + ","
                + peli.getDuracionP());
        writer.newLine();
        view.mostrarMensaje("Película añadida exitosamente.");

        // Actualizar el modelo de la tabla tbPeli con los datos de la película añadida
        DefaultTableModel peliculaTableModel = (DefaultTableModel) view.tbPeli.getModel();
        Object[] rowData = {peli.getNombre(), peli.getRateP(), peli.getDirectorP(), peli.getDuracionP()};
        peliculaTableModel.addRow(rowData);

        // Notificar a la tabla que se han realizado cambios en los datos y que necesita actualizarse
        peliculaTableModel.fireTableDataChanged();
    } catch (IOException ex) {
        view.mostrarMensaje("Error al añadir la película.");
        ex.printStackTrace();
    }
}
    // Método para añadir una sala
    public void anadirSala() {
        String aux;
        if (sal.getTipoS()==false){
        aux="Sala Normal";}else{
        aux="Sala 3D";}
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Salas.txt", true))) {
        writer.write(sal.getNombre() + "," + sal.getCapacidadS() + "," + aux);
        writer.newLine();
        view.mostrarMensaje("Sala añadida exitosamente.");

        // Obtener el modelo de la tabla de salas
        DefaultTableModel modeloSala = (DefaultTableModel) view.tbSala.getModel();

        // Agregar el nuevo registro al modelo
        Object[] filaSala = {sal.getNombre(), sal.getCapacidadS(), aux};
        modeloSala.addRow(filaSala);

        // Actualizar la tabla de salas
        view.tbSala.setModel(modeloSala);
    } catch (IOException ex) {
        view.mostrarMensaje("Error al añadir la sala.");
        ex.printStackTrace();
    }
}
    public void cargarPeliculasDesdeArchivo() {
        DefaultTableModel peliculaTableModel = (DefaultTableModel) view.tbPeli.getModel();
        peliculaTableModel.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

        try (BufferedReader reader = new BufferedReader(new FileReader("Peliculas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    String nombre = datos[0];
                    String rateP = datos[1];
                    String directorP = datos[2];
                    String duracionP = datos[3];
                    Object[] rowData = {nombre, rateP, directorP, duracionP};
                    peliculaTableModel.addRow(rowData);
                }
            }
        } catch (IOException e) {
            view.mostrarMensaje("Error al cargar las películas desde el archivo.");
            e.printStackTrace();
        }
    }

 // Método para cargar los registros de salas desde el archivo y actualizar la tabla
public void cargarSalasDesdeArchivo() {
    DefaultTableModel salaTableModel = (DefaultTableModel) view.tbSala.getModel();
    salaTableModel.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

    try (BufferedReader reader = new BufferedReader(new FileReader("Salas.txt"))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos.length == 3) {
                String nombre = datos[0];
                int capacidadS = Integer.parseInt(datos[1]);
                boolean tipoS = datos[2].equals("Sala 3D");
                String tipoTexto = tipoS ? "Sala 3D" : "Sala Normal";
                Object[] rowData = {nombre, capacidadS, tipoTexto};
                salaTableModel.addRow(rowData);
                
                // Agregamos la sala creada a la lista de salas
                Sala sala = new Sala(capacidadS, tipoS, nombre);
                salas.add(sala);
            }
        }
    } catch (IOException e) {
        view.mostrarMensaje("Error al cargar las salas desde el archivo.");
        e.printStackTrace();
    }
}
    private class PeliculaTableSelectionListener implements ListSelectionListener {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        // Verificar si la selección ha cambiado y si hay una fila seleccionada
        if (!e.getValueIsAdjusting() && view.tbPeli.getSelectedRow() != -1) {
            int filaSeleccionada = view.tbPeli.getSelectedRow();
            String nombre = view.tbPeli.getValueAt(filaSeleccionada, 0).toString();
            String rateP = view.tbPeli.getValueAt(filaSeleccionada, 1).toString();
            String directorP = view.tbPeli.getValueAt(filaSeleccionada, 2).toString();
            String duracionP = view.tbPeli.getValueAt(filaSeleccionada, 3).toString();

            // Cargar los datos de la fila seleccionada en los JTextFields correspondientes
            view.txt1.setText(nombre);
            view.txt2.setText(rateP);
            view.txt3.setText(directorP);
            view.txt4.setText(duracionP);
        }
    }
}

private class SalaTableSelectionListener implements ListSelectionListener {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        // Verificar si la selección ha cambiado y si hay una fila seleccionada
        if (!e.getValueIsAdjusting() && view.tbSala.getSelectedRow() != -1) {
            int filaSeleccionada = view.tbSala.getSelectedRow();
            String nombre = view.tbSala.getValueAt(filaSeleccionada, 0).toString();
            String capacidadS = view.tbSala.getValueAt(filaSeleccionada, 1).toString();
            String tipoS = view.tbSala.getValueAt(filaSeleccionada, 2).toString();

            // Cargar los datos de la fila seleccionada en los JTextFields correspondientes
            view.txt5.setText(nombre);
            view.txt6.setText(capacidadS);
            view.cmbox1.setSelectedItem(tipoS);
        }
    }
}
private void editarPelicula() {
    try {
        List<Pelicula> peliculas = new ArrayList<>();

        // Leer todas las películas del archivo y guardarlas en la lista
        try (BufferedReader reader = new BufferedReader(new FileReader("Peliculas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    String nombre = datos[0];
                    String rateP = datos[1];
                    String directorP = datos[2];
                    String duracionP = datos[3];
                    peliculas.add(new Pelicula(rateP, directorP, duracionP, nombre));
                }
            }
        }

        // Buscar la posición de la película a editar en la lista y actualizar sus datos
        for (int i = 0; i < peliculas.size(); i++) {
            Pelicula pelicula = peliculas.get(i);
            if (pelicula.getNombre().equals(peli.getNombre())) {
                pelicula.setNombre(peli.getNombre());
                pelicula.setRateP(peli.getRateP());
                pelicula.setDirectorP(peli.getDirectorP());
                pelicula.setDuracionP(peli.getDuracionP());
                break;
            }
        }

        // Guardar la lista actualizada de películas en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Peliculas.txt"))) {
            for (Pelicula pelicula : peliculas) {
                writer.write(pelicula.getNombre() + "," + pelicula.getRateP() + "," + pelicula.getDirectorP() + ","
                        + pelicula.getDuracionP());
                writer.newLine();
            }
        }

        view.mostrarMensaje("Película editada exitosamente.");
        cargarPeliculasDesdeArchivo(); // Actualizar la tabla con los datos editados
    } catch (IOException ex) {
        view.mostrarMensaje("Error al editar la película.");
        ex.printStackTrace();
    }
}
    // Método para eliminar una película
    private void eliminarPelicula() {
        int filaSeleccionada = view.tbPeli.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel modeloPelicula = (DefaultTableModel) view.tbPeli.getModel();
            String nombrePelicula = view.tbPeli.getValueAt(filaSeleccionada, 0).toString();

            // Eliminar la película de la lista
            peliculas.removeIf(pelicula -> pelicula.getNombre().equals(nombrePelicula));

            // Actualizar el archivo de texto
            guardarPeliculasEnArchivo();

            // Actualizar la tabla de películas
            modeloPelicula.removeRow(filaSeleccionada);
            view.mostrarMensaje("Película eliminada exitosamente.");
        } else {
            view.mostrarMensaje("Por favor, selecciona una película para eliminar.");
        }
    }
    // Método para eliminar una sala
    private void eliminarSala() {
        int filaSeleccionada = view.tbSala.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel modeloSala = (DefaultTableModel) view.tbSala.getModel();
            String nombreSala = view.tbSala.getValueAt(filaSeleccionada, 0).toString();

            // Eliminar la sala de la lista
            salas.removeIf(sala -> sala.getNombre().equals(nombreSala));

            // Actualizar el archivo de texto
            guardarSalasEnArchivo();

            // Actualizar la tabla de salas
            modeloSala.removeRow(filaSeleccionada);
            view.mostrarMensaje("Sala eliminada exitosamente.");
        } else {
            view.mostrarMensaje("Por favor, selecciona una sala para eliminar.");
        }
    }
private void editarSala() {
    try {
        List<Sala> salas = new ArrayList<>();
        String nombreAnterior = view.txt5.getText(); // Guardamos el nombre anterior

        // Leer todas las salas del archivo
        try (BufferedReader reader = new BufferedReader(new FileReader("Salas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String nombre = datos[0];
                    int capacidad = Integer.parseInt(datos[1]);
                    boolean tipoSala = datos[2].equals("Sala 3D");
                    Sala sala = new Sala(capacidad,tipoSala , nombre);
                    salas.add(sala);
                }
            }
        }

        // Buscar la sala a editar y actualizar sus datos
        for (int i = 0; i < salas.size(); i++) {
            Sala sala = salas.get(i);
            if (sala.getNombre().equals(nombreAnterior)) { // Buscamos por el nombre anterior
                sala.setCapacidadS(Integer.parseInt(view.txt6.getText()));
                sala.setTipoS(view.cmbox1.getSelectedItem().equals("Sala 3D"));
                
                // Actualizamos el nombre si ha cambiado
                if (!nombreAnterior.equals(view.txt5.getText())) {
                    sala.setNombre(view.txt5.getText());
                }
                break;
            }
        }

        // Guardar la lista actualizada de salas en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Salas.txt"))) {
            for (Sala sala : salas) {
                writer.write(sala.getNombre() + "," + sala.getCapacidadS() + "," + (sala.getTipoS() ? "Sala 3D" : "Sala Normal"));
                writer.newLine();
            }
        }
         view.mostrarMensaje("Sala editada exitosamente.");
         cargarSalasDesdeArchivo();
    } catch (IOException e) {
        view.mostrarMensaje("Error al editar la sala en el archivo.");
        e.printStackTrace();
    }
}
    private void guardarPeliculasEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Peliculas.txt"))) {
            for (Pelicula pelicula : peliculas) {
                writer.write(pelicula.getNombre() + "," + pelicula.getRateP() + "," + pelicula.getDirectorP() + ","
                        + pelicula.getDuracionP());
                writer.newLine();
            }
        } catch (IOException ex) {
            view.mostrarMensaje("Error al guardar las películas en el archivo.");
            ex.printStackTrace();
        }
    }

    // Método para guardar la lista de salas en el archivo
    private void guardarSalasEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Salas.txt"))) {
            for (Sala sala : salas) {
                writer.write(sala.getNombre() + "," + sala.getCapacidadS() + "," + (sala.getTipoS() ? "Sala 3D" : "Sala Normal"));
                writer.newLine();
            }
        } catch (IOException ex) {
            view.mostrarMensaje("Error al guardar las salas en el archivo.");
            ex.printStackTrace();
        }
    }
}
