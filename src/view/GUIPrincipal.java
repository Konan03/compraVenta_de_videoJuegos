package view;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIPrincipal extends JFrame {

    private JMenu opciones;
    private JMenu autores;
    private JMenuBar menuBar;
    private JLabel logo;
    private JMenuItem item1;
    private JMenuItem item2;
    private JMenuItem item3;
    private JMenuItem item4;
    private JMenuItem item5;

    public GUIPrincipal() {

        //iniciamos los valores del color y el logo
        Color color = new Color(86, 133, 176);
        ImageIcon URLimagen = new ImageIcon(getClass().getResource("/data/img/logo_sin_fondo.png"));

        setTitle("Compra y venta de video juegos");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(color);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                GUIPrincipal.this.setVisible(false);
            }
        });

        //iniciamos opciones, autores, el menu y el logo
        opciones = new JMenu("Opciones");
        autores = new JMenu("Autores");
        menuBar = new JMenuBar();
        logo = new JLabel(URLimagen);

        //iniciamos los items del menu opciones
        item1 = new JMenuItem("Agregar");
        item2 = new JMenuItem("Eliminar");
        item3 = new JMenuItem("Actualizar");
        item4 = new JMenuItem("Listar");
        item5 = new JMenuItem("Buscar");

        //agregamos los items al menu opciones
        opciones.add(item1);
        opciones.addSeparator();
        opciones.add(item2);
        opciones.addSeparator();
        opciones.add(item3);
        opciones.addSeparator();
        opciones.add(item4);
        opciones.addSeparator();
        opciones.add(item5);

        //agregamos el menu opciones y el menu autores al menuBar
        menuBar.add(opciones);
        menuBar.add(autores);

        //asignamos el menuBar
        setJMenuBar(menuBar);

        //agregamos el logo
        add(logo);

        //metodo para mostrar los autores
        activarOpciones();
    }

    public void activarOpciones() {
        autores.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JOptionPane.showMessageDialog(GUIPrincipal.this,
                        "Jose Manuel Caicedo Perdomo\nJuan David Gonzales\nSebastian Murillo\nMariana Millan",
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

        item1.addActionListener(e -> {

            JFrame seleccionar = new JFrame();
            Color color = new Color(86, 133, 176);
            JLabel selec = new JLabel("Seleccione el tipo");
            selec.setHorizontalAlignment(JLabel.CENTER);
            selec.setForeground(Color.WHITE);
            JButton op1 = new JButton("Fisico");
            JButton op2 = new JButton("Digital");
            Dimension buttonSize = new Dimension(80, 40);
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.setBackground(color);
            buttonPanel.add(op1);
            buttonPanel.add(op2);
            op1.setPreferredSize(buttonSize);
            op2.setPreferredSize(buttonSize);
            seleccionar.setSize(200, 120);
            seleccionar.setVisible(true);
            seleccionar.setResizable(false);
            seleccionar.setLocationRelativeTo(null);
            seleccionar.getContentPane().setBackground(color);
            seleccionar.setLayout(new BorderLayout());
            seleccionar.add(selec, BorderLayout.NORTH);
            seleccionar.add(buttonPanel, BorderLayout.SOUTH);

           op1.addActionListener(e1 -> {
               GUIAgregarFisico guiAgregarFisico = new GUIAgregarFisico();
               guiAgregarFisico.setVisible(true);
               seleccionar.dispose();
           } );

            op2.addActionListener(e2 -> {
                GUIAgregarDigital guiAgregarDigital = new GUIAgregarDigital();
                guiAgregarDigital.setVisible(true);
                seleccionar.dispose();
            } );


        });
    }


}





