package view;

import controller.ControllerUsuario;
import model.Usuario;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.time.ZoneId;


public class GUIAgregarUsuario extends JFrame implements IGUIEstilos{

    private JLabel idLabel, nombreLabel, fechaNacimientoLabel;
    private JTextField idTexto, nombreTexto;

    private JButton agregarBTN;
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

    public GUIAgregarUsuario(){

        JLabel titulo = new JLabel("Agregar usuario");
        Font fuenteActual = titulo.getFont();
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font(fuenteActual.getName(), fuenteActual.getStyle(), 20));
        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new GridLayout(11,1));
        panelLabels.setBackground(COLOR);
        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new GridLayout(11,1));
        panelTexto.setBackground(COLOR);

        setTitle("Agregar usuario");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(COLOR);

        idLabel = new JLabel("Id: ");
        idLabel.setHorizontalAlignment(JLabel.CENTER);
        nombreLabel = new JLabel("Nombre: ");
        nombreLabel.setHorizontalAlignment(JLabel.CENTER);
        fechaNacimientoLabel = new JLabel("Fecha Nacimiento: ");
        fechaNacimientoLabel.setHorizontalAlignment(JLabel.CENTER);

        idTexto = new JTextField();
        idTexto.setBorder(GRAY_BORDER);
        nombreTexto = new JTextField();
        nombreTexto.setBorder(GRAY_BORDER);
        datePicker.setBorder(GRAY_BORDER);

        agregarBTN = new JButton("Agregar");

        panelLabels.add(idLabel);
        panelLabels.add(nombreLabel);
        panelLabels.add(fechaNacimientoLabel);

        panelTexto.add(idTexto);
        panelTexto.add(nombreTexto);
        panelTexto.add(datePicker);

        add(titulo, BorderLayout.NORTH);
        add(panelLabels, BorderLayout.WEST);
        add(panelTexto, BorderLayout.CENTER);
        add(agregarBTN, BorderLayout.SOUTH);

        agregarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agrgarUsuario();
            }
        });
    }

    public void agrgarUsuario(){
        try {
            int idInt = Integer.parseInt(idTexto.getText());
            String nombre = nombreTexto.getText();
            Date date = (Date) datePicker.getModel().getValue();
            LocalDate seleccionFecha = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Usuario nuevoUsuario = new Usuario(idInt, nombre, seleccionFecha);

            ControllerUsuario.agregarUsuario(nuevoUsuario);
            JOptionPane.showMessageDialog(this, "Usuario agregado exitosamente: " , "Exito", JOptionPane.INFORMATION_MESSAGE);

        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al agregar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
