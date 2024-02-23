package view;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class GUIPrincipal extends JFrame {

    private JMenu opciones;
    private JMenu autores;
    private JMenuBar menuBar;

    public GUIPrincipal() {
        setTitle("Compra y venta de video juegos");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);


        opciones = new JMenu("Opciones");
        autores = new JMenu("Autores");
        menuBar = new JMenuBar();

        JMenuItem item1 = new JMenuItem("Opción 1");
        JMenuItem item2 = new JMenuItem("Opción 2");
        JMenuItem item3 = new JMenuItem("Opción 3");

        opciones.add(item1);
        opciones.addSeparator();
        opciones.add(item2);
        opciones.addSeparator();
        opciones.add(item3);

        menuBar.add(opciones);
        menuBar.add(autores);

        setJMenuBar(menuBar);

        mostrarAutores();
    }

    public void mostrarAutores() {
        autores.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JOptionPane.showMessageDialog(GUIPrincipal.this,
                        "Jose Manuel Caicedo Perdomo....agreguen sus nombres xd",
                        "Autores",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            @Override
            public void menuDeselected(MenuEvent e) {
            }
            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });
    }
}


