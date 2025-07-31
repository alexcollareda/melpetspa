package br.com.melpetspa.melpetspa.service;

import br.com.melpetspa.melpetspa.dto.CreateCheckInRequestDTO;
import br.com.melpetspa.melpetspa.dto.EndJobRequestDTO;
import br.com.melpetspa.melpetspa.dto.StartJobRequestDTO;
import br.com.melpetspa.melpetspa.entity.CheckInPetEntity;
import br.com.melpetspa.melpetspa.entity.enums.StatusCheckInEnum;
import br.com.melpetspa.melpetspa.repository.CheckInPetRepository;
import br.com.melpetspa.melpetspa.repository.GroomerRepository;
import br.com.melpetspa.melpetspa.repository.PetRepository;
import br.com.melpetspa.melpetspa.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CheckInService {
    private final CheckInPetRepository repo;
    private final PetRepository petRepo;
    private final ServicoRepository servicoRepo;
    private final GroomerRepository groomerRepo;

    public CheckInResponseDTO criarCheckIn(CreateCheckInRequestDTO dto) {
        CheckInPetEntity checkin = new CheckInPetEntity();
        checkin.setPet(petRepo.findById(dto.getIdPet()).orElseThrow());
        checkin.setServicos(servicoRepo.findAllById(dto.getIdServicos()));
        checkin.setIsColocaEnfeite(dto.isColocaEnfeite());
        checkin.setIsPassaPerfume(dto.isPassaPerfume());
        checkin.setIsHoraRetorno(dto.isHoraRetorno());
        checkin.setDataHoraRetorno(dto.getDataHoraRetorno());
        checkin.setObservacoes(dto.getObservacoes());
        checkin.setDataHoraCriacao(LocalDateTime.now());
        checkin.setStatus(StatusCheckInEnum.AGUARDANDO);
        return toDTO(repo.save(checkin));
    }

    public CheckInResponseDTO iniciarTrabalho(StartJobRequestDTO dto) {
        CheckInPetEntity checkin = repo.findById(dto.getIdCheckIn()).orElseThrow();
        checkin.setGroomer(groomerRepo.findById(dto.getIdGroomer()).orElseThrow());
        checkin.setStatus(StatusCheckInEnum.INICIADO);
        checkin.setDataHoraAlteracao(LocalDateTime.now());
        return toDTO(repo.save(checkin));
    }

    public CheckInResponseDTO finalizarTrabalho(EndJobRequestDTO dto) {
        CheckInPetEntity checkin = repo.findById(dto.getIdCheckIn()).orElseThrow();
        checkin.setStatus(StatusCheckInEnum.FINALIZADO);
        checkin.setDataHoraFinalizacao(LocalDateTime.now());
        return toDTO(repo.save(checkin));
    }

    public List<CheckInResponseDTO> listarCheckinsHoje() {
        LocalDateTime start = LocalDate.now().atStartOfDay();
        LocalDateTime end = start.plusDays(1);
        return repo.findAllByDataHoraCriacaoBetween(start, end)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<CheckInResponseDTO> buscarPorData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate localDate = LocalDate.parse(data, formatter);
        LocalDateTime start = localDate.atStartOfDay();
        LocalDateTime end = start.plusDays(1);
        return repo.findAllByDataHoraCriacaoBetween(start, end)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    private CheckInResponseDTO toDTO(CheckInPetEntity entity) {
        // Mapear para DTO
        return null;
    }
}
