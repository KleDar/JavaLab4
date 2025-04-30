package org.example;

import org.example.model.Person;
import org.example.service.PersonService;

import java.util.List;

/**
 * Основной класс приложения.
 * Служит точкой входа для запуска программы.
 */
public class App {

    /**
     * Точка входа в приложение.
     * Создаёт сервис и выводит список сотрудников из CSV-файла.
     *
     * @param args аргументы командной строки
     */
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