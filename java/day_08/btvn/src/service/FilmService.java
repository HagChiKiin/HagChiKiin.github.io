package service;

import model.Movie;
import model.Serial;
import repository.FilmRepository;

public class FilmService {
    public FilmRepository filmRepository = new FilmRepository();
    public Movie movie = new Movie();
    public Serial serial = new Serial();

    // In ra thông tin phim
    public void showFilm(){
        for (Movie movie : filmRepository.findMovie()) {
            System.out.println(movie);
        }
        for (Serial serial: filmRepository.findSerial()) {
            System.out.println(serial);

        }
    }

    // Tìm kiếm phim theo tiêu đề
    public void findByTitle(String title) {
        int count = 0;
        for (Movie movie : filmRepository.findMovie()) {
            if(movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(movie);
                count++;
            }
        }
        for (Serial serial :filmRepository.findSerial()) {
            if(serial.getTitle().toLowerCase().contains(title.toLowerCase())){
                System.out.println(serial);
            }
        }
        if(count == 0) {
            System.out.println("Không có phim nào có title = " + title);
        }
    }

}
