package ru.netology.domain;


public class MovieManager {

    private Movie[] posters = new Movie[0];
    private int countMovie = 10;

    public Movie[] getPosters() {
        return posters;
    }

    public void setCountMovie(int countMovie) {
        this.countMovie = countMovie;
    }

    public void add(Movie poster) {
        // создаём новый массив размером на единицу больше
        int length = posters.length + 1;
        Movie[] tmp = new Movie[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < posters.length; i++) {
        //   tmp[i] = posters[i];
        // }
        System.arraycopy(posters, 0, tmp, 0, posters.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = poster;
        posters = tmp;
    }

    public Movie[] getAll() {
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
