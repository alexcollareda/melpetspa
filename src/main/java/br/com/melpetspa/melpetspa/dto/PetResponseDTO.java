package br.com.melpetspa.melpetspa.dto;

import br.com.melpetspa.melpetspa.entity.enums.EspecieEnum;
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
    private EspecieEnum especie;
}
