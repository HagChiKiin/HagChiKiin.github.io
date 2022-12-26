package program.backend.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ChangeRequest {
    private String userName;
    private String email;
    private String passWord;

    public ChangeRequest(String userName) {
        this.userName = userName;

    }
    public ChangeRequest(String email, String userName){
        this.userName = userName;
        this.email = email;
    }
    public ChangeRequest(String passWord,String userName,String email){
        this.passWord = passWord;
        this.email = email;
        this.userName = userName;
    }







}
