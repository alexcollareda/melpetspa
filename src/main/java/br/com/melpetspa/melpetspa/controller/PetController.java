package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.CreatePetRequestDTO;
import br.com.melpetspa.melpetspa.dto.PetResponseDTO;
import br.com.melpetspa.melpetspa.entity.RacaEntity;
import br.com.melpetspa.melpetspa.entity.enums.SpecieEnum;
import br.com.melpetspa.melpetspa.repository.PetRepository;
import br.com.melpetspa.melpetspa.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;
    private final PetRepository petRepository;

    @PostMapping
    public PetResponseDTO criarPet(@RequestBody @Valid CreatePetRequestDTO createPetRequestDTO) {
        return petService.criarPet(createPetRequestDTO);
    }
    @GetMapping("/search/name")
    public ResponseEntity<List<PetResponseDTO>> searchPetsByName(@RequestParam String nomePet) {
        List<PetResponseDTO> pets = petService.searchPetsByName(nomePet);
        return ResponseEntity.ok(pets);
    }
    @GetMapping("/search-by-specie")
    public ResponseEntity<List<PetResponseDTO>> searchPetsBySpecie(
            @RequestParam(name = "specie") String specie) {

        List<PetResponseDTO> pets = petService.searchPetsBySpecie(specie.toUpperCase());
        return ResponseEntity.ok(pets);
    }
    @GetMapping
    public List<PetResponseDTO> listarPets() {
        return List.of();
    }
}

