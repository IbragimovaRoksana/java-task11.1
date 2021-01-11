package ru.netology.domain;

public class MovieRepository {
    private Movie[] posters = new Movie[0];

    public void save(Movie poster) {
        int length = posters.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(posters, 0, tmp, 0, posters.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = poster;
        posters = tmp;
    }

    public Movie[] findAll() {
        return posters;
    }

    public Movie findById(int id) {
        Movie result = new Movie();
        for (Movie poster : posters) {
            if (poster.getId() == id) {
                result = poster;
            }
        }
        return result;
    }

    public void removeById(int id) {
        int length = posters.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie poster : posters) {
            if (poster.getId() != id) {
                tmp[index] = poster;
                index++;
            }
        }
        posters = tmp;
    }

    public void removeAll() {
        Movie[] noPosters = new Movie[0];
        posters = noPosters;
    }

}

