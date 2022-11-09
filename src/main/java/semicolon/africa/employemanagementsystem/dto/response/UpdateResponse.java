package semicolon.africa.employemanagementsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semicolon.africa.employemanagementsystem.data.model.Gender;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateResponse {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private Gender gender;
    private String PhoneNumber;
    private int age;
    private String Message;
}
