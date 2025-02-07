package br.com.melpetspa.melpetspa.service;

import br.com.melpetspa.melpetspa.dto.BrandVaccineDTO;
import br.com.melpetspa.melpetspa.dto.RaceDTO;
import br.com.melpetspa.melpetspa.entity.BrandVaccineEntity;
import br.com.melpetspa.melpetspa.entity.RaceEntity;
import br.com.melpetspa.melpetspa.entity.enums.SpeciesEnum;
import br.com.melpetspa.melpetspa.repository.BrandVaccineRepository;
import br.com.melpetspa.melpetspa.repository.RaceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandVaccineService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BrandVaccineRepository brandVaccineRepository;

    public List<BrandVaccineDTO> getBrandVaccinesAll() {
        List<BrandVaccineEntity> brandVaccine =brandVaccineRepository.findAll();
        return convertToDTOList(brandVaccine);
    }

    private List<BrandVaccineDTO> convertToDTOList(List<BrandVaccineEntity> brandVaccineEntities) {
        return brandVaccineEntities.stream()
                .map(race -> modelMapper.map(race, BrandVaccineDTO.class))
                .collect(Collectors.toList());
    }
}
