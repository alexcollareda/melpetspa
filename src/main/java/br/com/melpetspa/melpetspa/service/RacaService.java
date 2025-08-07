package br.com.melpetspa.melpetspa.service;

import br.com.melpetspa.melpetspa.dto.RacaResponseDTO;
import br.com.melpetspa.melpetspa.entity.RacaEntity;
import br.com.melpetspa.melpetspa.mapper.RacaMapper;
import br.com.melpetspa.melpetspa.repository.RacaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RacaService {
    private final RacaRepository racaRepository;

    public List<RacaResponseDTO> findByEspecie(String especie) {
        return racaRepository.findByEspecie(especie)
                .stream()
                .map(RacaMapper::toResponseDTO)
                .toList();
    }
}
