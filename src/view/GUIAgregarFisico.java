package view;

import controller.ControllerVideoJuego;
import model.VideoJuego;
import model.VideoJuegoFisico;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;


public class GUIAgregarFisico extends JFrame implements IGUIEstilos {

    private JTextField idTexto, nombreTexto, precioTexto, stockTexto,
            plataformaTexto, generoTexto, calificacionEdadTexto, estadoTexto, empaqueTexto;

    private JTextArea descripcionTexto;
    private JLabel idLabel, nombreLabel, precioLabel, stockLabel, descripcionLabel,
            plataformaLabel, generoLabel, calificacionEdadLabel, fechaLanzamientoLabel, estadoLabel, empaqueLabel;
    private JButton guardarBTN;

    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

    public GUIAgregarFisico(boolean esActualizar)  {

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
        panelLabels.setLayout(new GridLayout(11,1));
        panelLabels.setBackground(COLOR);
        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new GridLayout(11,1));
        panelTexto.setBackground(COLOR);

        setTitle("Agregar video juego");
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
        fechaLanzamientoLabel= new JLabel("Fecha Lanzamiento: ");
        fechaLanzamientoLabel.setHorizontalAlignment(JLabel.CENTER);
        estadoLabel = new JLabel("Estado: ");
        estadoLabel.setHorizontalAlignment(JLabel.CENTER);
        empaqueLabel = new JLabel("Empaque: ");
        empaqueLabel.setHorizontalAlignment(JLabel.CENTER);

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
        estadoTexto = new JTextField();
        estadoTexto.setBorder(GRAY_BORDER);
        empaqueTexto = new JTextField();
        empaqueTexto.setBorder(GRAY_BORDER);

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
        panelTexto.add(datePicker);
        panelTexto.add(estadoTexto);
        panelTexto.add(empaqueTexto);

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
            String estado = estadoTexto.getText();
            String empaque = empaqueTexto.getText();

            if (esActualizar) {
                VideoJuegoFisico videojuegoFisicoActual = new VideoJuegoFisico(idint, nombre, precioDouble, stockint, descripcion, plataforma, genero, calificacionEdad, fechaLanzamiento, estado, empaque);
                videojuegoFisicoActual.setId(idint);
                videojuegoFisicoActual.setNombre(nombre);
                videojuegoFisicoActual.setPrecio(precioDouble);
                videojuegoFisicoActual.setStock(stockint);
                videojuegoFisicoActual.setDescripcion(descripcion);
                videojuegoFisicoActual.setPlataforma(plataforma);
                videojuegoFisicoActual.setGenero(genero);
                videojuegoFisicoActual.setCalificacionEdad(calificacionEdad);
                videojuegoFisicoActual.setEstado(estado);
                videojuegoFisicoActual.setEmpaque(empaque);
                videojuegoFisicoActual.setFechaLanzamiento(fechaLanzamiento);

                ControllerVideoJuego.actualizarVideojuego(videojuegoFisicoActual);
            } else {

                VideoJuego nuevoVideoJuego = new VideoJuegoFisico(idint, nombre, precioDouble, stockint, descripcion, plataforma, genero, calificacionEdad, fechaLanzamiento, estado, empaque);


                ControllerVideoJuego.agregarVideoJuego(nuevoVideoJuego);
                JOptionPane.showMessageDialog(this, "Videojuego agregado exitosamente: ", "Exito", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al " + (esActualizar ? "actualizar" : "agregar") + " el videojuego: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void cargarDatosFisico(VideoJuegoFisico videojuegoFisico) {
        idTexto.setText(String.valueOf(videojuegoFisico.getId()));
        nombreTexto.setText(videojuegoFisico.getNombre());
        precioTexto.setText(String.format("%.2f", videojuegoFisico.getPrecio()));
        stockTexto.setText(String.valueOf(videojuegoFisico.getStock()));
        descripcionTexto.setText(videojuegoFisico.getDescripcion());
        plataformaTexto.setText(videojuegoFisico.getPlataforma());
        generoTexto.setText(videojuegoFisico.getGenero());
        calificacionEdadTexto.setText(videojuegoFisico.getCalificacionEdad());
        empaqueTexto.setText(videojuegoFisico.getEmpaque());
        estadoTexto.setText(videojuegoFisico.getEstado());
        LocalDate fechaLanzamiento = LocalDate.parse(videojuegoFisico.getFechaLanzamiento());
        model.setDate(fechaLanzamiento.getYear(), fechaLanzamiento.getMonthValue() - 1, fechaLanzamiento.getDayOfMonth());
        model.setSelected(true);
    }

}
