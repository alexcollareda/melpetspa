package br.com.melpetspa.melpetspa.dto;

import br.com.melpetspa.melpetspa.entity.RacaEntity;
import br.com.melpetspa.melpetspa.entity.enums.SpecieEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetResponseDTO {
    private Long idPet;
    private String nomePet;
    private String nomeTutor;
    private LocalDateTime dataHoraInclusao;

    private Integer idRaca;
    private String nomeRaca;
    private SpecieEnum especie;
}
