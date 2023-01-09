package es.ulpgc.dacd.aemet.api;

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


        // Crear una instancia anónima de TimerTask
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                try {
                    Controller.run();
                    System.out.println("Se ha creado la conexión correctamente.");
                } catch (SQLException e) {
                    System.out.println("No se ha podido ontener la conexión para crear la API.");
                }

            }
        };

        // Programar la tarea para ejecutarse cada hora

        timer.scheduleAtFixedRate(tarea, (long) 10 * 1000, (long) 60 * 60 * 1000);
    }
}
