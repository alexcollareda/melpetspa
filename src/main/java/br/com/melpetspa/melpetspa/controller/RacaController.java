package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.RacaResponseDTO;
import br.com.melpetspa.melpetspa.repository.RacaRepository;
import br.com.melpetspa.melpetspa.repository.ServiceRepository;
import br.com.melpetspa.melpetspa.service.RacaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
@RequiredArgsConstructor
public class RacaController {
    private final RacaRepository racaRepository;
    private final RacaService racaService;

    @GetMapping("/racas")
    public ResponseEntity<List<RacaResponseDTO>> getRacasBySpecie(@RequestParam String specie) {
        List<RacaResponseDTO> racas = racaService.findByEspecie(specie.toUpperCase());
        return ResponseEntity.ok(racas);
    }
}
