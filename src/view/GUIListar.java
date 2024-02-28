package view;

import controller.ControllerVideoJuego;
import model.IActualizable;
import model.VideoJuego;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GUIListar extends JFrame implements IGUIEstilos, IActualizable {

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

    public void crearBotones(){
        for (VideoJuego videoJuego : juegos) {
            JButton button = new JButton(videoJuego.getNombre());
            String datos = videoJuego.toString();
            button.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, datos, "Infomacion", JOptionPane.INFORMATION_MESSAGE);
            });
            add(button);

        }
    }

    public void setVideojuego(ControllerVideoJuego videojuego) {
        this.controllerVideoJuego = videojuego;
    }

    @Override
    public void actualizar() {
        juegos = (ArrayList<VideoJuego>) ControllerVideoJuego.listarVideoJuegos();
        getContentPane().removeAll();
        crearBotones();
        getContentPane().revalidate();
        getContentPane().repaint();
    }

}
