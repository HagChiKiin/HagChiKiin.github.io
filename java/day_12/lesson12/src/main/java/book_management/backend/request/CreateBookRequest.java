package book_management.backend.request;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class CreateBookRequest {
    private String title;

    @SerializedName("category")
    private List<String> categories;
    private String author;

    @SerializedName("page_number")
    private int pageNumber;
    @SerializedName("release_year")
    private int releaseYear;

    public CreateBookRequest(String title, String author, int pageNumber, int releaseYear) {
        this.title = title;
        this.categories = new ArrayList<>();
        this.author = author;
        this.pageNumber = pageNumber;
        this.releaseYear = releaseYear;
    }
}
