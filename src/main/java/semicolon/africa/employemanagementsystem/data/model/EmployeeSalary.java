package semicolon.africa.employemanagementsystem.data.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class EmployeeSalary {
    public static BigDecimal INTERNSHIP_EMPLOYEE_SALARY = BigDecimal.valueOf(8000);
    public static BigDecimal ENTRY_EMPLOYEE_SALARY = BigDecimal.valueOf(150000);
    public static BigDecimal MIDDLE_EMPLOYEE_SALARY = BigDecimal.valueOf(400000);
    public static final BigDecimal SENIOR_EMPLOYEE_SALARY = BigDecimal.valueOf(800000);

}
