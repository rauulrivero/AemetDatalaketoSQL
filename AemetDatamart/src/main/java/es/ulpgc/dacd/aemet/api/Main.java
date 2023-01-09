package es.ulpgc.dacd.aemet.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        Controller controller = new Controller();

        // Crear una instancia anónima de TimerTask
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                try {
                    controller.run();
                } catch (IOException | SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Los datos se han actualizado correctamente.");
            }
        };

        // Programar la tarea para ejecutarse cada hora

        timer.scheduleAtFixedRate(tarea, 0, 60 * 60 * 1000);
    }

}
