package semicolon.africa.employemanagementsystem.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import semicolon.africa.employemanagementsystem.data.model.Employee;
import semicolon.africa.employemanagementsystem.data.repository.EmployeRepository;
import semicolon.africa.employemanagementsystem.dto.request.DeleteRequest;
import semicolon.africa.employemanagementsystem.dto.request.EmployeeRequest;
import semicolon.africa.employemanagementsystem.dto.request.LoginRequest;
import semicolon.africa.employemanagementsystem.dto.request.RegisterEmployeeRequest;
import semicolon.africa.employemanagementsystem.dto.response.DeleteResponse;
import semicolon.africa.employemanagementsystem.dto.response.EmployeeResponse;
import semicolon.africa.employemanagementsystem.dto.response.LoginResponse;
import semicolon.africa.employemanagementsystem.exceptions.DuplicateEmailException;
import semicolon.africa.employemanagementsystem.exceptions.InvalidDetailsException;

import java.time.format.DateTimeFormatter;


@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeRepository employeRepository;

    @Override
    public EmployeeResponse registerEmployee(RegisterEmployeeRequest request) throws DuplicateEmailException {
        if (FindByMail(request.getEmail())) {
            throw new DuplicateEmailException(request.getEmail() + " already exists");
        }
        Employee employee = new Employee();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(request,Employee.class);
        Employee savedEmployee = employeRepository.save(employee);
        EmployeeResponse response = new EmployeeResponse();
        response.setEmail(savedEmployee.getEmail());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyy, hh:mm, a").format(savedEmployee.getDateRegistered()));
        return response;

    }

    private Boolean FindByMail(String existByMail) {
        Employee employee = employeRepository.existsByEmail(existByMail);
        return employee != null;
    }

    @Override
    public DeleteResponse deleteEmployee(DeleteRequest request) {
        Employee employee = employeRepository.existsByEmail(request.getEmployeeId());
        employeRepository.delete(employee);
        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setMessage("Employee deleted");
        deleteResponse.setEmail(request.getEmail());
        return deleteResponse;
    }

    @Override
    public EmployeeResponse updateEmployee(RegisterEmployeeRequest request) {
        Employee employee = employeRepository.existsByEmail(request.getEmail());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(request,Employee.class);
        employeRepository.save(employee);
        EmployeeResponse response = new EmployeeResponse();
        response.setEmail(request.getEmail());
        response.setMessage("employee successfully updated");
        return response;
    }

    @Override
    public Employee findById(EmployeeRequest request) {
        Employee employee = employeRepository.findByEmployeeId(request.getEmployeeId());
        if (employee.getEmployeeId().equals(request.getEmployeeId())) {
            return employee;
        }
        return null;
    }

    @Override
    public LoginResponse loginEmployee(LoginRequest loginRequest) throws InvalidDetailsException {
        Employee employee = employeRepository.existsByEmail(loginRequest.getEmail());
        LoginResponse response = new LoginResponse();
        if (employee.getPassword().equals(loginRequest.getPassword())) {
            response.setMessage("Logged in successfully");
            return response;
        }
        throw new InvalidDetailsException("Invalid login details");

    }


}
