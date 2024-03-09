package view;

import javax.swing.*;
import java.awt.*;

public class GUISeleccionar extends JFrame implements IGUIEstilos {

    private JLabel selec;

    private JButton op1, op2;

    public GUISeleccionar(){
        selec = new JLabel("Seleccione el tipo");
        selec.setHorizontalAlignment(JLabel.CENTER);
        op1 = new JButton("Fisico");
        op2 = new JButton("Digital");
        Dimension buttonSize = new Dimension(80, 40);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(COLOR);
        buttonPanel.add(op1);
        buttonPanel.add(op2);
        op1.setPreferredSize(buttonSize);
        op2.setPreferredSize(buttonSize);
        setSize(200, 120);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(COLOR);
        setLayout(new BorderLayout());
        add(selec, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        op1.addActionListener(e1 -> {
            GUIAgregarFisico guiAgregarFisico = new GUIAgregarFisico(false);
            guiAgregarFisico.setVisible(true);
            dispose();
        } );

        op2.addActionListener(e2 -> {
            GUIAgregarDigital guiAgregarDigital = new GUIAgregarDigital(false);
            guiAgregarDigital.setVisible(true);
            dispose();
        } );
    }
}
