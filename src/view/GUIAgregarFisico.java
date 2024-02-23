package view;

import javax.swing.*;
import java.awt.*;

public class GUIAgregarFisico extends JFrame {

    private JTextField idTexto, nombreTexto, precioTexto, stockTexto,
            plataformaTexto, generoTexto, calificacionEdadTexto, fechaLanzamientotexto, estadoTexto, empaqueTexto;
    private JTextArea descripcionTexto;
    private JLabel idLabel, nombreLabel, precioLabel, stockLabel, descripcionLabel,
            plataformaLabel, generoLabel, calificacionLabel, estadoLabel, empaqueLabel;

    public GUIAgregarFisico(){

        Color color = new Color(86, 133, 176);
        JPanel panelLabels = new JPanel();
        JPanel panelTexto = new JPanel();

        setTitle("Agregar video juego");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(color);


    }
}
