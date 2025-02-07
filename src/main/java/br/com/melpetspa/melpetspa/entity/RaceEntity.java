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
public class RaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRace;

    private String name;

    @Enumerated(EnumType.STRING)
    private SpeciesEnum species;

    private int orderPosition;

    public RaceEntity(Long idRace){
        this.idRace = idRace;
    }
}
