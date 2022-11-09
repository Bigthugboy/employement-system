package semicolon.africa.employemanagementsystem.data.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.*;


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
    @Id
    @Column( nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;

    private String lastName;
    private String password;

    private String email;

    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    //private Qualification qualification;

    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Department department;
    @Enumerated(EnumType.STRING)
    private JobLevel jobLevel;



    private Boolean isSuspended = false;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SchoolQualification> schoolQualifications;

    private int age;

    private LocalDateTime dateRegistered = LocalDateTime.now();

//    @JsonDeserialize(using = LocalDateDeserializer.class)

}
