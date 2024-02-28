package view;

import controller.ControllerVideoJuego;
import model.VideoJuego;

import javax.swing.*;
import java.awt.*;

public class GUIAplicarDescuento extends JFrame implements IGUIEstilos {

    private JLabel idLabel, nombreLabel, titulo;
    private JTextField idTexto, nombreTexto;
    private JButton aplicarDescuentoBTN;

    private GUIListar guiListar;

    public GUIAplicarDescuento(){
        JPanel panelFinal = new JPanel();
        JPanel panelInvisible = new JPanel();
        JPanel panelInvisible2 = new JPanel();
        JPanel panelInvisible3 = new JPanel();
        JPanel panelInvisible4 = new JPanel();
        panelFinal.setLayout(new BorderLayout());
        panelFinal.setBackground(COLOR);
        panelInvisible.setPreferredSize(new Dimension(100, 150));
        panelInvisible.setBackground(COLOR);
        panelInvisible2.setPreferredSize(new Dimension(100, 100));
        panelInvisible2.setBackground(COLOR);
        panelInvisible3.setPreferredSize(new Dimension(100, 150));
        panelInvisible3.setBackground(COLOR);
        panelInvisible4.setPreferredSize(new Dimension(100, 150));
        panelInvisible4.setBackground(COLOR);

        titulo = new JLabel("Ingrese el Id o el Nombre del juego ");
        Font fuenteActual = titulo.getFont();
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font(fuenteActual.getName(), fuenteActual.getStyle(), 20));

        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new GridLayout(2,1));
        panelLabels.setBackground(COLOR);
        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new GridLayout(2,1));
        panelTexto.setBackground(COLOR);

        setTitle("Aplicar descuento a videojuego");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(COLOR);

        idLabel = new JLabel("Id: ");
        idLabel.setHorizontalAlignment(JLabel.CENTER);
        nombreLabel = new JLabel("Nombre: ");
        nombreLabel.setHorizontalAlignment(JLabel.CENTER);

        idTexto = new JTextField();
        idTexto.setBorder(GRAY_BORDER);
        nombreTexto = new JTextField();
        nombreTexto.setBorder(GRAY_BORDER);

        aplicarDescuentoBTN = new JButton("Aplicar Descuento");

        panelLabels.add(idLabel);
        panelLabels.add(nombreLabel);

        panelTexto.add(idTexto);
        panelTexto.add(nombreTexto);

        panelFinal.add(panelInvisible, BorderLayout.NORTH);
        panelFinal.add(panelLabels, BorderLayout.WEST);
        panelFinal.add(panelTexto, BorderLayout.CENTER);
        panelFinal.add(panelInvisible2, BorderLayout.EAST);
        panelFinal.add(panelInvisible3, BorderLayout.SOUTH);

        add(titulo, BorderLayout.NORTH);
        add(panelInvisible4, BorderLayout.WEST);
        add(panelFinal, BorderLayout.CENTER);
        add(aplicarDescuentoBTN, BorderLayout.SOUTH);

        aplicarDescuentoBTN.addActionListener(e -> aplicarDescuento());
    }

    public void setGuiListar(GUIListar guiListar) {
        this.guiListar = guiListar;
    }

    private void aplicarDescuento() {
        String mensaje;
        VideoJuego videoJuego = null;

        String idStr = idTexto.getText().trim();
        String nombre = nombreTexto.getText().trim();

        if (!idStr.isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);
                videoJuego = ControllerVideoJuego.buscarVideoJuego(id);
                if (videoJuego == null) {
                    mensaje = "No se encontró ningún videojuego con el ID proporcionado.";
                    JOptionPane.showMessageDialog(this, mensaje, "Resultado del Descuento", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                mensaje = "Por favor, ingrese un ID válido.";
                JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else if (!nombre.isEmpty()) {
            videoJuego = ControllerVideoJuego.buscarVideoJuegoPorNombre(nombre);
            if (videoJuego == null) {
                mensaje = "No se encontró ningún videojuego con el nombre proporcionado.";
                JOptionPane.showMessageDialog(this, mensaje, "Resultado del Descuento", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } else {
            mensaje = "Por favor, introduzca un ID o un nombre para buscar el videojuego.";
            JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (videoJuego != null) {
            double descuentoAplicado = videoJuego.aplicarDescuento();
            if (descuentoAplicado > 0) {
                mensaje = String.format("Descuento aplicado. Nuevo precio: %.2f", videoJuego.getPrecio());
                ControllerVideoJuego.actualizarVideojuego(videoJuego.getId(), videoJuego);
            } else {
                mensaje = "Este videojuego no es elegible para descuentos.";
            }
            if (guiListar != null) {
            guiListar.actualizar();
             }

            JOptionPane.showMessageDialog(this, mensaje, "Resultado del Descuento", JOptionPane.INFORMATION_MESSAGE);
        }


    }

}




