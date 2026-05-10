package org.example.patients.repositories;


import org.example.patients.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    Consultation findByRendezVousId(Long rendezVousId);
}