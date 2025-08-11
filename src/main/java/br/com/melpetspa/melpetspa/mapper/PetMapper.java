package br.com.melpetspa.melpetspa.mapper;

import br.com.melpetspa.melpetspa.dto.PetResponseDTO;
import br.com.melpetspa.melpetspa.entity.PetEntity;

public class PetMapper {

    public static PetResponseDTO toResponseDTO(PetEntity entity) {
        return new PetResponseDTO(
                entity.getIdPet(),
                entity.getNomePet(),
                entity.getNomeTutor(),
                entity.getRace().getIdRace(),
                entity.getRace().getNameRace(),
                entity.getRace().getSpecie()
        );
    }
}