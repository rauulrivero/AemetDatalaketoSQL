package es.ulpgc.dacd.aemet.api.datalake;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import es.ulpgc.dacd.aemet.api.command.Command;
import es.ulpgc.dacd.aemet.api.model.Weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Datafile reader.
 */
public class DatalakeReader implements FileReader {

    public List<Weather> getWeathers(String pathname) throws IOException, ParseException {
        File dir = new File(pathname);
        File[] files = dir.listFiles();
        List<Weather> weathers = new ArrayList<>();
        if (files == null) return weathers;
        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                List<String> filelines = datalakereader(fileName);
                for (String line: filelines) {
                    if (!line.isEmpty()) {
                        JsonArray jsonArray = JsonParser.parseString(line).getAsJsonArray();
                        List<Weather> weathersline = Command.add(jsonArray);
                        weathers.addAll(weathersline);
                    }
                }
            }
        }
        return weathers;
    }


    private List<String> datalakereader(String fileName) throws IOException {
        java.io.FileReader fileReader = new java.io.FileReader("datalake/" + fileName);
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
