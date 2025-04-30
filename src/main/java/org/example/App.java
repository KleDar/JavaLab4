package org.example;

import org.example.model.Person;
import org.example.service.PersonService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        PersonService service = new PersonService();
        try {
            List<Person> people = service.readPeopleFromCsv("foreign_names.csv", ';');
            for (Person p : people) {
                System.out.println(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}