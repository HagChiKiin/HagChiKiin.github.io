package entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Transcript {
    private Student student;
    private List<SubjectDetail> subjectDetails;

}
