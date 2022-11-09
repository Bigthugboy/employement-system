package semicolon.africa.employemanagementsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import semicolon.africa.employemanagementsystem.data.model.Gender;
import semicolon.africa.employemanagementsystem.data.model.SchoolQualification;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private Gender gender;
    private String PhoneNumber;
    private int age;
    private List<SchoolQualification> schoolQualification;
}
