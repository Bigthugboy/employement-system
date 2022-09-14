package semicolon.africa.employemanagementsystem.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import semicolon.africa.employemanagementsystem.data.model.Employee;

@Repository
public interface EmployeRepository extends JpaRepository<Employee, Long> {
    Employee existsByEmail(String email);

    Employee findByEmployeeId(String employeeId);


}
