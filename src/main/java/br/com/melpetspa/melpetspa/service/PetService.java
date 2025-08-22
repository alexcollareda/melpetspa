package br.com.melpetspa.melpetspa.service;

import br.com.melpetspa.melpetspa.dto.CreatePetRequestDTO;
import br.com.melpetspa.melpetspa.dto.PetResponseDTO;
import br.com.melpetspa.melpetspa.dto.RacaResponseDTO;
import br.com.melpetspa.melpetspa.dto.UpdatePhotoRequest;
import br.com.melpetspa.melpetspa.entity.PetEntity;
import br.com.melpetspa.melpetspa.entity.RacaEntity;
import br.com.melpetspa.melpetspa.entity.enums.SpecieEnum;
import br.com.melpetspa.melpetspa.mapper.PetMapper;
import br.com.melpetspa.melpetspa.repository.PetRepository;
import br.com.melpetspa.melpetspa.repository.RacaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final RacaRepository racaRepository;

    public PetResponseDTO criarPet(CreatePetRequestDTO createPetRequestDTO) {
        PetEntity pet = new PetEntity();
        pet.setNomePet(createPetRequestDTO.getNomePet());
        pet.setNomeTutor(createPetRequestDTO.getNomeTutor());
        pet.setRace(racaRepository.findById(Long.valueOf(createPetRequestDTO.getIdRaca())).orElseThrow());
        pet.setSpecie(createPetRequestDTO.getSpecie());
        return toResponseDTO(petRepository.save(pet));
    }
    public List<PetResponseDTO> searchPetsByName(String nomePet) {
        return petRepository.findByNomePetContainingIgnoreCase(nomePet)
                .stream()
                .map(PetMapper::toResponseDTO)
                .toList();
    }
    public List<RacaResponseDTO> listarPorSpecie(SpecieEnum specie) {
        return racaRepository.findBySpecie(specie)
                .stream()
                .map(this::toRacaResponseDTO)
                .toList();
    }
    private RacaResponseDTO toRacaResponseDTO(RacaEntity entity) {
        return new RacaResponseDTO(
                entity.getIdRace(),
                entity.getNameRace(),
                entity.getSpecie()
        );
    }

    private PetResponseDTO toResponseDTO(PetEntity pet) {
        PetResponseDTO dto = new PetResponseDTO();
        dto.setIdPet(pet.getIdPet());
        dto.setNomePet(pet.getNomePet());
        dto.setNomeTutor(pet.getNomeTutor());
        dto.setIdRaca(pet.getRace().getIdRace());
        dto.setNomeRaca(pet.getRace().getNameRace());
        dto.setSpecie(pet.getRace().getSpecie());
        return dto;
    }

    public void atualizarFotoPet(@Valid UpdatePhotoRequest updatePhotoRequest) {
       Optional<PetEntity> pet =  petRepository.findById(updatePhotoRequest.getPetId());
       if(pet.isPresent()){
           pet.get().setPhotoUrl(updatePhotoRequest.getPhotoUrl());
           petRepository.save(pet.get());
       }
    }
}
