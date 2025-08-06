package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.ServiceResponseDTO;
import br.com.melpetspa.melpetspa.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/servicos")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceRepository servicoRepository;

    @GetMapping
    public ResponseEntity<List<ServiceResponseDTO>> listarServicos() {
        List<ServiceResponseDTO> response = servicoRepository.findAll()
                .stream()
                .map(s -> new ServiceResponseDTO(s.getIdService(), s.getNomeService()))
                .collect(toList());
        return ResponseEntity.ok(response);
    }
}