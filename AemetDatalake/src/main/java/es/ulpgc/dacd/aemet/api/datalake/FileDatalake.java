package es.ulpgc.dacd.aemet.api.datalake;

import com.google.gson.Gson;
import es.ulpgc.dacd.aemet.api.model.Weather;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.*;

public class FileDatalake implements Datalake{

    public void createFile(List<Weather> eventos) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String path = "datalake/" + sdf.format(new Date()) + ".events";
        initFile(eventos, path);
    }

    private void initFile(List<Weather> eventos, String path) throws IOException {
        List<Weather> eventos1 = eventos.stream()
                .filter(event -> LocalDate.parse(event.getDate()).equals(LocalDate.now()))
                .collect(Collectors.toList());

        Gson gson = new Gson();
        DatafileReader datafileReader = new DatafileReader();
        List<Weather> eventos2 = datafileReader.getWeathers(path);


        try (FileWriter fw = new FileWriter(format(path), true)) {

            fw.append(gson.toJson(eventos1));
            fw.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
