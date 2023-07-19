/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package poo_u2_proyectocine;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VistaCine extends JFrame {
private JButton agregarSalaButton;
    private JButton editarSalaButton;
    private JButton mostrarCarteleraButton;
    private JButton agregarPeliculaButton;
    private JButton mostrarSalasButton;

    private ControladorCine controlador;
    private JTextArea peliculasTextArea;
    private JTextArea salasTextArea;

    public VistaCine(ControladorCine controlador) {
        this.controlador = controlador;

        setTitle("Administración de Cine");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));

        JPanel peliculasPanel = new JPanel();
        peliculasPanel.setLayout(new BorderLayout());
        peliculasTextArea = new JTextArea();
        peliculasTextArea.setEditable(false);
        JScrollPane peliculasScrollPane = new JScrollPane(peliculasTextArea);
        peliculasPanel.add(new JLabel("Películas"), BorderLayout.NORTH);
        peliculasPanel.add(peliculasScrollPane, BorderLayout.CENTER);
        mainPanel.add(peliculasPanel);

        JPanel salasPanel = new JPanel();
        salasPanel.setLayout(new BorderLayout());
        salasTextArea = new JTextArea();
        salasTextArea.setEditable(false);
        JScrollPane salasScrollPane = new JScrollPane(salasTextArea);
        salasPanel.add(new JLabel("Salas"), BorderLayout.NORTH);
        salasPanel.add(salasScrollPane, BorderLayout.CENTER);
        mainPanel.add(salasPanel);

        add(mainPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(5, 1));

        agregarSalaButton = new JButton("Agregar Sala");
        agregarSalaButton.addActionListener(e -> {
            Sala nuevaSala = solicitarDatosSala();
            controlador.agregarSala(nuevaSala);
            mostrarMensaje("Sala agregada exitosamente.");
        });
        buttonsPanel.add(agregarSalaButton);

        editarSalaButton = new JButton("Editar Sala");
        editarSalaButton.addActionListener(e -> {
            String nombreSala = JOptionPane.showInputDialog("Ingrese el nombre de la sala a editar:");
            Sala salaEditar = buscarSala(controlador.getSalas(), nombreSala);
            if (salaEditar != null) {
                Sala salaEditada = solicitarDatosSala();
                controlador.editarSala(nombreSala, salaEditada);
                mostrarMensaje("Sala editada exitosamente.");
            } else {
                mostrarMensaje("No se encontró la sala especificada.");
            }
        });
        buttonsPanel.add(editarSalaButton);

        mostrarCarteleraButton = new JButton("Mostrar Cartelera");
        mostrarCarteleraButton.addActionListener(e -> mostrarCartelera(controlador.getCartelera()));
        buttonsPanel.add(mostrarCarteleraButton);

        agregarPeliculaButton = new JButton("Agregar Película");
        agregarPeliculaButton.addActionListener(e -> {
            Pelicula nuevaPelicula = solicitarDatosPelicula();
            controlador.agregarPelicula(nuevaPelicula);
            mostrarMensaje("Película agregada exitosamente.");
        });
        buttonsPanel.add(agregarPeliculaButton);

        mostrarSalasButton = new JButton("Mostrar Salas");
        mostrarSalasButton.addActionListener(e -> mostrarSalas(controlador.getSalas()));
        buttonsPanel.add(mostrarSalasButton);

        add(buttonsPanel, BorderLayout.WEST);

        setVisible(true);
    }

    public Sala solicitarDatosSala() {
        JTextField nombreField = new JTextField(10);
        JTextField capacidadField = new JTextField(10);
        JComboBox<String> tipoSalaComboBox = new JComboBox<>(new String[]{"Sala de Cine", "Sala 3D"});

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Capacidad:"));
        panel.add(capacidadField);
        panel.add(new JLabel("Tipo de Sala:"));
        panel.add(tipoSalaComboBox);

        int result = JOptionPane.showConfirmDialog(null, panel, "Agregar Sala", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String nombre = nombreField.getText();
            int capacidad = Integer.parseInt(capacidadField.getText());
            String tipoSala = (String) tipoSalaComboBox.getSelectedItem();

            if (tipoSala.equals("Sala de Cine")) {
                JTextField formatoPantallaField = new JTextField(10);
                JPanel salaCinePanel = new JPanel();
                salaCinePanel.setLayout(new GridLayout(1, 2));
                salaCinePanel.add(new JLabel("Formato de Pantalla:"));
                salaCinePanel.add(formatoPantallaField);

                int salaCineResult = JOptionPane.showConfirmDialog(null, salaCinePanel, "Agregar Sala de Cine", JOptionPane.OK_CANCEL_OPTION);
                if (salaCineResult == JOptionPane.OK_OPTION) {
                    String formatoPantalla = formatoPantallaField.getText();
                    return new SalaCine(nombre, capacidad, formatoPantalla);
                }
            } else if (tipoSala.equals("Sala 3D")) {
                JCheckBox lentesIncluidosCheckbox = new JCheckBox("Incluye Lentes 3D");

                JPanel sala3DPanel = new JPanel();
                sala3DPanel.setLayout(new GridLayout(1, 1));
                sala3DPanel.add(lentesIncluidosCheckbox);

                int sala3DResult = JOptionPane.showConfirmDialog(null, sala3DPanel, "Agregar Sala 3D", JOptionPane.OK_CANCEL_OPTION);
                if (sala3DResult == JOptionPane.OK_OPTION) {
                    boolean lentesIncluidos = lentesIncluidosCheckbox.isSelected();
                    return new Sala3D(nombre, capacidad, lentesIncluidos);
                }
            }
        }

        return null;
    }

    public void mostrarSalas(List<Sala> salas) {
        StringBuilder sb = new StringBuilder();
        sb.append("----- Salas Disponibles -----\n");
        if (salas.isEmpty()) {
            sb.append("No hay salas disponibles.\n");
        } else {
            for (Sala sala : salas) {
                if (sala != null) {
                    sb.append(sala.toString()).append("\n");
                }
            }
        }
        salasTextArea.setText(sb.toString());
    }

    public Pelicula solicitarDatosPelicula() {
        JTextField tituloField = new JTextField(10);
        JTextField generoField = new JTextField(10);
        JTextField duracionField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Título:"));
        panel.add(tituloField);
        panel.add(new JLabel("Género:"));
        panel.add(generoField);
        panel.add(new JLabel("Duración (minutos):"));
        panel.add(duracionField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Agregar Película", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String titulo = tituloField.getText();
            String genero = generoField.getText();
            int duracion = Integer.parseInt(duracionField.getText());

            return new Pelicula(titulo, genero, duracion);
        }

        return null;
    }

    public void mostrarCartelera(List<Pelicula> cartelera) {
        StringBuilder sb = new StringBuilder();
        sb.append("----- Cartelera de Películas -----\n");
        if (cartelera.isEmpty()) {
            sb.append("No hay películas en la cartelera.\n");
        } else {
            for (Pelicula pelicula : cartelera) {
                if (pelicula != null) {
                    sb.append(pelicula.toString()).append("\n");
                }
            }
        }
        peliculasTextArea.setText(sb.toString());
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private Sala buscarSala(List<Sala> salas, String nombre) {
        for (Sala sala : salas) {
            if (sala.getNombre().equalsIgnoreCase(nombre)) {
                return sala;
            }
        }
        return null;
    }
    public VistaCine() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
