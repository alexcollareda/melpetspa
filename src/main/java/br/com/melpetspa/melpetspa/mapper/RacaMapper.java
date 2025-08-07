package br.com.melpetspa.melpetspa.mapper;

import br.com.melpetspa.melpetspa.dto.RacaResponseDTO;
import br.com.melpetspa.melpetspa.entity.RacaEntity;

public class RacaMapper {

    public static RacaResponseDTO toResponseDTO(RacaEntity raca) {
        return new RacaResponseDTO(
                raca.getIdRaca(),           // idRace
                raca.getNameRace(),     // nameRace
                raca.getEspecie()        // especie (do tipo SpecieEnum)
        );
    }
}
