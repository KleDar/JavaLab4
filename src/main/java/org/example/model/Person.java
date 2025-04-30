package org.example.model;

import java.time.LocalDate;

/**
 * Класс, представляющий человека (сотрудника).
 * Содержит персональную информацию и ссылку на подразделение.
 */
public class Person {
    /**
     * Уникальный идентификатор сотрудника.
     */
    private final String id;
    /**
     * Имя сотрудника.
     */
    private final String name;
    /**
     * Пол сотрудника.
     */
    private final String gender;
    /**
     * Дата рождения сотрудника.
     */
    private final LocalDate birthDate;
    /**
     * Подразделение, в котором работает сотрудник.
     */
    private final Division division;
    /**
     * Зарплата сотрудника
     */
    private final double salary;

    /**
     * Конструктор создаёт объект Person на основе переданных данных.
     *
     * @param id        уникальный ID сотрудника
     * @param name      имя сотрудника
     * @param gender    пол сотрудника
     * @param birthDate дата рождения
     * @param division  подразделение
     * @param salary    зарплата
     */
    public Person(String id, String name, String gender, LocalDate birthDate, Division division, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.division = division;
        this.salary = salary;
    }

    /**
     * Возвращает уникальный ID сотрудника.
     *
     * @return ID сотрудника
     */
    public String getId() {
        return id;
    }

    /**
     * Возвращает имя сотрудника.
     *
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает пол сотрудника.
     *
     * @return пол
     */
    public String getGender() {
        return gender;
    }

    /**
     * Возвращает дату рождения сотрудника.
     *
     * @return дата рождения
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Возвращает подразделение, в котором работает сотрудник.
     *
     * @return подразделение
     */
    public Division getDivision() {
        return division;
    }

    /**
     * Возвращает зарплату сотрудника.
     *
     * @return зарплата
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Возвращает строковое представление объекта Person.
     *
     * @return строка с полями объекта
     */
    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", division=" + division +
                ", salary=" + salary +
                '}';
    }
}