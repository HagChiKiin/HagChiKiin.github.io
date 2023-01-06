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
public class Student {
    private int id;
    @SerializedName("fullname")
    private String fullName;
    private String birthday;
    private String gender;
    private String address;

    @Override
    public String toString() {

        System.out.printf("%-5d %-10s %-10s %-5s %-10s", this.getId(), this.getFullName(), this.getBirthday(),
                this.getGender(), this.getAddress());
        return "";
    }
}
