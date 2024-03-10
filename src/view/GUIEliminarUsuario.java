package view;

import controller.ControllerUsuario;
import controller.ControllerVideoJuego;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIEliminarUsuario extends JFrame implements IGUIEstilos{

    private JLabel idLabel, nombreLabel;
    private JTextField idTexto, nombreTexto;
    private JButton eliminarBTN;

    public GUIEliminarUsuario(){
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

        JLabel titulo = new JLabel("Ingrese el Id o el Nombre del usuario a eliminar");
        Font fuenteActual = titulo.getFont();
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font(fuenteActual.getName(), fuenteActual.getStyle(), 20));

        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new GridLayout(2,1));
        panelLabels.setBackground(COLOR);
        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new GridLayout(2,1));
        panelTexto.setBackground(COLOR);

        setTitle("Eliminar usuario");
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

        eliminarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = idTexto.getText().trim();
                String nombre = nombreTexto.getText().trim();

                if (!idStr.isEmpty()) {
                    eliminarPorId(idStr);
                } else if (!nombre.isEmpty()) {
                    eliminarPorNombre(nombre);
                } else {
                    JOptionPane.showMessageDialog(GUIEliminarUsuario.this, "Por favor, introduzca un ID o un nombre para eliminar.", "Información Incompleta", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public void eliminarPorId(String idStr) {
        try {
            int id = Integer.parseInt(idStr);
            Usuario usuarioEliminado = ControllerUsuario.buscarUsuario(id);
            if (usuarioEliminado != null) {
                ControllerUsuario.eliminarUsuario(id);
                JOptionPane.showMessageDialog(this, "Usuario eliminado por ID exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún usuario con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido, debe ser un número entero.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarPorNombre(String nombre) {
        Usuario usuarioEliminado = ControllerUsuario.buscarUsuario(nombre);
        if (usuarioEliminado != null) {
            ControllerUsuario.eliminarUsuario(nombre);
            JOptionPane.showMessageDialog(this, "Usuario eliminado por nombre exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún usuario con ese nombre.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
