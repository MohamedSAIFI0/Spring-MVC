package org.example.patients.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    @Size(min = 2, max = 50, message = "Le nom doit contenir entre 2 et 50 caractères")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "La date de naissance est obligatoire")
    private Date dateNaissance;

    private boolean malade;

    @Min(value = 0, message = "Le score ne peut pas être négatif")
    @Max(value = 100, message = "Le score ne peut pas dépasser 100")
    private int score;

    // Relation : un patient est suivi par un médecin
    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    // Relation : un patient a plusieurs rendez-vous
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<RendezVous> rendezVous;
}