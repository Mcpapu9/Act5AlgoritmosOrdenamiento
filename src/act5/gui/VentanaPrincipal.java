/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act5.gui;

import act5.logica.AlgoritmosOrdenamiento;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class VentanaPrincipal extends JFrame {
    
    private JTextField txtTamano;
    private JTextField txtDatos;
    private JTextArea txtResultado;
    private JButton btnGenerarAleatorio;
    private JButton btnGuardarManual;
    private JButton btnEjecutar;
    private JButton btnReiniciar;

    private int[] arregloOriginal;
    private final Random random = new Random();

    public VentanaPrincipal() {
        setTitle("Estructura de Datos - Métodos de Ordenamiento");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- PANEL SUPERIOR: CAPTURA DE DATOS ---
        JPanel panelSuperior = new JPanel(new GridLayout(3, 1, 5, 5));
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Captura de Datos"));

        // Fila 1: Tamaño del arreglo
        JPanel pnlTamano = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlTamano.add(new JLabel("Cantidad de elementos:"));
        txtTamano = new JTextField(8);
        pnlTamano.add(txtTamano);
        panelSuperior.add(pnlTamano);

        // Fila 2: Ingreso manual
        JPanel pnlManual = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlManual.add(new JLabel("Datos (separados por coma):"));
        txtDatos = new JTextField(20);
        btnGuardarManual = new JButton("Cargar Manual");
        pnlManual.add(txtDatos);
        pnlManual.add(btnGuardarManual);
        panelSuperior.add(pnlManual);

        // Fila 3: Generación aleatoria
        JPanel pnlAleatorio = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnGenerarAleatorio = new JButton("Generar Datos Aleatorios (1-100)");
        pnlAleatorio.add(btnGenerarAleatorio);
        panelSuperior.add(pnlAleatorio);

        add(panelSuperior, BorderLayout.NORTH);

        // --- PANEL CENTRAL: VISUALIZACIÓN ---
        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setBorder(BorderFactory.createTitledBorder("Resultados del Proceso"));

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
        panelCentral.add(new JScrollPane(txtResultado), BorderLayout.CENTER);

        add(panelCentral, BorderLayout.CENTER);

        // --- PANEL INFERIOR: ACCIONES Y REINICIO ---
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        btnEjecutar = new JButton("Ordenar Aleatoriamente");
        btnEjecutar.setEnabled(false);
        btnEjecutar.setFont(new Font("SansSerif", Font.BOLD, 12));

        btnReiniciar = new JButton("Reiniciar / Nuevo Proceso");

        panelInferior.add(btnEjecutar);
        panelInferior.add(btnReiniciar);

        add(panelInferior, BorderLayout.SOUTH);

        // --- EVENTOS ---
        btnGenerarAleatorio.addActionListener(e -> generarDatosAleatorios());
        btnGuardarManual.addActionListener(e -> cargarDatosManuales());
        btnEjecutar.addActionListener(e -> ejecutarOrdenamientoAleatorio());
        btnReiniciar.addActionListener(e -> reiniciarFormulario());
    }

    private void generarDatosAleatorios() {
        try {
            int tamano = Integer.parseInt(txtTamano.getText().trim());
            if (tamano <= 0) {
                JOptionPane.showMessageDialog(this, "El tamaño debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            arregloOriginal = new int[tamano];
            for (int i = 0; i < tamano; i++) {
                arregloOriginal[i] = random.nextInt(100) + 1;
            }

            txtResultado.setText("=== DATOS CAPTURADOS ===\n");
            txtResultado.append("Arreglo Original: " + Arrays.toString(arregloOriginal) + "\n\n");
            txtResultado.append("¡Listo para ordenar! Haz clic en 'Ordenar Aleatoriamente'.\n");

            btnEjecutar.setEnabled(true);
            bloquearEntradas(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número entero válido para el tamaño.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatosManuales() {
        try {
            String text = txtDatos.getText().trim();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese números separados por comas.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String[] partes = text.split(",");
            arregloOriginal = new int[partes.length];
            for (int i = 0; i < partes.length; i++) {
                arregloOriginal[i] = Integer.parseInt(partes[i].trim());
            }
            txtTamano.setText(String.valueOf(arregloOriginal.length));

            txtResultado.setText("=== DATOS CAPTURADOS ===\n");
            txtResultado.append("Arreglo Original: " + Arrays.toString(arregloOriginal) + "\n\n");
            txtResultado.append("¡Listo para ordenar! Haz clic en 'Ordenar Aleatoriamente'.\n");

            btnEjecutar.setEnabled(true);
            bloquearEntradas(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Asegúrate de ingresar solo números enteros separados por comas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ejecutarOrdenamientoAleatorio() {
        if (arregloOriginal == null || arregloOriginal.length == 0) return;

        int[] arregloCopia = Arrays.copyOf(arregloOriginal, arregloOriginal.length);
        int opcion = random.nextInt(7);
        String nombreMetodo = "";

        switch (opcion) {
            case 0:
                nombreMetodo = "Bubble Sort (Burbuja)";
                AlgoritmosOrdenamiento.bubbleSort(arregloCopia);
                break;
            case 1:
                nombreMetodo = "Burbuja Mejorada";
                AlgoritmosOrdenamiento.bubbleSortMejorado(arregloCopia);
                break;
            case 2:
                nombreMetodo = "Insertion Sort (Inserción)";
                AlgoritmosOrdenamiento.insertionSort(arregloCopia);
                break;
            case 3:
                nombreMetodo = "Selection Sort (Selección)";
                AlgoritmosOrdenamiento.selectionSort(arregloCopia);
                break;
            case 4:
                nombreMetodo = "Shell Sort";
                AlgoritmosOrdenamiento.shellSort(arregloCopia);
                break;
            case 5:
                nombreMetodo = "Merge Sort";
                AlgoritmosOrdenamiento.mergeSort(arregloCopia);
                break;
            case 6:
                nombreMetodo = "Quick Sort";
                AlgoritmosOrdenamiento.quickSort(arregloCopia);
                break;
        }

        txtResultado.setText("=== PROCESO DE ORDENAMIENTO ===\n\n");
        txtResultado.append("1. Arreglo Original:  " + Arrays.toString(arregloOriginal) + "\n");
        txtResultado.append("2. Método Seleccionado (Aleatorio): " + nombreMetodo + "\n");
        txtResultado.append("3. Arreglo Ordenado:  " + Arrays.toString(arregloCopia) + "\n");
    }

    private void reiniciarFormulario() {
        arregloOriginal = null;
        txtTamano.setText("");
        txtDatos.setText("");
        txtResultado.setText("");
        btnEjecutar.setEnabled(false);
        bloquearEntradas(false);
    }

    private void bloquearEntradas(boolean bloquear) {
        txtTamano.setEditable(!bloquear);
        txtDatos.setEditable(!bloquear);
        btnGenerarAleatorio.setEnabled(!bloquear);
        btnGuardarManual.setEnabled(!bloquear);
    }
}
