package org.example.patients.services;




import lombok.AllArgsConstructor;
import org.example.patients.entities.Consultation;
import org.example.patients.repositories.ConsultationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ConsultationService {

    private final ConsultationRepository consultationRepository;

    public Consultation save(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }

    public Consultation findById(Long id) {
        return consultationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consultation introuvable : " + id));
    }

    public Consultation findByRendezVous(Long rendezVousId) {
        return consultationRepository.findByRendezVousId(rendezVousId);
    }

    public void deleteById(Long id) {
        consultationRepository.deleteById(id);
    }
}