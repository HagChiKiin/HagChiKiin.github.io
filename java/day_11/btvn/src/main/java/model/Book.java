package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private int id;
    private String title;
    private String[] category = {"Action", "Drama", "Romance", "War", "Crime",
            "Adventure", "Comedy", "Horror", "Mystery", "Thriller", "Sci-Fi"};
    private String author;
    private int page_number;
    private int release_year;
}
