import controller.ControllerVideoJuego;
import model.VideoJuego;
import model.VideoJuegoDigital;
import model.VideoJuegoFisico;
import view.GUIPrincipal;

import java.time.LocalDate;

import static controller.ControllerVideoJuego.agregarVideoJuego;

public class Main {
    public static void main(String[] args) {

        GUIPrincipal guiPrincipal = new GUIPrincipal();
        guiPrincipal.setVisible(true);


        //Pruebas

        /*
        VideoJuego juego1 = new VideoJuegoDigital(1, "The Witcher 3", 59.99, 100,
                "RPG de mundo abierto", "PC",
                "Fantasía", "18+", LocalDate.of(2015, 5, 19),
                "ABCD-1234-EFGH-5678", LocalDate.of(2025, 12, 31));

        VideoJuego juego2 = new VideoJuegoFisico(2, "Red Dead Redemption 2", 49.99, 80,
                "Acción y aventura en el Salvaje Oeste", "PS4",
                "Western", "18+", LocalDate.of(2018, 10, 26),
                "Nuevo", "Caja");

        ControllerVideoJuego.agregarVideoJuego(juego1);
        ControllerVideoJuego.agregarVideoJuego(juego2);

        ControllerVideoJuego.listarVideoJuegos();

        System.out.println(ControllerVideoJuego.buscarVideoJuego("Dead"));
        System.out.println(ControllerVideoJuego.buscarVideoJuego(1));

        VideoJuego juegoActualizado = new VideoJuegoDigital(1, "The Witcher 3: Wild Hunt", 69.99, 120, "RPG de mundo abierto mejorado", "PC", "Fantasía", "18+", LocalDate.of(2015, 5, 19), "clave123", LocalDate.of(2025, 12, 31));
        ControllerVideoJuego.actualizarVideojuego(1, juegoActualizado);
        */
    }
}