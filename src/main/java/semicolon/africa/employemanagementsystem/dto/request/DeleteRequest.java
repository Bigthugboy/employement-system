package semicolon.africa.employemanagementsystem.dto.request;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteRequest {
    private String email;
    private Long id;
    private String employeeId;

}
