package br.com.melpetspa.melpetspa.service;

import br.com.melpetspa.melpetspa.dto.PetCreateDTO;
import br.com.melpetspa.melpetspa.dto.PetDTO;
import br.com.melpetspa.melpetspa.entity.ClientEntity;
import br.com.melpetspa.melpetspa.entity.PetEntity;
import br.com.melpetspa.melpetspa.entity.RaceEntity;
import br.com.melpetspa.melpetspa.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<PetDTO> getPetByClient(Long idClient) {
        List<PetEntity> petEntityList = petRepository.findByIdClient(idClient);
        return convertToDtoList(petEntityList);
    }

    private List<PetDTO> convertToDtoList(List<PetEntity> petEntityList){
        return Collections.singletonList(new PetDTO());
    }

    public void createPet(PetCreateDTO petDTO) {
        PetEntity petEntity = new PetEntity();
        petEntity.setClient(new ClientEntity(petDTO.getIdCliente()));
        petEntity.setRace(new RaceEntity(petDTO.getIdRace()));

        petEntity.setName(petDTO.getName());
        petEntity.setChipCode(petDTO.getChipCode());
        petEntity.setPhoto(petDTO.getPhoto());
        petEntity.setBornDate(petDTO.getBornDate());
        petEntity.setGenderEnum(petDTO.getGenderEnum());
        petEntity.setSpeciesEnum(petDTO.getSpeciesEnum());

        petRepository.save(petEntity);
    }
}