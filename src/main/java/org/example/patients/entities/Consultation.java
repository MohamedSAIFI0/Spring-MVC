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
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "La date de consultation est obligatoire")
    private Date dateConsultation;

    @NotBlank(message = "Le rapport est obligatoire")
    @Column(columnDefinition = "TEXT")
    private String rapport;

    @Positive(message = "Le prix doit être positif")
    private double prix;

    // Relation côté propriétaire → clé étrangère rendez_vous_id
    @OneToOne
    @JoinColumn(name = "rendez_vous_id")
    @NotNull(message = "Le rendez-vous est obligatoire")
    private RendezVous rendezVous;
}