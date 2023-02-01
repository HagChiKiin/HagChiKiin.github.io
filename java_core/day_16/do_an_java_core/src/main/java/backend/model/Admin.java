package backend.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Admin {
    @SerializedName("username")
    private String userName;
    private String email;
    @SerializedName("password")
    private String passWord;

    @Override
    public String toString() {
        System.out.printf("%-20s %-20s %-20s\n",this.getUserName(),this.getEmail(),this.getPassWord());
        return "";
    }
}