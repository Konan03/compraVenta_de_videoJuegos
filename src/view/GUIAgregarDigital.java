package view;

import controller.ControllerVideoJuego;
import model.VideoJuego;
import model.VideoJuegoDigital;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class GUIAgregarDigital extends JFrame implements IGUIEstilos {

    private JTextField idTexto, nombreTexto, precioTexto, stockTexto,
            plataformaTexto, generoTexto, calificacionEdadTexto, claveActivacionTexto;

    private JTextArea descripcionTexto;
    private JLabel idLabel, nombreLabel, precioLabel, stockLabel, descripcionLabel,
            plataformaLabel, generoLabel, calificacionEdadLabel, fechaLanzamientoLabel, claveActivacionLabel, experacionClaveLabel;
    private JButton guardarBTN;

    UtilDateModel model = new UtilDateModel();
    UtilDateModel model2 = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model2);
    JDatePanelImpl datePanel2 = new JDatePanelImpl(model);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel2);
    JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel);

    public GUIAgregarDigital(boolean esActualizar) {

        JLabel titulo;
        if (esActualizar) {
            titulo = new JLabel("Actualizar juego fisico");
        } else {
            titulo = new JLabel("Agregar juego fisico");
        }
        Font fuenteActual = titulo.getFont();
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font(fuenteActual.getName(), fuenteActual.getStyle(), 20));
        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new GridLayout(11, 1));
        panelLabels.setBackground(COLOR);
        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new GridLayout(11, 1));
        panelTexto.setBackground(COLOR);

        setTitle("Agregar videojuego");
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
        fechaLanzamientoLabel = new JLabel("Fecha Lanzamiento: ");
        fechaLanzamientoLabel.setHorizontalAlignment(JLabel.CENTER);
        claveActivacionLabel = new JLabel("Clave: ");
        claveActivacionLabel.setHorizontalAlignment(JLabel.CENTER);
        experacionClaveLabel = new JLabel("Vence: ");
        experacionClaveLabel.setHorizontalAlignment(JLabel.CENTER);

        idTexto = new JTextField();
        idTexto.setBorder(GRAY_BORDER);
        nombreTexto = new JTextField();
        nombreTexto.setBorder(GRAY_BORDER);
        precioTexto = new JTextField();
        precioTexto.setBorder(GRAY_BORDER);
        stockTexto = new JTextField();
        stockTexto.setBorder(GRAY_BORDER);
        descripcionTexto = new JTextArea();
        descripcionTexto.setBorder(GRAY_BORDER);
        plataformaTexto = new JTextField();
        plataformaTexto.setBorder(GRAY_BORDER);
        generoTexto = new JTextField();
        generoTexto.setBorder(GRAY_BORDER);
        calificacionEdadTexto = new JTextField();
        calificacionEdadTexto.setBorder(GRAY_BORDER);
        //fechaLanzamientotexto = new JTextField();
        datePicker.setBorder(GRAY_BORDER);
        claveActivacionTexto = new JTextField();
        claveActivacionTexto.setBorder(GRAY_BORDER);
        //expiracionClaveTexto = new JTextField();
        datePicker.setBorder(GRAY_BORDER);

        guardarBTN = new JButton();
        if (esActualizar) {
            guardarBTN.setText("Actualizar");
        } else {
            guardarBTN.setText("Agregar");
        }

        panelLabels.add(idLabel);
        panelLabels.add(nombreLabel);
        panelLabels.add(precioLabel);
        panelLabels.add(stockLabel);
        panelLabels.add(descripcionLabel);
        panelLabels.add(plataformaLabel);
        panelLabels.add(generoLabel);
        panelLabels.add(calificacionEdadLabel);
        panelLabels.add(fechaLanzamientoLabel);
        panelLabels.add(claveActivacionLabel);
        panelLabels.add(experacionClaveLabel);

        panelTexto.add(idTexto);
        panelTexto.add(nombreTexto);
        panelTexto.add(precioTexto);
        panelTexto.add(stockTexto);
        panelTexto.add(descripcionTexto);
        panelTexto.add(plataformaTexto);
        panelTexto.add(generoTexto);
        panelTexto.add(calificacionEdadTexto);
        panelTexto.add(datePicker);
        panelTexto.add(claveActivacionTexto);
        panelTexto.add(datePicker2);

        add(titulo, BorderLayout.NORTH);
        add(panelLabels, BorderLayout.WEST);
        add(panelTexto, BorderLayout.CENTER);
        add(guardarBTN, BorderLayout.SOUTH);

        guardarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarOActualizarVideoJuego(esActualizar);
            }
        });


    }

    private void agregarOActualizarVideoJuego(boolean esActualizar) {
        try {
            int idint = Integer.parseInt(idTexto.getText());
            String nombre = nombreTexto.getText();
            double precioDouble = Double.parseDouble(precioTexto.getText());
            int stockint = Integer.parseInt(stockTexto.getText());
            String descripcion = descripcionTexto.getText();
            String plataforma = plataformaTexto.getText();
            String genero = generoTexto.getText();
            String calificacionEdad = calificacionEdadTexto.getText();
            Date seleccionFecha = (Date) datePicker.getModel().getValue();
            String fechaLanzamiento = seleccionFecha.toString();
            String claveActivacion = claveActivacionTexto.getText();
            Date seleccionFecha2 = (Date) datePicker2.getModel().getValue();
            String expiracionClave = seleccionFecha2.toString();

            if (esActualizar) {
                VideoJuegoDigital videojuegoDigitalActual = new VideoJuegoDigital(idint, nombre, precioDouble, stockint, descripcion, plataforma, genero, calificacionEdad, fechaLanzamiento, claveActivacion, expiracionClave);
                videojuegoDigitalActual.setId(idint);
                videojuegoDigitalActual.setNombre(nombre);
                videojuegoDigitalActual.setPrecio(precioDouble);
                videojuegoDigitalActual.setStock(stockint);
                videojuegoDigitalActual.setDescripcion(descripcion);
                videojuegoDigitalActual.setPlataforma(plataforma);
                videojuegoDigitalActual.setGenero(genero);
                videojuegoDigitalActual.setCalificacionEdad(calificacionEdad);
                videojuegoDigitalActual.setClaveActivacion(claveActivacion);
                videojuegoDigitalActual.setFechaLanzamiento(fechaLanzamiento);
                videojuegoDigitalActual.setExpiracionClave(expiracionClave);

                ControllerVideoJuego.actualizarVideojuego(videojuegoDigitalActual);
                JOptionPane.showMessageDialog(GUIAgregarDigital.this, "Videojuego digital actualizado con éxito.", "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);

            } else {

                VideoJuego nuevoVideoJuego = new VideoJuegoDigital(idint, nombre, precioDouble, stockint, descripcion, plataforma, genero, calificacionEdad, fechaLanzamiento, claveActivacion, expiracionClave);


                ControllerVideoJuego.agregarVideoJuego(nuevoVideoJuego);
                JOptionPane.showMessageDialog(this, "Videojuego agregado exitosamente: ", "Exito", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al " + (esActualizar ? "actualizar" : "agregar") + " el videojuego: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarDatosDigital(VideoJuegoDigital videojuegoDigital) {
        idTexto.setText(String.valueOf(videojuegoDigital.getId()));
        nombreTexto.setText(videojuegoDigital.getNombre());
        precioTexto.setText(String.format("%.2f", videojuegoDigital.getPrecio()));
        stockTexto.setText(String.valueOf(videojuegoDigital.getStock()));
        descripcionTexto.setText(videojuegoDigital.getDescripcion());
        plataformaTexto.setText(videojuegoDigital.getPlataforma());
        generoTexto.setText(videojuegoDigital.getGenero());
        calificacionEdadTexto.setText(videojuegoDigital.getCalificacionEdad());
        claveActivacionTexto.setText(videojuegoDigital.getClaveActivacion());

        LocalDate fechaLanzamiento = LocalDate.parse(videojuegoDigital.getFechaLanzamiento());
        datePicker.getModel().setDate(fechaLanzamiento.getYear(), fechaLanzamiento.getMonthValue() - 1, fechaLanzamiento.getDayOfMonth());
        datePicker.getModel().setSelected(true);

        LocalDate expiracionClave = LocalDate.parse(videojuegoDigital.getExpiracionClave());
        datePicker2.getModel().setDate(expiracionClave.getYear(), expiracionClave.getMonthValue() - 1, expiracionClave.getDayOfMonth());
        datePicker2.getModel().setSelected(true);
    }

}


