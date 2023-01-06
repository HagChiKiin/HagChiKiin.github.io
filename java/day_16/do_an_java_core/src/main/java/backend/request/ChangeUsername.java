package backend.request;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
public class ChangeUsername {
    @SerializedName("username")
    private String userName;

}
