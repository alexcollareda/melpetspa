package br.com.melpetspa.melpetspa.service;

import br.com.melpetspa.melpetspa.dto.CheckInResponseDTO;
import br.com.melpetspa.melpetspa.dto.CreateCheckInRequestDTO;
import br.com.melpetspa.melpetspa.dto.EndJobRequestDTO;
import br.com.melpetspa.melpetspa.dto.StartJobRequestDTO;
import br.com.melpetspa.melpetspa.entity.CheckInPetEntity;
import br.com.melpetspa.melpetspa.entity.enums.StatusCheckInEnum;
import br.com.melpetspa.melpetspa.repository.CheckInPetRepository;
import br.com.melpetspa.melpetspa.repository.GroomerRepository;
import br.com.melpetspa.melpetspa.repository.PetRepository;
import br.com.melpetspa.melpetspa.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CheckInService {
    private final CheckInPetRepository checkInPetRepository;
    private final PetRepository petRepository;
    private final ServiceRepository servicoRepository;
    private final GroomerRepository groomerRepository;

    public CheckInResponseDTO criarCheckIn(CreateCheckInRequestDTO createCheckInRequestDTO) {
        CheckInPetEntity checkin = new CheckInPetEntity();
        checkin.setPet(petRepository.findById(createCheckInRequestDTO.getIdPet()).orElseThrow());
        checkin.setServicos(servicoRepository.findAllById(createCheckInRequestDTO.getIdServicos()));
        checkin.setColocaEnfeite(createCheckInRequestDTO.isColocaEnfeite());
        checkin.setPassaPerfume(createCheckInRequestDTO.isPassaPerfume());
        checkin.setPriority(createCheckInRequestDTO.getPriority());
        checkin.setObservacoes(createCheckInRequestDTO.getObservacoes());
        checkin.setDataHoraCriacao(LocalDateTime.now());
        checkin.setStatus(StatusCheckInEnum.AGUARDANDO);
        return toDTO(checkInPetRepository.save(checkin));
    }

    public CheckInResponseDTO iniciarTrabalho(StartJobRequestDTO startJobRequestDTO) {
        CheckInPetEntity checkin = checkInPetRepository.findById(startJobRequestDTO.getIdCheckIn()).orElseThrow();
        checkin.setGroomer(groomerRepository.findById(startJobRequestDTO.getIdGroomer()).orElseThrow());
        checkin.setStatus(StatusCheckInEnum.INICIADO);
        checkin.setDataHoraAlteracao(LocalDateTime.now());
        return toDTO(checkInPetRepository.save(checkin));
    }

    public CheckInResponseDTO finalizarTrabalho(EndJobRequestDTO endJobRequestDTO) {
        CheckInPetEntity checkin = checkInPetRepository.findById(endJobRequestDTO.getIdCheckIn()).orElseThrow();
        checkin.setStatus(StatusCheckInEnum.FINALIZADO);
        checkin.setDataHoraFinalizacao(LocalDateTime.now());
        return toDTO(checkInPetRepository.save(checkin));
    }

    public List<CheckInResponseDTO> listarCheckinsHoje() {
        LocalDateTime start = LocalDate.now().atStartOfDay();
        LocalDateTime end = start.plusDays(1);
        return checkInPetRepository.findAllByDataHoraCriacaoBetween(start, end)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<CheckInResponseDTO> buscarPorData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate localDate = LocalDate.parse(data, formatter);
        LocalDateTime start = localDate.atStartOfDay();
        LocalDateTime end = start.plusDays(1);
        return checkInPetRepository.findAllByDataHoraCriacaoBetween(start, end)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    private CheckInResponseDTO toDTO(CheckInPetEntity entity) {
        return null;
    }
}
