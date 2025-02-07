package br.com.melpetspa.melpetspa.service;

import br.com.melpetspa.melpetspa.dto.RaceDTO;
import br.com.melpetspa.melpetspa.entity.RaceEntity;
import br.com.melpetspa.melpetspa.entity.enums.SpeciesEnum;
import br.com.melpetspa.melpetspa.repository.RaceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RaceService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RaceRepository raceRepository;

    public List<RaceDTO> getRaceBySpecies(SpeciesEnum speciesEnum) {
        List<RaceEntity> races =raceRepository.findBySpecies(speciesEnum);
        return convertToDTOList(races);
    }

    private List<RaceDTO> convertToDTOList(List<RaceEntity> raceEntities) {
        return raceEntities.stream()
                .map(race -> modelMapper.map(race, RaceDTO.class)) // Convertendo cada elemento
                .collect(Collectors.toList());
    }
}
