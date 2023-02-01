package backend.request;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
public class CreateStudent {
    private int id;
    @SerializedName("fullname")
    private String fullName;
    private String birthday;
    private String gender;
    private String address;

}
