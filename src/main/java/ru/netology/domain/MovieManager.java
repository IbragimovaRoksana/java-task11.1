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
        Movie[] posters = repository.findAll();
        if (posters.length < countMovie) {
            Movie[] result = new Movie[posters.length];
            // перебираем массив в прямом порядке
            // но кладём в результаты в обратном
            for (int i = 0; i < result.length; i++) {
                int index = posters.length - i - 1;
                result[i] = posters[index];
            }
            return result;
        } else {
            Movie[] result = new Movie[countMovie];
            // перебираем массив в прямом порядке
            // но кладём в результаты в обратном
            for (int i = 0; i < countMovie; i++) {
                int index = posters.length - i - 1;
                result[i] = posters[index];
            }
            return result;
        }
    }


    // наивная реализация
//    public void removeById(int id) {
//        int length = items.length - 1;
//        PurchaseItem[] tmp = new PurchaseItem[length];
//        int index = 0;
//        for (PurchaseItem item : items) {
//            if (item.getId() != id) {
//                tmp[index] = item;
//                index++;
//            }
//        }
    // меняем наши элементы
//        items = tmp;
//    }
}
