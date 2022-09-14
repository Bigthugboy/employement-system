package semicolon.africa.employemanagementsystem.data.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.*;
import org.springframework.data.annotation.Id;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String firstName;

    private String lastName;
    private String password;

    private String email;

    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String salary;
    //private Qualification qualification;

    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Department department;
    @Enumerated(EnumType.STRING)
    private JobLevel jobLevel;
    private BigDecimal employeeSalary;


    private Boolean isSuspended;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SchoolQualification> schoolQualifications;
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private int age;
    private String employeeId;
    private LocalDateTime dateRegistered = LocalDateTime.now();

//    @JsonDeserialize(using = LocalDateDeserializer.class)

}
