package br.com.melpetspa.melpetspa.entity;

import br.com.melpetspa.melpetspa.entity.enums.EspecieEnum;
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

    private String nomeRaca;

    @Enumerated(EnumType.STRING)
    private EspecieEnum especie;
}