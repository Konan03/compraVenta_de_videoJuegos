package model;

import java.time.LocalDate;

public class VideoJuegoFisico extends VideoJuego{

    private String estado;
    private String empaque;

    public VideoJuegoFisico(int id, String nombre, double precio, int stock,
                            String descripcion, String plataforma, String genero,
                            String calificacionEdad, String fechaLanzamiento, String estado, String empaque) {

        super(id, nombre, precio, stock, descripcion, plataforma, genero, calificacionEdad, fechaLanzamiento);
        this.estado = estado;
        this.empaque = empaque;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmpaque() {
        return empaque;
    }

    public void setEmpaque(String empaque) {
        this.empaque = empaque;
    }

    @Override
    public String toString() {
        return "VideoJuegoFisico{" +
                super.toString() +
                "estado='" + estado + '\'' +
                ", empaque='" + empaque + '\'' +
                '}';
    }
}
