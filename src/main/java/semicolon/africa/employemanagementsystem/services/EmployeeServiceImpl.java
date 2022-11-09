package semicolon.africa.employemanagementsystem.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import semicolon.africa.employemanagementsystem.data.model.Employee;
import semicolon.africa.employemanagementsystem.data.repository.EmployeeRepository;
import semicolon.africa.employemanagementsystem.dto.request.*;
import semicolon.africa.employemanagementsystem.dto.response.DeleteResponse;
import semicolon.africa.employemanagementsystem.dto.response.EmployeeResponse;
import semicolon.africa.employemanagementsystem.dto.response.LoginResponse;
import semicolon.africa.employemanagementsystem.dto.response.UpdateResponse;
import semicolon.africa.employemanagementsystem.exceptions.DuplicateEmailException;
import semicolon.africa.employemanagementsystem.exceptions.InvalidDetailsException;

import java.time.format.DateTimeFormatter;
import java.util.Optional;


@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse registerEmployee(RegisterEmployeeRequest request) throws DuplicateEmailException {
        if (FindByMail(request.getEmail())) {
            throw new DuplicateEmailException(request.getEmail() + " already exists");
        }
        Employee employee = new Employee();
        ModelMapper modelMapper = new ModelMapper();
        employee = modelMapper.map(request,Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeResponse response = new EmployeeResponse();
        response.setEmail(savedEmployee.getEmail());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyy, hh:mm, a").format(savedEmployee.getDateRegistered()));
        return response;

    }

    private boolean FindByMail(String existByMail) {
        Optional<Employee> employee = employeeRepository.findByEmail(existByMail);
        return employee.isPresent();
    }

    @Override
    public DeleteResponse deleteEmployee(DeleteRequest request) {
        Optional<Employee> employee = employeeRepository.findByEmail(request.getEmployeeId());
        if (employee.isEmpty()){
            throw new IllegalStateException("Cant Find Employee");
        }
        employeeRepository.delete(employee.get());
        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setMessage("Employee deleted");
        deleteResponse.setEmail(request.getEmail());
        return deleteResponse;
    }

    @Override
    public UpdateResponse updateEmployee(UpdateRequest request) {
        Optional<Employee> employee = employeeRepository.findByEmail(request.getEmail());
        if (employee.isEmpty()) {
            throw new IllegalStateException("user not found");
        }
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(request,Employee.class);

        employeeRepository.save(employee.get());
        UpdateResponse response = new UpdateResponse();


        response.setPassword(request.getPassword());

        response.setFirstName(request.getFirstName());
        response.setLastName(request.getLastName());
        response.setPhoneNumber(request.getPhoneNumber());
        response.setMessage("updated successfully");
        return response;
    }

    @Override
    public Employee findById(EmployeeRequest request) {
        Optional<Employee> employee = employeeRepository.findById(request.getId());
        if (employee.get().getId().equals(request.getId())) {
            return employee.get();
        }
        throw new IllegalStateException("cant find employee");
    }

    @Override
    public LoginResponse loginEmployee(LoginRequest loginRequest) throws InvalidDetailsException {
        Optional<Employee> employee = employeeRepository.findByEmail(loginRequest.getEmail());
        if (employee.isPresent()){
            if (employee.get().getPassword().equals(loginRequest.getPassword())) {
                LoginResponse response = new LoginResponse();
                response.setMessage("Logged in successfully");
                return response;
        }
            throw new InvalidDetailsException("Invalid login details");
        }

    throw new InvalidDetailsException("cant find Employee");
    }

    @Override
    public Employee findByMail(EmployeeRequest request) {
        return null;
    }


}
