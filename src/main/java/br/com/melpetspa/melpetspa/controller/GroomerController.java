package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.GroomerResponseDTO;
import br.com.melpetspa.melpetspa.repository.GroomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/groomers")
@RequiredArgsConstructor
public class GroomerController {

    private final GroomerRepository groomerRepository;

    @GetMapping
    public ResponseEntity<List<GroomerResponseDTO>> listarGroomers() {
        List<GroomerResponseDTO> response = groomerRepository.findAll()
                .stream()
                .map(g -> new GroomerResponseDTO(g.getIdGroomer(), g.getNomeGroomer()))
                .collect(toList());
        return ResponseEntity.ok(response);
    }
}