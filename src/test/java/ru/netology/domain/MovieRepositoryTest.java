package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {

    MovieRepository manager = new MovieRepository();
    Movie film0 = new Movie();
    Movie film1 = new Movie(1, "1URL", "Predator", "action");
    Movie film2 = new Movie(2, "2URL", "Commando", "action");
    Movie film3 = new Movie(3, "3URL", "Running Man", "action");
    Movie film4 = new Movie(4, "4URL", "Jingle All the Way", "comedy");
    Movie film5 = new Movie(5, "5URL", "Kindergarten Cop", "comedy");
    Movie film6 = new Movie(6, "6URL", "TrueLies", "action");

    @BeforeEach
    public void setUp() {
        manager.save(film1);
        manager.save(film2);
        manager.save(film3);
        manager.save(film4);
        manager.save(film5);
        manager.save(film6);
    }

    @Test
    void shouldSave() {
        Movie[] actual = manager.findAll();
        Movie[] expected = new Movie[]{film1, film2, film3, film4, film5, film6};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        setUp();
        Movie expected = film1;
        Movie actual = manager.findById(film1.getId());
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        setUp();
        manager.removeById(film1.getId());
        Movie[] expected = new Movie[]{film2, film3, film4, film5, film6};
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        setUp();
        Movie[] expected = new Movie[0];
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }
}