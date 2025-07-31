package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.CreatePetRequestDTO;
import br.com.melpetspa.melpetspa.dto.PetResponseDTO;
import br.com.melpetspa.melpetspa.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @PostMapping
    public PetResponseDTO criarPet(@RequestBody @Valid CreatePetRequestDTO createPetRequestDTO) {
        return petService.criarPet(createPetRequestDTO);
    }

    @GetMapping
    public List<PetResponseDTO> listarPets() {
        return List.of();
    }
}
