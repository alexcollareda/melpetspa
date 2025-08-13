package br.com.melpetspa.melpetspa.dto;

import br.com.melpetspa.melpetspa.entity.enums.SpecieEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePetRequestDTO {
    private String nomePet;
    private String nomeTutor;
    private Integer idRaca;
    @Enumerated(EnumType.STRING)
    private SpecieEnum specie;
}