package ma.enset.gestion_consultation.repository;

import ma.enset.gestion_consultation.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByPatientId(Long patientId);
}
