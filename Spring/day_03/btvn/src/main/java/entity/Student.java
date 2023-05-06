package entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString


public class Student extends Person {

    private int id;
    private String classRoom;

    private static int AUTO_ID = 10000;

    public Student() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }


    @Override
    public void inputInfo() {
        super.inputInfo();
    }
}


