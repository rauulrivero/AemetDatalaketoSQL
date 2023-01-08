package es.ulpgc.dacd.aemet.api;

import java.io.IOException;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {

        Timer timer = new Timer();
        Controller controller = new Controller();

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                try {
                    controller.run();
                } catch (IOException | ParseException e) {
                    System.out.println("No se ha podido almacenar los datos en el datalake");
                }
                System.out.println("Los datos se han actualizado correctamente.");
            }
        };


        timer.scheduleAtFixedRate(tarea, (long) 10 * 1000, (long) 60 * 60 * 1000);
    }


}
