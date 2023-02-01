package backend.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Product {
    private String code;
    private String name;
    private String describe;
    private int price;
    private int quanlity;
    private int salenumber;
    private String firm;
    private String[] category;

}
