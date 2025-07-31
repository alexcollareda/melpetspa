package br.com.melpetspa.melpetspa.service;

import br.com.melpetspa.melpetspa.dto.CreatePetRequestDTO;
import br.com.melpetspa.melpetspa.entity.PetEntity;
import br.com.melpetspa.melpetspa.repository.PetRepository;
import br.com.melpetspa.melpetspa.repository.RacaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final RacaRepository racaRepository;

    public PetResponseDTO criarPet(CreatePetRequestDTO dto) {
        PetEntity pet = new PetEntity();
        pet.setNomePet(dto.getNomePet());
        pet.setNomeTutor(dto.getNomeTutor());
        pet.setRaca(racaRepository.findById(dto.getIdRaca()).orElseThrow());
        pet.setDataHoraInclusao(LocalDateTime.now());
        return toDTO(petRepository.save(pet));
    }

    private PetResponseDTO toDTO(PetEntity entity) {
        return null;
    }
}
