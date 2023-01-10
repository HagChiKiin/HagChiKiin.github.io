package backend.request;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateStudent {
    @SerializedName("fullname")
    private String fullName;
    private String birthday;
    private String gender;
    private String address;
}
