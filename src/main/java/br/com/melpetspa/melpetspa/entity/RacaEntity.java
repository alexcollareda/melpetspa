package br.com.melpetspa.melpetspa.entity;

import br.com.melpetspa.melpetspa.entity.enums.SpecieEnum;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RacaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRaca;
    @JoinColumn(name = "name_race")
    private String nameRace;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SpecieEnum especie;
}