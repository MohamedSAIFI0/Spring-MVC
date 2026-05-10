package org.example.patients.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "La date est obligatoire")
    private Date date;

    // Statut : PLANIFIE, CONFIRME, ANNULE
    @NotBlank(message = "Le statut est obligatoire")
    private String statut;

    // Relation côté propriétaire → clé étrangère patient_id
    @ManyToOne
    @JoinColumn(name = "patient_id")
    @NotNull(message = "Le patient est obligatoire")
    private Patient patient;

    // Relation côté propriétaire → clé étrangère medecin_id
    @ManyToOne
    @JoinColumn(name = "medecin_id")
    @NotNull(message = "Le médecin est obligatoire")
    private Medecin medecin;

    // Relation : un rendez-vous génère une consultation
    @OneToOne(mappedBy = "rendezVous", cascade = CascadeType.ALL)
    private Consultation consultation;
}