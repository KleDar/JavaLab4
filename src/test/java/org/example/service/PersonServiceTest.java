package org.example.service;

import org.example.model.Division;
import org.example.model.Person;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    private final PersonService service = new PersonService();

    @Test
    void testReadPeopleFromCsv_validFile_returnsCorrectList() throws Exception {
        List<Person> people = service.readPeopleFromCsv("test_people.csv", ';');

        assertNotNull(people);
        assertEquals(2, people.size());

        Person first = people.get(0);
        assertEquals("12345", first.getId());
        assertEquals("John Doe", first.getName());
        assertEquals("Male", first.getGender());
        assertEquals(LocalDate.of(1990, 1, 1), first.getBirthDate());
        assertEquals(5000.0, first.getSalary());
        assertEquals((int) 'A', first.getDivision().getId()); // Явное преобразование char → int
    }

    @Test
    void testReadPeopleFromCsv_emptyFile_returnsEmptyList() throws Exception {
        List<Person> people = service.readPeopleFromCsv("empty_people.csv", ';');
        assertNotNull(people);
        assertTrue(people.isEmpty());
    }

    @Test
    void testReadPeopleFromCsv_invalidDateFormat_throwsException() {
        assertThrows(Exception.class, () ->
                service.readPeopleFromCsv("invalid_date.csv", ';')
        );
    }

    @Test
    void testReadPeopleFromCsv_duplicateDivisions_sameIdGenerated() throws Exception {
        List<Person> people = service.readPeopleFromCsv("duplicate_division.csv", ';');

        assertEquals(2, people.size());

        Division division1 = people.get(0).getDivision();
        Division division2 = people.get(1).getDivision();

        assertEquals(division1.getId(), division2.getId());
        assertEquals(division1.getName(), division2.getName());
    }

    @Test
    void testReadPeopleFromCsv_invalidSalaryFormat_throwsException() {
        assertThrows(NumberFormatException.class, () ->
                service.readPeopleFromCsv("invalid_salary.csv", ';')
        );
    }


}