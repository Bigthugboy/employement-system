package semicolon.africa.employemanagementsystem.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.employemanagementsystem.data.model.Certificate;
import semicolon.africa.employemanagementsystem.data.model.Gender;
import semicolon.africa.employemanagementsystem.data.model.SchoolQualification;
import semicolon.africa.employemanagementsystem.dto.request.RegisterEmployeeRequest;
import semicolon.africa.employemanagementsystem.dto.response.EmployeeResponse;
import semicolon.africa.employemanagementsystem.exceptions.DuplicateEmailException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceImplTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testThatEmployeeCanRegister() throws DuplicateEmailException {

        SchoolQualification schoolQualification = new SchoolQualification(Certificate.BSC);
        List<SchoolQualification> schoolQualifications = new ArrayList<>();
        schoolQualifications.add(new SchoolQualification(Certificate.BSC));
        RegisterEmployeeRequest registerEmployeeRequest = RegisterEmployeeRequest.builder()
                .address("gygduhjdf")
                .age(23)
                .email("thug@yahoo.com")
                .firstName("tolani")
                .lastName("akinsola")
                .PhoneNumber("38238993772")
                .schoolQualification(schoolQualifications)
                .gender(Gender.MALE)

                .build();
        EmployeeResponse response = employeeService.registerEmployee(registerEmployeeRequest);
        assertEquals("thug@yahoo.com", response.getEmail());
    }

}