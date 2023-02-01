package program.backend.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Account {
    @SerializedName("username")
    private String userName;
    private String email;
    @SerializedName("password")
    private String passWord;

}
