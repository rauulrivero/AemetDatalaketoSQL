package es.ulpgc.dacd.aemet.api;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {


    public static void main(String[] args) {

        Timer timer = new Timer();
        Controller controller = new Controller();

        // Crear una instancia anónima de TimerTask
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                try {
                    controller.run();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Se ha creado la conexión correctamente.");
            }
        };

        // Programar la tarea para ejecutarse cada hora

        timer.scheduleAtFixedRate(tarea, 20 * 1000, 60 * 60 * 1000);
    }
}
