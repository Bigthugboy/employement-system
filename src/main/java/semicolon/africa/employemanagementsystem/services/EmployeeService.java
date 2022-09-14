package semicolon.africa.employemanagementsystem.services;

import semicolon.africa.employemanagementsystem.data.model.Employee;
import semicolon.africa.employemanagementsystem.dto.request.DeleteRequest;
import semicolon.africa.employemanagementsystem.dto.request.EmployeeRequest;
import semicolon.africa.employemanagementsystem.dto.request.LoginRequest;
import semicolon.africa.employemanagementsystem.dto.request.RegisterEmployeeRequest;
import semicolon.africa.employemanagementsystem.dto.response.DeleteResponse;
import semicolon.africa.employemanagementsystem.dto.response.EmployeeResponse;
import semicolon.africa.employemanagementsystem.dto.response.LoginResponse;
import semicolon.africa.employemanagementsystem.exceptions.DuplicateEmailException;
import semicolon.africa.employemanagementsystem.exceptions.InvalidDetailsException;

public interface EmployeeService {
    EmployeeResponse registerEmployee(RegisterEmployeeRequest registerEmployeeRequest) throws DuplicateEmailException;

    DeleteResponse deleteEmployee(DeleteRequest request);

    EmployeeResponse updateEmployee(RegisterEmployeeRequest registerRequest);

    Employee findById(EmployeeRequest request);

    LoginResponse loginEmployee(LoginRequest loginRequest) throws InvalidDetailsException;


}
