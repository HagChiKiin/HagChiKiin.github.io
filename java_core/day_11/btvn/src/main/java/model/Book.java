package model;

import lombok.*;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private int id;
    private String title;
    private String[] category ;
    private String author;
    private int page_number;
    private int release_year;

    @Override
    public String toString() {

        System.out.printf("%-5d %-40s %-30s %-25s %-10d %-5d", this.getId(), this.getTitle(),
                Arrays.toString(this.getCategory()), this.getAuthor(), this.getPage_number(), this.getRelease_year());
        return "";
    }


}
