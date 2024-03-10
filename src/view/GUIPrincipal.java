package view;

import controller.ControllerVideoJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIPrincipal extends JFrame implements IGUIEstilos {

    private JMenu opciones;
    private JMenu archivo;
    private JMenu ayuda;
    private JMenu usuario;
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
    private JMenuItem item9;
    private JMenuItem item10;
    private JMenuItem item11;
    private JMenuItem item12;
    private JMenuItem item13;
    private ControllerVideoJuego videojuego;

    private GUIListar guiListar;


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
        usuario = new JMenu("Usuario");
        menuBar = new JMenuBar();
        logo = new JLabel(URLimagen);

        //iniciamos los items del menu opciones
        item1 = new JMenuItem("Agregar");
        item2 = new JMenuItem("Eliminar");
        item3 = new JMenuItem("Actualizar");
        item4 = new JMenuItem("Listar");
        item5 = new JMenuItem("Buscar");
        item6 = new JMenuItem("Salir");
        item7 = new JMenuItem("Autores");
        item8 = new JMenuItem("Calculos");
        item9 = new JMenuItem("Agregar");
        item10 = new JMenuItem("Eliminar");
        item11 = new JMenuItem("Actualizar");
        item12 = new JMenuItem("Listar");
        item13 = new JMenuItem("Buscar");





        //agregamos los items al menu opciones

        archivo.add(item6);

        opciones.add(item1);
        opciones.addSeparator();
        opciones.add(item2);
        opciones.addSeparator();
        opciones.add(item3);
        opciones.addSeparator();
        opciones.add(item4);
        opciones.addSeparator();
        opciones.add(item5);
        opciones.addSeparator();
        opciones.add(item8);


        ayuda.add(item7);

        usuario.add(item9);
        usuario.addSeparator();
        usuario.add(item10);
        usuario.addSeparator();
        usuario.add(item11);
        usuario.addSeparator();
        usuario.add(item12);
        usuario.addSeparator();
        usuario.add(item13);


        //agregamos el menu opciones y el menu autores al menuBar
        menuBar.add(archivo);
        menuBar.add(opciones);
        menuBar.add(ayuda);
        menuBar.add(usuario);

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

        item2.addActionListener(e -> {
            GUIEliminar guiEliminar = new GUIEliminar();
            guiEliminar.setVisible(true);
        });

        item3.addActionListener(e -> {
            GUIActualizar guiActualizar = new GUIActualizar();
            guiActualizar.setVisible(true);
        });

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
            GUICalculos guiCalculos = new GUICalculos();
            guiCalculos.setGuiListar(guiListar);
            guiCalculos.setVisible(true);
        });

        item9.addActionListener(e -> {
            GUIAgregarUsuario guiAgregarUsuario = new GUIAgregarUsuario();
            guiAgregarUsuario.setVisible(true);
        });

        item10.addActionListener(e -> {
            GUIEliminarUsuario guiEliminarUsuario = new GUIEliminarUsuario();
            guiEliminarUsuario.setVisible(true);
        });

        item11.addActionListener(e -> {

        });


        item12.addActionListener(e -> {
            GUIListarUsuario guiListarUsuario = new GUIListarUsuario();
            guiListarUsuario.setVisible(true);
        });

        item13.addActionListener(e -> {
            GUIBuscarUsuario guiBuscarUsuario = new GUIBuscarUsuario();
            guiBuscarUsuario.setVisible(true);
        });

    }

    public void setVideojuego(ControllerVideoJuego videojuego) {
        this.videojuego = videojuego;
    }
}





