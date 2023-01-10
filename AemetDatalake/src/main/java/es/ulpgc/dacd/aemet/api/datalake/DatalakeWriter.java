package es.ulpgc.dacd.aemet.api.datalake;

import com.google.gson.Gson;
import es.ulpgc.dacd.aemet.api.model.Weather;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

/**
 * The type File datalake.
 */
public class DatalakeWriter implements FileWriter {

    private static final String PATH_LAST_RECORD_REGISTER = "lastTimeRegister/lastTimeRegister.data";

    public void createFile(List<Weather> events) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String path = "datalake/" + sdf.format(new Date()) + ".events";
        Date lastDate = readLastTime();

        events = events.stream()
                .filter(event -> event.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().equals(LocalDate.now()))
                .collect(Collectors.toList());

        if (lastDate != null) {
            events = events.stream()
                    .filter(event -> event.getDate().after(lastDate))
                    .collect(Collectors.toList());
            }


        if (!events.isEmpty()) createFileLastRecord(events.get(events.size()-1).getDate());

        Gson gson = new Gson();

        try (java.io.FileWriter fw = new java.io.FileWriter(format(path), true)) {
            if (!events.isEmpty()) {
                fw.append(gson.toJson(events));
                fw.append("\n");
            }
        }
    }

    private void createFileLastRecord(Date lastDate) throws IOException {
        try (java.io.FileWriter fw = new java.io.FileWriter(PATH_LAST_RECORD_REGISTER, false)) {
            fw.append(String.valueOf(lastDate.getTime()));
        }
    }

    private Date readLastTime() throws IOException {
        if (!new File(PATH_LAST_RECORD_REGISTER).exists()) return null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_LAST_RECORD_REGISTER))){
            String line = bufferedReader.readLine();
            if (line != null) {
                return new Date(Long.parseLong(line));
            }
        }
        return null;
    }

}
