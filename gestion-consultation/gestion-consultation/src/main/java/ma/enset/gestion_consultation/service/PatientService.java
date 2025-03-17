package ma.enset.gestion_consultation.service;

import ma.enset.gestion_consultation.model.Patient;
import ma.enset.gestion_consultation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }


    public Patient save(Patient patient) {
       return patientRepository.save(patient);
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }
}
