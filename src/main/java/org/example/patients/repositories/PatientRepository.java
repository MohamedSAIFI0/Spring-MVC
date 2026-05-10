package org.example.patients.repositories;


import org.example.patients.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByNomContainingIgnoreCase(String nom, Pageable pageable);
}