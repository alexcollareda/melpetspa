package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.CreateCheckInRequestDTO;
import br.com.melpetspa.melpetspa.dto.EndJobRequestDTO;
import br.com.melpetspa.melpetspa.dto.StartJobRequestDTO;
import br.com.melpetspa.melpetspa.service.CheckInService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkins")
@RequiredArgsConstructor
public class CheckInController {
    private final CheckInService service;

    @PostMapping
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

    @GetMapping("/hoje")
    public List<CheckInResponseDTO> listarHoje() {
        return service.listarCheckinsHoje();
    }

    @GetMapping("/buscar")
    public List<CheckInResponseDTO> buscar(@RequestParam String data) {
        return service.buscarPorData(data);
    }
}

