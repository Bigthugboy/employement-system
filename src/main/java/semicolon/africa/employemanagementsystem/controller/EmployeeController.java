package semicolon.africa.employemanagementsystem.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import semicolon.africa.employemanagementsystem.dto.request.*;
import semicolon.africa.employemanagementsystem.dto.response.ApiResponse;

import semicolon.africa.employemanagementsystem.dto.response.UpdateResponse;
import semicolon.africa.employemanagementsystem.exceptions.DuplicateEmailException;
import semicolon.africa.employemanagementsystem.exceptions.InvalidDetailsException;
import semicolon.africa.employemanagementsystem.services.EmployeeServiceImpl;

@RestController
@AllArgsConstructor

@RequestMapping("api/v1/employee")
public class EmployeeController {
    private EmployeeServiceImpl service;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegisterEmployeeRequest request) {
        try {
            service.registerEmployee(request);
            ApiResponse response = ApiResponse.builder()
                    .isSuccessfully(true)
                    .data("successfully register! Welcome")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DuplicateEmailException ex) {
            ApiResponse response = ApiResponse.builder()
                    .isSuccessfully(false)
                    .data("email already exist")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            service.loginEmployee(request);
            ApiResponse response = ApiResponse.builder()
                    .isSuccessfully(true)
                    .data("login successfully! Welcome")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (InvalidDetailsException ex) {
            ApiResponse response = ApiResponse.builder()
                    .isSuccessfully(false)
                    .data("email already exist")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/update")
    public UpdateResponse update(@RequestBody UpdateRequest request) {
        service.updateEmployee(request);
        return new UpdateResponse();
    }

    @GetMapping("/find")
    public ResponseEntity<?> find(@RequestBody EmployeeRequest request) {
        service.findById(request);
        ApiResponse response = ApiResponse.builder()
                .isSuccessfully(true)
                .data("search complete")
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteRequest request) {
        service.deleteEmployee(request);
        ApiResponse response = ApiResponse.builder()
                .isSuccessfully(true)
                .data("successfully register! Welcome")
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
