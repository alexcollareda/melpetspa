package br.com.melpetspa.melpetspa.dto;

import br.com.melpetspa.melpetspa.entity.enums.GenderEnum;
import br.com.melpetspa.melpetspa.entity.enums.SpeciesEnum;
import lombok.*;

import java.time.LocalDate;

@Data
public class PetCreateDTO {
    private String name;
    private String chipCode;
    private Long idRace;
    private String photo;
    private SpeciesEnum speciesEnum;
    private GenderEnum genderEnum;
    private LocalDate bornDate;
    private Long idCliente;
}