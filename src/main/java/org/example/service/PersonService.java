package org.example.service;

import org.example.model.Division;
import org.example.model.Person;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParserBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class PersonService {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public List<Person> readPeopleFromCsv(String csvFilePath, char separator) throws Exception {
        List<Person> people = new ArrayList<>();

        try (
                InputStream in = getClass().getClassLoader().getResourceAsStream(csvFilePath);
                Reader reader = new InputStreamReader(Objects.requireNonNull(in), StandardCharsets.UTF_8);
                CSVReader csvReader = new CSVReaderBuilder(reader)
                        .withCSVParser(new CSVParserBuilder()
                                .withSeparator(separator)
                                .build())
                        .build();
        ) {
            if (csvReader == null) {
                throw new FileNotFoundException("Файл не найден: " + csvFilePath);
            }

            // Пропускаем заголовок
            csvReader.readNext();

            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                String id = nextLine[0];
                String name = nextLine[1];
                String gender = nextLine[2];
                LocalDate birthDate = LocalDate.parse(nextLine[3], DATE_FORMATTER);
                String divisionName = nextLine[4];
                double salary = Double.parseDouble(nextLine[5]);

                Division division = new Division(divisionName);
                Person person = new Person(id, name, gender, birthDate, division, salary);
                people.add(person);
            }
        }

        return people;
    }

}
