package es.ulpgc.dacd.aemet.api.datalake;

import com.google.gson.Gson;
import es.ulpgc.dacd.aemet.api.model.Weather;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.*;

public class FileDatalake implements Datalake{

    private final static String PATH_LAST_RECORD_REGISTER = "datalake/lastTimeRegister.data";

    public void createFile(List<Weather> events) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String path = "datalake/" + sdf.format(new Date()) + ".events";
        Date lastDate = readLastTime();
        if (lastDate != null) {
            events = events.stream()
                    .filter(event -> event.getDate().after(lastDate))
                    .collect(Collectors.toList());
        }


        if (!events.isEmpty()) createFileLastRecord(events.get(events.size()-1).getDate());

        Gson gson = new Gson();


        try (FileWriter fw = new FileWriter(format(path), true)) {

            fw.append(gson.toJson(events));
            fw.append("\n");
        }
    }

    private void createFileLastRecord(Date lastDate) throws IOException {
        try (FileWriter fw = new FileWriter(PATH_LAST_RECORD_REGISTER, false)) {
            fw.append(lastDate.getTime() + "");
        }
    }

    private Date readLastTime() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_LAST_RECORD_REGISTER))){
            String line = bufferedReader.readLine();
            if (line != null) {
                return new Date(Long.parseLong(line));
            }
        }
        return null;
    }

}
