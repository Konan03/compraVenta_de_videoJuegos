package controller;

import model.IActualizable;
import model.IDescuentoAplicable;
import model.VideoJuego;

import java.util.ArrayList;
import java.util.List;

public class ControllerVideoJuego  {

    private static List<VideoJuego> videoJuegos = new ArrayList<>();
    private static List<IActualizable> guiActualiza = new ArrayList<>();

    public static List<VideoJuego> getVideoJuegos() {
        return videoJuegos;
    }

    public static void setVideoJuegos(List<VideoJuego> videoJuegos) {
        ControllerVideoJuego.videoJuegos = videoJuegos;
    }

    public static void agregarVideoJuego(VideoJuego videoJuego) throws RuntimeException {
        if (videoJuego != null) {
            if (videoJuego.validarVideoJuego()) {
                if (!existeId(videoJuego.getId())) {
                    videoJuegos.add(videoJuego);
                    System.out.println("Videojuego agregado correctamente.");
                    actualizar();
                } else {
                    throw new RuntimeException("Error: Ya existe un videojuego con ese ID.");
                }
            } else {
                throw new RuntimeException("Error: Campos inválidos para el videojuego.");
            }
        } else {
            throw new RuntimeException("Error: Videojuego nulo.");
        }
    }

    private static boolean existeId(int id) {
        for (VideoJuego v : videoJuegos) {
            if (v.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void eliminarVideoJuego(int id) {
        for (VideoJuego videoJuego : videoJuegos) {
            if (videoJuego.getId() == id) {
                videoJuegos.remove(videoJuego);
                System.out.println("Videojuego eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún videojuego con ese ID.");
    }

    public static void eliminarVideoJuego(String nombre) {
        videoJuegos.removeIf(videoJuego -> nombre.equalsIgnoreCase(videoJuego.getNombre()));
    }

    public static void actualizarVideojuego(int id, VideoJuego videoJuegoActualizado) {
        for (int i = 0; i < videoJuegos.size(); i++) {
            if (videoJuegos.get(i).getId() == id) {
                videoJuegos.set(i, videoJuegoActualizado);
                System.out.println("Videojuego actualizado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún videojuego con ese ID.");
    }

    public static List<VideoJuego> listarVideoJuegos() {
        return new ArrayList<>(videoJuegos);
    }


    public static VideoJuego buscarVideoJuego(int id) {
        for (VideoJuego videojuego : videoJuegos) {
            if (videojuego.getId() == id) {
                return videojuego;
            }
        }
        return null;
    }

    public static VideoJuego buscarVideoJuegoPorNombre(String nombre) {
        for (VideoJuego videojuego : videoJuegos) {
            if (videojuego.getNombre().equalsIgnoreCase(nombre)) {
                return videojuego;
            }
        }
        return null;
    }


    public static List<VideoJuego> buscarVideoJuego(String nombre) {
        List<VideoJuego> resultados = new ArrayList<>();
        for (VideoJuego videojuego : videoJuegos) {
            if (videojuego.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(videojuego);
            }
        }
        return resultados;
    }

    public void addActualizable(IActualizable actualizable){
        guiActualiza.add(actualizable);
    }

    public static void actualizar(){
        for (IActualizable act : guiActualiza){
            act.actualizar();
        }
    }

    public static String aplicarDescuentoPorId(int id) {
        VideoJuego videoJuego = buscarVideoJuego(id);
        if (videoJuego != null && videoJuego instanceof IDescuentoAplicable) {
            double descuentoAplicado = ((IDescuentoAplicable) videoJuego).aplicarDescuento();
            return "Descuento aplicado. Nuevo precio: " + videoJuego.getPrecio();
        }
        return "Videojuego no encontrado o no aplicable para descuento.";
    }

    public static String aplicarDescuentoPorNombre(String nombre) {
        VideoJuego videoJuego = buscarVideoJuegoPorNombre(nombre);
        if (videoJuego != null && videoJuego instanceof IDescuentoAplicable) {
            double descuentoAplicado = ((IDescuentoAplicable) videoJuego).aplicarDescuento();
            return "Descuento aplicado. Nuevo precio: " + videoJuego.getPrecio();
        }
        return "Videojuego no encontrado o no aplicable para descuento.";
    }
}





