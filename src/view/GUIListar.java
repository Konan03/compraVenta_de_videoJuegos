package view;

import controller.ControllerVideoJuego;
import model.IActualizable;
import model.VideoJuego;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GUIListar extends JFrame implements IGUIEstilos, IActualizable {

    private static final Dimension BUTTON_SIZE = new Dimension(120, 40);
    private ArrayList<VideoJuego> juegos = (ArrayList<VideoJuego>) ControllerVideoJuego.listarVideoJuegos();
    private ControllerVideoJuego controllerVideoJuego;

    public GUIListar(){
        setTitle("Video juegos");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(COLOR);
        controllerVideoJuego = new ControllerVideoJuego();
        // Configura el layout para organizar los botones en una cuadrícula
        int columnas = 4; // Define el número de columnas de tu cuadrícula
        int filas = (int) Math.ceil((double) juegos.size() / columnas);
        setLayout(new GridLayout(filas, columnas, 10, 10)); // Los últimos dos argumentos son los espacios (horizontal y vertical) entre los componentes00
        crearBotones();

        controllerVideoJuego.addActualizable(this);
    }

    /*
    public void crearBotones(){
        Dimension tamanioBoton = new Dimension(100, 50);
        for (VideoJuego videoJuego : juegos) {

            JButton button = new JButton(videoJuego.getNombre());
            button.setPreferredSize(tamanioBoton);
            button.setMargin(new Insets(10, 20, 10, 20));

            String datos = videoJuego.toString();
            button.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, datos, "Infomacion", JOptionPane.INFORMATION_MESSAGE);
            });
            add(button);

        }
    }*/

    public void crearBotones(){
        int columnas = 4; // Define el número de columnas de tu cuadrícula
        int filas = (int) Math.ceil((double) juegos.size() / columnas); // Calcula el número de filas
        JButton[][] botones = new JButton[filas][columnas]; // Matriz de botones

        // Configura el layout principal para usar BoxLayout alineando los paneles de filas verticalmente
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Crea y configura un JPanel para cada fila con un espacio horizontal y vertical reducido
        for (int i = 0; i < filas; i++) {
            JPanel filaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5)); // Espacios reducidos
            filaPanel.setBackground(COLOR);
            add(filaPanel);
            for (int j = 0; j < columnas; j++) {
                int indice = i * columnas + j;
                if (indice < juegos.size()) { // Verifica si hay un juego para este índice
                    VideoJuego videoJuego = juegos.get(indice);
                    JButton button = new JButton(videoJuego.getNombre());
                    button.setPreferredSize(new Dimension(100, 50)); // Tamaño de los botones

                    // Configura el listener para mostrar los datos del juego
                    String datos = videoJuego.toString();
                    button.addActionListener(e -> JOptionPane.showMessageDialog(this, datos, "Información", JOptionPane.INFORMATION_MESSAGE));

                    filaPanel.add(button); // Agrega el botón al panel de la fila
                    botones[i][j] = button; // Guarda el botón en la matriz
                }
            }
        }

        // Llama a estos métodos para actualizar la interfaz gráfica después de agregar los componentes
        revalidate();
        repaint();
    }




    public void setVideojuego(ControllerVideoJuego videojuego) {
        this.controllerVideoJuego = videojuego;
    }

    @Override
    public void actualizar() {
        juegos = (ArrayList<VideoJuego>) ControllerVideoJuego.listarVideoJuegos();
        getContentPane().removeAll();
        crearBotones();
        revalidate();
        repaint();
    }
}
