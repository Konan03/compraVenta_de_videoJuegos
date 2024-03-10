package view;

import controller.ControllerVideoJuego;
import model.IActualizable;
import model.VideoJuego;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.ArrayList;

public class GUIListar extends JFrame implements IGUIEstilos, IActualizable {

    private ArrayList<VideoJuego> juegos = new ArrayList<>();
    private ControllerVideoJuego controllerVideoJuego;
    private JPanel panelBotones;

    public GUIListar(){
        setTitle("Listado Videojuegos");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(COLOR);
        setLayout(new BorderLayout());

        panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(COLOR);
        panelBotones.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("Listado Videojuegos");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(panelBotones);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        controllerVideoJuego = new ControllerVideoJuego();

        juegos.addAll(ControllerVideoJuego.listarVideoJuegos());
        crearBotones();

        controllerVideoJuego.addActualizable(this);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void crearBotones(){
        panelBotones.removeAll();

        for (VideoJuego videoJuego : juegos) {
            JButton button = new JButton(videoJuego.getNombre());
            button.setBorder(new BevelBorder(BevelBorder.RAISED));

            button.setBackground(Color.lightGray);
            button.setForeground(Color.black);

            button.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, videoJuego.toString(), "Información", JOptionPane.INFORMATION_MESSAGE);
            });

            button.setPreferredSize(new Dimension(400, 50));
            button.setMaximumSize(new Dimension(400, 50));
            button.setMinimumSize(new Dimension(400, 50));

            button.setAlignmentX(Component.CENTER_ALIGNMENT);

            panelBotones.add(button);
            panelBotones.add(Box.createVerticalStrut(10));
        }

        revalidate();
        repaint();
    }

    @Override
    public void actualizar() {
        juegos.clear();
        juegos.addAll(ControllerVideoJuego.listarVideoJuegos());
        crearBotones();
    }
}
