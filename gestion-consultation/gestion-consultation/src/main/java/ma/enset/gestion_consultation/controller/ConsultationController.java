package ma.enset.gestion_consultation.controller;

import ma.enset.gestion_consultation.model.Consultation;
import ma.enset.gestion_consultation.model.Patient;
import ma.enset.gestion_consultation.service.ConsultationService;
import ma.enset.gestion_consultation.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/consultations")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private PatientService patientService;


    @GetMapping("/{patientId}")
    public String getConsultations(@PathVariable Long patientId, Model model) {
        Patient patient = patientService.findById(patientId);
        List<Consultation> consultations = consultationService.findByPatientId(patientId);

        model.addAttribute("patient", patient);
        model.addAttribute("consultations", consultations);

        return "consultation_list"; // This will render consultation_list.html
    }

    @PostMapping("/add")
    public String addConsultation(@RequestParam Long patientId, @RequestParam String medicine) {
        Patient patient = patientService.findById(patientId);
        Consultation consultation = new Consultation();
        consultation.setPatient(patient);
        consultation.setMedicine(medicine);

        consultationService.save(consultation);

        return "redirect:/consultations/" + patientId; // Redirect back to the consultation list
    }

    @GetMapping("/delete/{id}")
    public String deleteConsultation(@PathVariable Long id, @RequestParam Long patientId) {
        consultationService.deleteById(id);
        return "redirect:/consultations/" + patientId; // Redirect back to the consultation list
    }
}
