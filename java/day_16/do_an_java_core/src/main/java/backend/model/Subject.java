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
    @SerializedName("subjectname")
    private String subjectName;
    private double point;

    @Override
    public String toString() {
        System.out.printf("%-15d %-15s %-15d ", this.getSubjectName(), this.getPoint());
        return "";
    }
}
