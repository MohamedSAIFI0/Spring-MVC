package org.example.patients.services;


import lombok.AllArgsConstructor;
import org.example.patients.entities.Patient;
import org.example.patients.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Page<Patient> findAll(int page, int size) {
        return patientRepository.findAll(PageRequest.of(page, size));
    }

    public Page<Patient> search(String nom, int page, int size) {
        return patientRepository.findByNomContainingIgnoreCase(nom, PageRequest.of(page, size));
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient introuvable : " + id));
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}