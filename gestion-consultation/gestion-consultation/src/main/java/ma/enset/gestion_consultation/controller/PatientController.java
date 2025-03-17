package ma.enset.gestion_consultation.controller;

import ma.enset.gestion_consultation.model.Patient;
import ma.enset.gestion_consultation.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public String findAll(Model model) {
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients); // Send patient list to Thymeleaf
        return "patient_list"; // Must match the template file name (patient_list.html)
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Patient patient) {
        patientService.save(patient);
        return "redirect:/patients"; // Redirect to updated list
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        patientService.delete(id);
        return "redirect:/patients";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Patient patient) {
        patientService.save(patient);
        return "redirect:/patients";
    }
}
