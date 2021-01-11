package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    MovieManager manager = new MovieManager(10);
    Movie film0 = new Movie();
    Movie film1 = new Movie("1", "1URL", "Predator", "action");
    Movie film2 = new Movie("2", "2URL", "Commando", "action");
    Movie film3 = new Movie("3", "3URL", "Running Man", "action");
    Movie film4 = new Movie("4", "4URL", "Jingle All the Way", "comedy");
    Movie film5 = new Movie("5", "5URL", "Kindergarten Cop", "comedy");
    Movie film6 = new Movie("6", "6URL", "TrueLies", "action");
    Movie film7 = new Movie("7", "7URL", "The Terminator", "thriller");
    Movie film8 = new Movie("8", "8URL", "Conan the Barbarian", "fantastic");
    Movie film9 = new Movie("9", "9URL", "End of Days", "thriller");
    Movie film10 = new Movie("10", "10URL", "Terminator 2: Judgment Day", "thriller");
    Movie film11 = new Movie("11", "11URL", "Terminator 3: Judgment Day", "comedy");
    Movie film12 = new Movie("12", "12URL", "Terminator: Dark Fate", "parody");
    Movie film13 = new Movie("13", "13URL", "The 6th Day", "action");
    Movie film14 = new Movie("14", "14URL", "Batman & Robin", "fantastic");
    Movie film15 = new Movie("15", "15URL", "Eracer", "action");

    @Test
    void shouldAdd() {
        manager.add(film1);
        Movie[] actual = manager.getPosters();
        Movie[] expected = new Movie[]{film1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllMoreTen() {
        manager.add(film0);
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);
        manager.add(film11);
        manager.add(film12);
        manager.add(film13);
        manager.add(film14);
        manager.add(film15);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{film15, film14, film13, film12, film11, film10, film9, film8, film7, film6};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllLessTen() {
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{film7, film6, film5, film4, film3, film2, film1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllMoreFive() {
        manager.setCountMovie(5);
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{film7, film6, film5, film4, film3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllLessFive() {
        manager.setCountMovie(5);
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{film3, film2, film1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllNull() {
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }
}