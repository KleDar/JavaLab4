package org.example.model;

public class Division {
    private final int id;
    private final String name;

    public Division(String name) {
        this.name = name;
        this.id = generateIdFromName(name);
    }
    private int generateIdFromName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Название подразделения не может быть пустым");
        }
        return (int) name.charAt(0); // ASCII код первой буквы
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Division{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}