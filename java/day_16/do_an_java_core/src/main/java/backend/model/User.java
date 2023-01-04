package backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {
    private String email;
    private String passWord;
    private String userName;
    @Override
    public String toString() {
        System.out.printf("%-5s %-5s %-5s ", this.getEmail(), this.getPassWord(),this.getUserName());
        return "";
    }
}
