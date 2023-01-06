package backend.request;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
public class CreateUser {
    private String userName;
    private String email;
    private String passWord;
}
