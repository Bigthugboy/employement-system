package semicolon.africa.employemanagementsystem.services;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.employemanagementsystem.data.model.Certificate;
import semicolon.africa.employemanagementsystem.data.model.Gender;
import semicolon.africa.employemanagementsystem.data.model.SchoolQualification;
import semicolon.africa.employemanagementsystem.dto.request.LoginRequest;
import semicolon.africa.employemanagementsystem.dto.request.RegisterEmployeeRequest;
import semicolon.africa.employemanagementsystem.dto.request.UpdateRequest;
import semicolon.africa.employemanagementsystem.dto.response.EmployeeResponse;
import semicolon.africa.employemanagementsystem.dto.response.LoginResponse;
import semicolon.africa.employemanagementsystem.dto.response.UpdateResponse;
import semicolon.africa.employemanagementsystem.exceptions.DuplicateEmailException;
import semicolon.africa.employemanagementsystem.exceptions.InvalidDetailsException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceImplTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testThatEmployeeCanRegister() throws DuplicateEmailException {
        try{
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
                    .password("damilola")
                    .schoolQualification(schoolQualifications)
                    .gender(Gender.MALE)
                    .build();
            EmployeeResponse response = employeeService.registerEmployee(registerEmployeeRequest);
            assertEquals("thug@yahoo.com", response.getEmail());
        } catch (DuplicateEmailException e) {
            System.out.println(e.getMessage());
        }
    }



    @Test
    public void testThatEmployeeCanLogin() throws InvalidDetailsException {
        new LoginRequest();
        LoginRequest request = LoginRequest.builder()
                .email("thug@yahoo.com")
                .password("damilola")
                .build();
        LoginResponse response = employeeService.loginEmployee(request);
        assertEquals("Logged in successfully",response.getMessage());
    }
    @Test
    @Disabled
    public void testThatEmployeeCantLoginWithWrongDetails() throws InvalidDetailsException {
        try{
            new LoginRequest();
            LoginRequest request = LoginRequest.builder()
                    .email("thug@gmail.com")
                    .password("damilola")
                    .build();
            LoginResponse response = employeeService.loginEmployee(request);
            assertEquals("Invalid login details",response.getMessage());
        } catch (InvalidDetailsException e) {
           assertEquals("Invalid login details",e.getMessage());
        }

    }
    @Test
    public void testThatEmployeeCanBeUpdated(){
        SchoolQualification schoolQualification = new SchoolQualification(Certificate.MSC);
        List<SchoolQualification> schoolQualifications = new ArrayList<>();
        schoolQualifications.add(new SchoolQualification(Certificate.MSC));
        new UpdateRequest();
        UpdateRequest request = UpdateRequest.builder()
                .address("no 4 olorunshogo street")
                .age(25)
                .email("thug@yahoo.com")
                .firstName("tolani")
                .lastName("akinsola")
                .PhoneNumber("08012345689")
                .password("damilola")
                .schoolQualification(schoolQualifications)
                .gender(Gender.MALE)
                .build();
        UpdateResponse response = employeeService.updateEmployee(request);
        assertEquals("updated successfully", response.getMessage());

    }

}