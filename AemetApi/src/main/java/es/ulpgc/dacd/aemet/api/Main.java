package es.ulpgc.dacd.aemet.api;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {


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
                    throw new RuntimeException(e);
                }

            }
        };

        // Programar la tarea para ejecutarse cada hora

        timer.scheduleAtFixedRate(tarea, (long) 1000, (long) 60 * 60 * 1000);
    }
}
