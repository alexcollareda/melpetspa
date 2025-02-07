package br.com.melpetspa.melpetspa.dto;

import br.com.melpetspa.melpetspa.entity.ClientEntity;
import br.com.melpetspa.melpetspa.entity.RaceEntity;
import br.com.melpetspa.melpetspa.entity.enums.GenderEnum;
import br.com.melpetspa.melpetspa.entity.enums.SpeciesEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

public class PetDTO {
    private Long idPet;
    private String name;
    private String chipCode;
    private String race;
    private String speciesEnum;
    private String gender;
    private LocalDate bornDate;
    private Long idClient;
}
