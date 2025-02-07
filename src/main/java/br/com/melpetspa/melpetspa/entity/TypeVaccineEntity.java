package br.com.melpetspa.melpetspa.entity;

import br.com.melpetspa.melpetspa.entity.enums.SpeciesEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TypeVaccineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeVaccine;

    @Enumerated(EnumType.STRING)
    private SpeciesEnum speciesEnum;

    private String name;
}
