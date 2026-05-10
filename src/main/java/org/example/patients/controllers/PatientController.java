package org.example.patients.controllers;





import lombok.AllArgsConstructor;
import org.example.patients.services.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patients")
    public String list(Model model) {
        model.addAttribute("patients", patientService.findAll(0, 10).getContent());
        return "patients/list";
    }
}
