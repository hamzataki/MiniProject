package ma.enset.gestion_consultation.service;

import ma.enset.gestion_consultation.model.Consultation;
import ma.enset.gestion_consultation.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    public Consultation save(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public List<Consultation> findByPatientId(Long patientId) {
        return consultationRepository.findByPatientId(patientId);
    }

    public void deleteById(Long id) {
        consultationRepository.deleteById(id);
    }
}
