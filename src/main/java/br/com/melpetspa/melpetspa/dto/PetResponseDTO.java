package br.com.melpetspa.melpetspa.dto;

import br.com.melpetspa.melpetspa.entity.enums.SpecieEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private Integer idRaca;
    private String nomeRaca;
    @Enumerated(EnumType.STRING)
    private SpecieEnum specie;
}
