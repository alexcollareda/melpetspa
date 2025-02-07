package br.com.melpetspa.melpetspa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PetVaccinesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPetVaccines;

    @ManyToOne
    private VaccinesEntity vaccines;

    private LocalDate applicationDate;

    @ManyToOne
    private CompanyEntity company;

    @ManyToOne
    private UserEntity responsible;
}
