package semicolon.africa.employemanagementsystem.services;

import semicolon.africa.employemanagementsystem.data.model.Employee;
import semicolon.africa.employemanagementsystem.dto.request.*;
import semicolon.africa.employemanagementsystem.dto.response.DeleteResponse;
import semicolon.africa.employemanagementsystem.dto.response.EmployeeResponse;
import semicolon.africa.employemanagementsystem.dto.response.LoginResponse;
import semicolon.africa.employemanagementsystem.dto.response.UpdateResponse;
import semicolon.africa.employemanagementsystem.exceptions.DuplicateEmailException;
import semicolon.africa.employemanagementsystem.exceptions.InvalidDetailsException;

public interface EmployeeService {
    EmployeeResponse registerEmployee(RegisterEmployeeRequest registerEmployeeRequest) throws DuplicateEmailException;
   DeleteResponse deleteEmployee(DeleteRequest request);

    UpdateResponse updateEmployee(UpdateRequest reequest);

    Employee findById(EmployeeRequest request);

    LoginResponse loginEmployee(LoginRequest loginRequest) throws InvalidDetailsException;
    Employee findByMail(EmployeeRequest request);


}
