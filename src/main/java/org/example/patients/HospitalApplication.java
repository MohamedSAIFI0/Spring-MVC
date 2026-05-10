package org.example.patients;


import org.example.patients.entities.Consultation;
import org.example.patients.entities.Medecin;
import org.example.patients.entities.Patient;
import org.example.patients.entities.RendezVous;
import org.example.patients.services.ConsultationService;
import org.example.patients.services.MedecinService;
import org.example.patients.services.PatientService;
import org.example.patients.services.RendezVousService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(
            PatientService patientService,
            MedecinService medecinService,
            RendezVousService rendezVousService,
            ConsultationService consultationService) {

        return args -> {

            // --- Médecins ---
            Medecin m1 = medecinService.save(Medecin.builder()
                    .nom("Bennani").prenom("Youssef")
                    .specialite("Cardiologie")
                    .email("y.bennani@hopital.ma")
                    .build());

            Medecin m2 = medecinService.save(Medecin.builder()
                    .nom("Alaoui").prenom("Sara")
                    .specialite("Pédiatrie")
                    .email("s.alaoui@hopital.ma")
                    .build());

            // --- Patients ---
            Patient p1 = patientService.save(Patient.builder()
                    .nom("Idrissi").prenom("Mohamed")
                    .dateNaissance(new Date())
                    .malade(true).score(75)
                    .medecin(m1)
                    .build());

            Patient p2 = patientService.save(Patient.builder()
                    .nom("Tazi").prenom("Fatima")
                    .dateNaissance(new Date())
                    .malade(false).score(90)
                    .medecin(m2)
                    .build());

            Patient p3 = patientService.save(Patient.builder()
                    .nom("Chakir").prenom("Amine")
                    .dateNaissance(new Date())
                    .malade(true).score(60)
                    .medecin(m1)
                    .build());

            // --- Rendez-vous ---
            RendezVous rv1 = rendezVousService.save(RendezVous.builder()
                    .date(new Date()).statut("PLANIFIE")
                    .patient(p1).medecin(m1)
                    .build());

            RendezVous rv2 = rendezVousService.save(RendezVous.builder()
                    .date(new Date()).statut("CONFIRME")
                    .patient(p2).medecin(m2)
                    .build());

            RendezVous rv3 = rendezVousService.save(RendezVous.builder()
                    .date(new Date()).statut("PLANIFIE")
                    .patient(p3).medecin(m1)
                    .build());

            // --- Consultations ---
            consultationService.save(Consultation.builder()
                    .dateConsultation(new Date())
                    .rapport("Tension normale, patient stable.")
                    .prix(250.0)
                    .rendezVous(rv1)
                    .build());

            consultationService.save(Consultation.builder()
                    .dateConsultation(new Date())
                    .rapport("Croissance normale, vaccins à jour.")
                    .prix(180.0)
                    .rendezVous(rv2)
                    .build());

            //
            System.out.println(" Données initialisées avec succès !");
        };
    }
}