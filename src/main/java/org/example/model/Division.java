package org.example.model;

/**
 * Класс, представляющий подразделение.
 * Содержит информацию о названии и уникальном числовом идентификаторе.
 */
public class Division {
    /**
     * Уникальный числовой идентификатор подразделения.
     */
    private final int id;
    /**
     * Название подразделения (например: "I", "G").
     */
    private final String name;

    /**
     * Конструктор создаёт объект подразделения на основе его названия.
     * ID генерируется автоматически как ASCII-код первой буквы.
     *
     * @param name название подразделения
     */
    public Division(String name) {
        this.name = name;
        this.id = generateIdFromName(name);
    }

    /**
     * Генерирует числовой ID из названия подразделения.
     * Используется ASCII-код первой буквы названия.
     *
     * @param name название подразделения
     * @return числовой идентификатор
     */
    private int generateIdFromName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Название подразделения не может быть пустым");
        }
        return (int) name.charAt(0); // ASCII код первой буквы
    }

    /**
     * Возвращает числовой идентификатор подразделения.
     *
     * @return числовой ID
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает название подразделения.
     *
     * @return название подразделения
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает строковое представление объекта Division.
     *
     * @return строка с полями объекта
     */
    @Override
    public String toString() {
        return "Division{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}