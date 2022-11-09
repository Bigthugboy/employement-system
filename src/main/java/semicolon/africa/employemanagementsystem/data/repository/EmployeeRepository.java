package semicolon.africa.employemanagementsystem.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import semicolon.africa.employemanagementsystem.data.model.Employee;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   Optional <Employee> findByEmail(String email);

    Optional<Employee> findById(Long id);



}
