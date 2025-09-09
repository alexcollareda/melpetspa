package br.com.melpetspa.melpetspa.dto;

import br.com.melpetspa.melpetspa.entity.enums.SpecieEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePetRequestDTO {
    private Long idPet;
    private String nomePet;
    private String nomeTutor;
    private Integer idRaca;
    @Enumerated(EnumType.STRING)
    private SpecieEnum specie;
    private String photoUrl;
    private LocalDate birthDate;
}