package view;

import controller.ControllerVideoJuego;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIPrincipal extends JFrame implements IGUIEstilos {

    private JMenu opciones;
    private JMenu archivo;
    private JMenu ayuda;
    private JMenuBar menuBar;
    private JLabel logo;
    private JMenuItem item1;
    private JMenuItem item2;
    private JMenuItem item3;
    private JMenuItem item4;
    private JMenuItem item5;
    private JMenuItem item6;
    private JMenuItem item7;

    private JMenuItem item8;
    private ControllerVideoJuego videojuego;

    public GUIPrincipal() {

        //iniciamos los valores del color y el logo
        ImageIcon URLimagen = new ImageIcon(getClass().getResource("/data/img/logo_sin_fondo.png"));

        setTitle("Compra y venta de video juegos");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(COLOR);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //iniciamos opciones, autores, el menu y el logo
        opciones = new JMenu("Opciones");
        ayuda = new JMenu("Ayuda");
        archivo = new JMenu("Archivo");
        menuBar = new JMenuBar();
        logo = new JLabel(URLimagen);

        //iniciamos los items del menu opciones
        item1 = new JMenuItem("Agregar");
        //item2 = new JMenuItem("Eliminar");
        //item3 = new JMenuItem("Actualizar");
        item4 = new JMenuItem("Listar");
        item5 = new JMenuItem("Buscar");
        item6 = new JMenuItem("Salir");
        item7 = new JMenuItem("Autores");
        item8 = new JMenuItem("Aplicar Descuento");



        //agregamos los items al menu opciones

        archivo.add(item6);

        opciones.add(item1);
        opciones.addSeparator();
       /* opciones.add(item2);
        opciones.addSeparator();
        opciones.add(item3);
        opciones.addSeparator();*/
        opciones.add(item4);
        opciones.addSeparator();
        opciones.add(item5);
        opciones.addSeparator();
        opciones.add(item8);


        ayuda.add(item7);


        //agregamos el menu opciones y el menu autores al menuBar
        menuBar.add(archivo);
        menuBar.add(opciones);
        menuBar.add(ayuda);

        //asignamos el menuBar
        setJMenuBar(menuBar);

        //agregamos el logo
        add(logo);

        //metodo para mostrar los autores
        activarOpciones();
    }

    public void activarOpciones() {
        item7.addActionListener(e -> {
            JOptionPane.showMessageDialog(GUIPrincipal.this,
                    "Jose Manuel Caicedo Perdomo\nJuan David Gonzales\nSebastian Murillo\nMariana Millan\n\nv.0.1",
                    "Autores",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        item1.addActionListener(e -> {
            GUISeleccionar guiSeleccionar = new GUISeleccionar();
            guiSeleccionar.setVisible(true);
        });

        /*item2.addActionListener(e -> {
            GUIEliminar guiEliminar = new GUIEliminar();
            guiEliminar.setVisible(true);
        });

        item3.addActionListener(e -> {
            GUIActualizar guiActualizar = new GUIActualizar();
            guiActualizar.setVisible(true);
        });*/

        item4.addActionListener(e -> {
            GUIListar guiListar = new GUIListar();
            guiListar.setVisible(true);
        });

        item5.addActionListener(e -> {
            GUIBuscar guiBuscar = new GUIBuscar();
            guiBuscar.setVisible(true);
        });

        item6.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(GUIPrincipal.this, "¿Estás seguro de que quieres salir?", "Salir", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        item8.addActionListener(e -> {
            GUIAplicarDescuento guiAplicarDescuento = new GUIAplicarDescuento();
            guiAplicarDescuento.setVisible(true);
        });


    }

    public void setVideojuego(ControllerVideoJuego videojuego) {
        this.videojuego = videojuego;
    }
}





