package org.example.patients.services;


import lombok.AllArgsConstructor;
import org.example.patients.entities.Medecin;
import org.example.patients.repositories.MedecinRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class MedecinService {

    private final MedecinRepository medecinRepository;

    public Medecin save(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    public List<Medecin> findAll() {
        return medecinRepository.findAll();
    }

    public Medecin findById(Long id) {
        return medecinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médecin introuvable : " + id));
    }

    public void deleteById(Long id) {
        medecinRepository.deleteById(id);
    }
}