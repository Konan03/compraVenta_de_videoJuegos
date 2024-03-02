package model;

public class VideoJuegoDigital extends VideoJuego implements IDescuentoAplicable  {

    private String claveActivacion;
    private String expiracionClave;

    public VideoJuegoDigital(int id, String nombre, double precio, int stock,
                             String descripcion, String plataforma, String genero,
                             String calificacionEdad, String fechaLanzamiento, String calveActivacion,
                             String expiracionClave) {
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

    public String getExpiracionClave() {
        return expiracionClave;
    }

    public void setExpiracionClave(String expiracionClave) {
        this.expiracionClave = expiracionClave;
    }

    @Override
    public String toString() {
        return "VideoJuegoDigital{" +
                "\n" + super.toString() +
                ",\nclaveActivacion='" + claveActivacion + '\'' +
                ",\nexpiracionClave=" + expiracionClave +
                "\n}";
    }

    @Override
    public double aplicarDescuento() {
        double descuento = getPrecio() * 0.15;
        setPrecio(getPrecio() - descuento);
        return descuento;
    }

    @Override
    public boolean validarVideoJuego() {
        return getClaveActivacion() != null && getExpiracionClave() != null && !getClaveActivacion().isEmpty() && !getExpiracionClave().isEmpty();
    }
}
