package ru.netology.domain;


public class MovieManager {

    private MovieRepository repository;

    private int countMovie = 10;

    public Movie[] getPosters() {
        return repository.findAll();
    }

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public void setCountMovie(int countMovie) {
        this.countMovie = countMovie;
    }

    public void add(Movie poster) {
        repository.save(poster);
    }

    public Movie[] getAll() {
        int length;
        Movie[] posters = repository.findAll();
        if (posters.length < countMovie) length = posters.length;
        else length = countMovie;
        Movie[] result = new Movie[length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = posters.length - i - 1;
            result[i] = posters[index];
        }
        return result;
    }

}
