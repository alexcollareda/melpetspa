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
    @Column(name = "id_raca")
    private Integer idRace;
    @JoinColumn(name = "name_race")
    private String nameRace;
    @Enumerated(EnumType.STRING)
    private SpecieEnum specie;
}