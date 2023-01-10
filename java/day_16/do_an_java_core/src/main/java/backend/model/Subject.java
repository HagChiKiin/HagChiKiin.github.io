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
    @SerializedName("mathpoint")
    private double mathPoint;
    @SerializedName("literaturepoint")
    private double literaturePoint;
    @SerializedName("englishpoint")
    private double englishPoint;


    @Override
    public String toString() {
        System.out.printf("%-5d %-12.2f %-12.2f %-12.2f",this.getIdStudent(), this.getMathPoint(),
                this.getLiteraturePoint(), this.getEnglishPoint());
        return "";
    }
}
