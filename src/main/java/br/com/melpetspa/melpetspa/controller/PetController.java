package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.PetCreateDTO;
import br.com.melpetspa.melpetspa.dto.PetDTO;
import br.com.melpetspa.melpetspa.service.PetService;
import br.com.melpetspa.melpetspa.service.UserService;
import br.com.melpetspa.melpetspa.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService, JwtUtil jwtUtil) {
        this.petService = petService;
    }

    @GetMapping("/list/{idClient}")
    public List<PetDTO> getPetByClient(@PathVariable("idClient") Long idClient){
        return petService.getPetByClient(idClient);
    }

    @PostMapping
    public void createPet(@RequestBody PetCreateDTO petDTO){
        petService.createPet(petDTO);
    }
}