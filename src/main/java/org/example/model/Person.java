package org.example.model;

import java.time.LocalDate;

public class Person {
    private final String id;
    private final String name;
    private final String gender;
    private final LocalDate birthDate;
    private final Division division;
    private final double salary;

    public Person(String id, String name, String gender, LocalDate birthDate, Division division, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.division = division;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Division getDivision() {
        return division;
    }

    public double getSalary() {
        return salary;
    }

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