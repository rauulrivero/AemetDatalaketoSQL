package es.ulpgc.dacd.aemet.api.datalake;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import es.ulpgc.dacd.aemet.api.command.AddCommand;
import es.ulpgc.dacd.aemet.api.model.Weather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatafileReader {
    public List<Weather> getWeathers(String filename) throws IOException {
        List<Weather> weathers = new ArrayList<>();
        List<String> filelines = datalakereader(filename);
        for (String line: filelines) {
            JsonArray jsonArray = new JsonParser().parse(line).getAsJsonArray();
            List<Weather> weathersline = AddCommand.add(jsonArray);
            weathers.addAll(weathersline);
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
