package es.ulpgc.dacd.aemet.api.datalake;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import es.ulpgc.dacd.aemet.api.command.Command;
import es.ulpgc.dacd.aemet.api.model.Weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Datafile reader.
 */
public class DatafileReader implements Datalake{

    public List<Weather> getWeathers(String pathname) throws IOException {
        File dir = new File(pathname);
        File[] files = dir.listFiles();
        List<Weather> weathers = new ArrayList<>();
        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                List<String> filelines = datalakereader(fileName);
                for (String line: filelines) {
                    JsonArray jsonArray = new JsonParser().parse(line).getAsJsonArray();
                    List<Weather> weathersline = Command.add(jsonArray);
                    weathers.addAll(weathersline);
                }
            }
        }
        return weathers;
    }


    private List<String> datalakereader(String fileName) throws IOException {
        FileReader fileReader = new FileReader("datalake/" + fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> stringBuilder = new ArrayList<>();
        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuilder.add(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return stringBuilder;
    }

}
