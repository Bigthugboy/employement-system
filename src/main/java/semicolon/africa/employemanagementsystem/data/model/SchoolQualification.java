package semicolon.africa.employemanagementsystem.data.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
//@RequiredArgsConstructor
public class SchoolQualification {
    @Id

    @GeneratedValue
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Certificate certificate;

    public SchoolQualification(Certificate certificate) {
        this.certificate = certificate;
    }

    public SchoolQualification() {

    }

    public Long getId() {
        return id;
    }


}
