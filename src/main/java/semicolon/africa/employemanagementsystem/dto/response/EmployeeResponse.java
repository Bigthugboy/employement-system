package semicolon.africa.employemanagementsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeResponse {
    private String email;
    private String dateCreated;
    private String message;
}
