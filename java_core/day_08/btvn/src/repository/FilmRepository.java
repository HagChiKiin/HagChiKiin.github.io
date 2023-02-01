package repository;

import database.FilmDatabase;
import model.Movie;
import model.Serial;

public class FilmRepository {
    public Movie[] findMovie(){
        return FilmDatabase.movies;
    }
    public Serial[] findSerial(){
        return FilmDatabase.serials;
    }
}
