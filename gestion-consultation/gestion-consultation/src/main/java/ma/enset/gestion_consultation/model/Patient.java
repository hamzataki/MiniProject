package ma.enset.gestion_consultation.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Consultation> consultations = new ArrayList<>();

}
