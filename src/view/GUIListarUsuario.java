package view;

import controller.ControllerUsuario;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUIListarUsuario extends JFrame implements IGUIEstilos {
    private static final Dimension BUTTON_SIZE = new Dimension(120, 40);

    private ArrayList<Usuario> usuarios = (ArrayList<Usuario>) ControllerUsuario.listarUsuarios();


    public GUIListarUsuario(){
        setTitle("Usuarios");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(COLOR);
        // Configura el layout para organizar los botones en una cuadrícula
        int columnas = 4; // Define el número de columnas de tu cuadrícula
        int filas = (int) Math.ceil((double) usuarios.size() / columnas);
        setLayout(new GridLayout(filas, columnas, 10, 10)); // Los últimos dos argumentos son los espacios (horizontal y vertical) entre los componentes00
        crearBotones();
    }

    public void crearBotones() {
        int columnas = 4; // Define el número de columnas de tu cuadrícula
        int filas = (int) Math.ceil((double) usuarios.size() / columnas); // Calcula el número de filas
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
                if (indice < usuarios.size()) { // Verifica si hay un juego para este índice
                    Usuario usuario = usuarios.get(indice);
                    JButton button = new JButton(usuario.getNombre());
                    button.setPreferredSize(new Dimension(100, 50)); // Tamaño de los botones

                    // Configura el listener para mostrar los datos del juego
                    String datos = usuario.toString();
                    button.addActionListener(e -> JOptionPane.showMessageDialog(this, datos, "Información", JOptionPane.INFORMATION_MESSAGE));

                    filaPanel.add(button); // Agrega el botón al panel de la fila
                    botones[i][j] = button; // Guarda el botón en la matriz
                }
            }
        }
        revalidate();
        repaint();
    }
}
