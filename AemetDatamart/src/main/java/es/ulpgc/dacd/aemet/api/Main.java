package es.ulpgc.dacd.aemet.api;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
                    System.out.println("Los datos se han actualizado correctamente.");
                } catch (IOException | SQLException | ParseException e) {
                    System.out.println("No se ha podido actualizar la tabla.");
                }
            }
        };

        // Programar la tarea para ejecutarse cada hora

        timer.scheduleAtFixedRate(tarea, (long) 1000, (long) 60 * 60 * 1000);

    }

}
