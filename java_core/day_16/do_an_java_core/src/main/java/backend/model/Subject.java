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
public class Subject {
    @SerializedName("idstudent")
    private int idStudent;
    private String name;
    @SerializedName("mathpoint")
    private double mathPoint;
    @SerializedName("literaturepoint")
    private double literaturePoint;
    @SerializedName("englishpoint")
    private double englishPoint;


    @Override
    public String toString() {
        System.out.printf("%-5d %-10s %-12.1f %-20.1f %-15.1f",this.getIdStudent(), this.getName(), this.getMathPoint(),
                this.getLiteraturePoint(), this.getEnglishPoint());
        return "";
    }
}
