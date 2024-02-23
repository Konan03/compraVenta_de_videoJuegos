package controller;

import model.VideoJuego;

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


    public static void eliminarVideoJuego(String nombre) {
        videoJuegos.removeIf(videoJuego -> nombre.equals(videoJuego.getNombre()));
    }

    //otra posible forma
    /*
    public static void eliminarVideoJuego(String nombre) {
        for (int i = 0; i < videoJuegos.size(); i++) {
            if (nombre.equals(videoJuegos.get(i).getNombre())) {
                videoJuegos.remove(i);
                break;
            }
        }
    }
    */

    public static void listarVideoJuegos(){
        for (VideoJuego videoJuego : videoJuegos){
            System.out.println(videoJuego);
        }
    }



}
