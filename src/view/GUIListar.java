package view;

import controller.ControllerVideoJuego;
import model.IActualizable;
import model.VideoJuego;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class GUIListar extends JFrame implements IGUIEstilos, IActualizable {

    private ArrayList<VideoJuego> juegos = new ArrayList<>();
    private ControllerVideoJuego controllerVideoJuego;
    private JTable tabla;

    public GUIListar() {
        setTitle("Listado Videojuegos");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(COLOR);
        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(COLOR);
        panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Listado Videojuegos");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        panelTitulo.add(titleLabel);
        add(panelTitulo, BorderLayout.NORTH);

        tabla = new JTable();
        tabla.setBackground(Color.lightGray);
        tabla.setForeground(Color.black);
        tabla.setFont(new Font("Arial", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(tabla);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        controllerVideoJuego = new ControllerVideoJuego();

        juegos.addAll(ControllerVideoJuego.listarVideoJuegos());
        actualizarTabla();

        controllerVideoJuego.addActualizable(this);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void actualizarTabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Stock");
        model.addColumn("Precio");

        for (VideoJuego videoJuego : juegos) {
            Object[] row = new Object[4];
            row[0] = videoJuego.getId();
            row[1] = videoJuego.getNombre();
            row[2] = videoJuego.getStock();
            row[3] = videoJuego.getPrecio();
            model.addRow(row);
        }

        tabla.setModel(model);
    }

    @Override
    public void actualizar() {
        juegos.clear();
        juegos.addAll(ControllerVideoJuego.listarVideoJuegos());
        actualizarTabla();
    }
}
