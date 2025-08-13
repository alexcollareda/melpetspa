package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.*;
import br.com.melpetspa.melpetspa.service.CheckInService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/checkins")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
public class CheckInController {

    private final CheckInService service;

    @PostMapping("/create")
    public CheckInResponseDTO create(@RequestBody @Valid CreateCheckInRequestDTO dto) {
        return service.criarCheckIn(dto);
    }

    @PostMapping("/start")
    public CheckInResponseDTO start(@RequestBody StartJobRequestDTO dto) {
        return service.iniciarTrabalho(dto);
    }

    @PostMapping("/end")
    public CheckInResponseDTO end(@RequestBody EndJobRequestDTO dto) {
        return service.finalizarTrabalho(dto);
    }

    @GetMapping("/hoje")
    public List<CheckInResponseDTO> listToday() {
        return service.listarCheckinsHoje();
    }

    @GetMapping("/buscar")
    public List<CheckInResponseDTO> buscarPorData(@RequestParam String data) {
        return service.buscarPorData(data);
    }
}
