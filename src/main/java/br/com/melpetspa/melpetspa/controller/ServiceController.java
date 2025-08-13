package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.ServiceResponseDTO;
import br.com.melpetspa.melpetspa.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/servicos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ServiceController {

    private final ServiceRepository serviceRepository;

    @GetMapping
    public ResponseEntity<List<ServiceResponseDTO>> listarServicos() {
        List<ServiceResponseDTO> response = serviceRepository.findAll()
                .stream()
                .map(s -> new ServiceResponseDTO(s.getIdService(), s.getNomeService()))
                .collect(java.util.stream.Collectors.toList());
        return ResponseEntity.ok(response);
    }
}