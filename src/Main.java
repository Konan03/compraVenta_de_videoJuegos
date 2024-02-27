import controller.ControllerVideoJuego;
import view.GUIPrincipal;


import static controller.ControllerVideoJuego.agregarVideoJuego;

public class Main {
    public static void main(String[] args) {

        ControllerVideoJuego controllerVideoJuego = new ControllerVideoJuego();

        GUIPrincipal guiPrincipal = new GUIPrincipal();
        guiPrincipal.setVideojuego(controllerVideoJuego);
        guiPrincipal.setVisible(true);
    }
}