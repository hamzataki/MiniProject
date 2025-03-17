package ma.enset.gestion_consultation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "consultations")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicine;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
