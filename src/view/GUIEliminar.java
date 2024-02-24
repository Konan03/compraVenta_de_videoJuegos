package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUIEliminar extends JFrame {
    private JLabel idLabel, nombreLabel;
    private JTextField idTexto, nombreTexto;
    private JButton eliminarBTN;

    public GUIEliminar(){

        Color color = new Color(86, 133, 176);
        Border grayBorder = BorderFactory.createLineBorder(Color.GRAY, 1);
        Dimension tamanioTexto = new Dimension(100, 20);

        JPanel panelFinal = new JPanel();
        JPanel panelInvisible = new JPanel();
        JPanel panelInvisible2 = new JPanel();
        JPanel panelInvisible3 = new JPanel();
        JPanel panelInvisible4 = new JPanel();
        panelFinal.setLayout(new BorderLayout());
        panelFinal.setBackground(color);
        panelInvisible.setPreferredSize(new Dimension(100, 150));
        panelInvisible.setBackground(color);
        panelInvisible2.setPreferredSize(new Dimension(100, 100));
        panelInvisible2.setBackground(color);
        panelInvisible3.setPreferredSize(new Dimension(100, 150));
        panelInvisible3.setBackground(color);
        panelInvisible4.setPreferredSize(new Dimension(100, 150));
        panelInvisible4.setBackground(color);

        JLabel titulo = new JLabel("Ingrese el Id o el Nombre del juego a eliminar");
        Font fuenteActual = titulo.getFont();
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font(fuenteActual.getName(), fuenteActual.getStyle(), 20));

        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new GridLayout(2,1));
        panelLabels.setBackground(color);
        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new GridLayout(2,1));
        panelTexto.setBackground(color);

        setTitle("Eliminar video juego");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(color);

        idLabel = new JLabel("Id: ");
        idLabel.setHorizontalAlignment(JLabel.CENTER);
        nombreLabel = new JLabel("Nombre: ");
        nombreLabel.setHorizontalAlignment(JLabel.CENTER);

        idTexto = new JTextField();
        idTexto.setBorder(grayBorder);
        nombreTexto = new JTextField();
        nombreTexto.setBorder(grayBorder);

        eliminarBTN = new JButton("Eliminar");

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
        add(eliminarBTN, BorderLayout.SOUTH);
    }

}
