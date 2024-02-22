package model;

import java.time.LocalDate;

public class VideoJuegoDigital extends VideoJuego{

    private String claveActivacion;
    private LocalDate expiracionClave;

    public VideoJuegoDigital(int id, String nombre, double precio, int stock, String descripcion, String plataforma, String genero, String calificacionEdad, LocalDate fechaLanzamiento, String calveActivacion, LocalDate expiracionClave) {
        super(id, nombre, precio, stock, descripcion, plataforma, genero, calificacionEdad, fechaLanzamiento);
        this.claveActivacion = calveActivacion;
        this.expiracionClave = expiracionClave;
    }

    public String getClaveActivacion() {
        return claveActivacion;
    }

    public void setClaveActivacion(String claveActivacion) {
        this.claveActivacion = claveActivacion;
    }

    public LocalDate getExpiracionClave() {
        return expiracionClave;
    }

    public void setExpiracionClave(LocalDate expiracionClave) {
        this.expiracionClave = expiracionClave;
    }
}
