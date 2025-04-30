package org.example.service;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class PersonService {
    public static void main(String[] args) {
        String csvFilePath = "foreign_names.csv";
        char separator = ';';

        try (
                InputStream in = PersonService.class.getClassLoader().getResourceAsStream(csvFilePath);
                Reader reader = new InputStreamReader(Objects.requireNonNull(in), StandardCharsets.UTF_8);
                CSVReader csvReader = new CSVReaderBuilder(reader)
                        .withCSVParser(new com.opencsv.CSVParserBuilder()
                                .withSeparator(separator)
                                .build())
                        .build();
        ) {
            if (csvReader == null) {
                throw new FileNotFoundException("Файл не найден: " + csvFilePath);
            }

            String[] nextLine;
            int lineNumber = 0;
            while ((nextLine = csvReader.readNext()) != null) {
                System.out.println("Строка " + (lineNumber++) + ": " + String.join(" | ", nextLine));
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
