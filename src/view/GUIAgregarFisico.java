package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUIAgregarFisico extends JFrame{

    private JTextField idTexto, nombreTexto, precioTexto, stockTexto,
            plataformaTexto, generoTexto, calificacionEdadTexto, fechaLanzamientotexto, estadoTexto, empaqueTexto;

    private JTextArea descripcionTexto;
    private JLabel idLabel, nombreLabel, precioLabel, stockLabel, descripcionLabel,
            plataformaLabel, generoLabel, calificacionEdadLabel, estadoLabel, empaqueLabel;
    private JButton agregarBTN;

    public GUIAgregarFisico()  {

        Color color = new Color(86, 133, 176);
        Border grayBorder = BorderFactory.createLineBorder(Color.GRAY, 1);
        JLabel titulo = new JLabel("Agregar juego fisico");
        Font fuenteActual = titulo.getFont();
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font(fuenteActual.getName(), fuenteActual.getStyle(), 20));
        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new GridLayout(10,1));
        panelLabels.setBackground(color);
        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new GridLayout(10,1));
        panelTexto.setBackground(color);

        setTitle("Agregar video juego");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(color);

        idLabel = new JLabel("Id: ");
        idLabel.setHorizontalAlignment(JLabel.CENTER);
        nombreLabel = new JLabel("Nombre: ");
        nombreLabel.setHorizontalAlignment(JLabel.CENTER);
        precioLabel = new JLabel("Precio: ");
        precioLabel.setHorizontalAlignment(JLabel.CENTER);
        stockLabel = new JLabel("Stock");
        stockLabel.setHorizontalAlignment(JLabel.CENTER);
        descripcionLabel = new JLabel("Descripcion: ");
        descripcionLabel.setHorizontalAlignment(JLabel.CENTER);
        plataformaLabel = new JLabel("Plataforma: ");
        plataformaLabel.setHorizontalAlignment(JLabel.CENTER);
        generoLabel = new JLabel("Genero: ");
        generoLabel.setHorizontalAlignment(JLabel.CENTER);
        calificacionEdadLabel = new JLabel("Edad Minima: ");
        calificacionEdadLabel.setHorizontalAlignment(JLabel.CENTER);
        estadoLabel = new JLabel("Estado: ");
        estadoLabel.setHorizontalAlignment(JLabel.CENTER);
        empaqueLabel = new JLabel("Empaque: ");
        empaqueLabel.setHorizontalAlignment(JLabel.CENTER);

        idTexto = new JTextField();
        idTexto.setBorder(grayBorder);
        nombreTexto = new JTextField();
        nombreTexto.setBorder(grayBorder);
        precioTexto = new JTextField();
        precioTexto.setBorder(grayBorder);
        stockTexto = new JTextField();
        stockTexto.setBorder(grayBorder);
        descripcionTexto = new JTextArea();
        descripcionTexto.setBorder(grayBorder);
        plataformaTexto = new JTextField();
        plataformaTexto.setBorder(grayBorder);
        generoTexto = new JTextField();
        generoTexto.setBorder(grayBorder);
        calificacionEdadTexto = new JTextField();
        calificacionEdadTexto.setBorder(grayBorder);
        estadoTexto = new JTextField();
        estadoTexto.setBorder(grayBorder);
        empaqueTexto = new JTextField();
        empaqueTexto.setBorder(grayBorder);

        agregarBTN = new JButton("Agregar");

        panelLabels.add(idLabel);
        panelLabels.add(nombreLabel);
        panelLabels.add(precioLabel);
        panelLabels.add(stockLabel);
        panelLabels.add(descripcionLabel);
        panelLabels.add(plataformaLabel);
        panelLabels.add(generoLabel);
        panelLabels.add(calificacionEdadLabel);
        panelLabels.add(estadoLabel);
        panelLabels.add(empaqueLabel);

        panelTexto.add(idTexto);
        panelTexto.add(nombreTexto);
        panelTexto.add(precioTexto);
        panelTexto.add(stockTexto);
        panelTexto.add(descripcionTexto);
        panelTexto.add(plataformaTexto);
        panelTexto.add(generoTexto);
        panelTexto.add(calificacionEdadTexto);
        panelTexto.add(estadoTexto);
        panelTexto.add(empaqueTexto);

        add(titulo, BorderLayout.NORTH);
        add(panelLabels, BorderLayout.WEST);
        add(panelTexto, BorderLayout.CENTER);
        add(agregarBTN, BorderLayout.SOUTH);




    }
}
