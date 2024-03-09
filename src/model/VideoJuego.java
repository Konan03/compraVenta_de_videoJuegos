package model;

public abstract class VideoJuego {

    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String descripcion;
    private String plataforma;
    private String genero;
    private String calificacionEdad;
    private String fechaLanzamiento;

    public VideoJuego(int id, String nombre, double precio, int stock,
                      String descripcion, String plataforma, String genero,
                      String calificacionEdad, String fechaLanzamiento) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.plataforma = plataforma;
        this.genero = genero;
        this.calificacionEdad = calificacionEdad;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCalificacionEdad() {
        return calificacionEdad;
    }

    public void setCalificacionEdad(String calificacionEdad) {
        this.calificacionEdad = calificacionEdad;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public abstract boolean validarVideoJuego();


    @Override
    public String toString() {
        return "VideoJuego{" +
                "\nid=" + id +
                ",\nnombre='" + nombre + '\'' +
                ",\nprecioNormal=" + precio +
                ",\nprecioDescuento=" + precio +
                ",\nstock=" + stock +
                ",\ndescripcion='" + descripcion + '\'' +
                ",\nplataforma='" + plataforma + '\'' +
                ",\ngenero='" + genero + '\'' +
                ",\ncalificacionEdad='" + calificacionEdad + '\'' +
                ",\nfechaLanzamiento=" + fechaLanzamiento +
                "\n}";
    }


}
