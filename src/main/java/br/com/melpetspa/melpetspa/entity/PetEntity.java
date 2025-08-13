package br.com.melpetspa.melpetspa.entity;

import br.com.melpetspa.melpetspa.entity.enums.SpecieEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPet;

    private String nomePet;
    private String nomeTutor;

    @ManyToOne
    @JoinColumn(name = "id_raca")
    private RacaEntity race;

    @Enumerated(EnumType.STRING)
    @Column(name = "specie", nullable = false)
    private SpecieEnum specie;

}
