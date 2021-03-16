package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {

    private static final String SEPARATOR = ",";

    public String minWork(String file) {
        String minWorkerStr = "";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            String line;
            int min = Integer.MAX_VALUE;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(SEPARATOR);
                int hours = Integer.parseInt(parts[1]);

                if (hours < min) {
                    min = hours;
                    minWorkerStr = parts[0] + ": " + parts[2];
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("File cannot read!", e);
        }

        return minWorkerStr;
    }
}
