package backend.request;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
public class ChangePassword {
    private String passWord;
}
