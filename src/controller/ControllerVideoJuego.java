package controller;

import model.VideoJuego;
import model.VideoJuegoDigital;
import model.VideoJuegoFisico;

import java.util.ArrayList;
import java.util.List;

public class ControllerVideoJuego {

    private static List<VideoJuego> videoJuegos = new ArrayList<>();

    public static void agregarVideoJuego(VideoJuego videoJuego) {
        if (videoJuego != null) {
            boolean existe = false;
            for (VideoJuego v : videoJuegos) {
                if (videoJuego.getNombre().equals(v.getNombre())) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                videoJuegos.add(videoJuego);
            }
        }
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
        videoJuegos.removeIf(videoJuego -> nombre.equals(videoJuego.getNombre()));
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

    public static void listarVideoJuegos() {
        for (VideoJuego videoJuego : videoJuegos) {
            System.out.println(videoJuego);
        }
    }

    public static VideoJuego buscarVideoJuego(int id) {
        for (VideoJuego videojuego : videoJuegos) {
            if (videojuego.getId() == id) {
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
}
