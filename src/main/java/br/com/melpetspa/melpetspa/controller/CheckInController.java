package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.*;
import br.com.melpetspa.melpetspa.service.CheckInService;
import br.com.melpetspa.melpetspa.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkins")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
public class CheckInController {
    private final CheckInService service;

    @PostMapping("/create")
    public CheckInResponseDTO create(@RequestBody @Valid CreateCheckInRequestDTO createCheckInRequestDTO) {
        return service.criarCheckIn(createCheckInRequestDTO);
    }

    @PostMapping("/start")
    public CheckInResponseDTO start(@RequestBody StartJobRequestDTO startJobRequestDTO) {
        return service.iniciarTrabalho(startJobRequestDTO);
    }

    @PostMapping("/end")
    public CheckInResponseDTO end(@RequestBody EndJobRequestDTO endJobRequestDTO) {
        return service.finalizarTrabalho(endJobRequestDTO);
    }
}

