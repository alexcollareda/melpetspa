// br/com/melpetspa/melpetspa/service/CheckInService.java
package br.com.melpetspa.melpetspa.service;

import br.com.melpetspa.melpetspa.dto.*;
import br.com.melpetspa.melpetspa.entity.CheckInPetEntity;
import br.com.melpetspa.melpetspa.entity.ServiceEntity;
import br.com.melpetspa.melpetspa.entity.enums.StatusCheckInEnum;
import br.com.melpetspa.melpetspa.repository.CheckInPetRepository;
import br.com.melpetspa.melpetspa.repository.GroomerRepository;
import br.com.melpetspa.melpetspa.repository.PetRepository;
import br.com.melpetspa.melpetspa.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckInService {

    private final CheckInPetRepository checkInPetRepository;
    private final PetRepository petRepository;
    private final ServiceRepository servicoRepository;
    private final GroomerRepository groomerRepository;

    @Transactional
    public CheckInResponseDTO criarCheckIn(CreateCheckInRequestDTO dto) {
        log.info("Criando check-in: pet={}, servicos={}, priority={}",
                dto.getIdPet(), dto.getIdServicos(), dto.getPriority());

        if (dto.getIdPet() == null) throw new IllegalArgumentException("idPet é obrigatório.");
        if (dto.getIdServicos() == null || dto.getIdServicos().isEmpty())
            throw new IllegalArgumentException("Selecione ao menos um serviço.");

        var pet = petRepository.findById(dto.getIdPet())
                .orElseThrow(() -> new IllegalArgumentException("Pet não encontrado: " + dto.getIdPet()));

        List<Integer> ids = dto.getIdServicos();
        var servicos = servicoRepository.findAllById(ids);
        if (servicos.size() != ids.size()) {
            Set<Integer> ok = new HashSet<>(servicos.stream().map(ServiceEntity::getIdService).toList());
            var faltando = ids.stream().filter(i -> !ok.contains(i)).toList();
            throw new IllegalArgumentException("Serviços inexistentes: " + faltando);
        }

        var checkin = new CheckInPetEntity();
        checkin.setPet(pet);
        checkin.setServicos(servicos);
        checkin.setColocaEnfeite(dto.isColocaEnfeite());
        checkin.setPassaPerfume(dto.isPassaPerfume());
        checkin.setPriority(dto.getPriority() != null ? dto.getPriority().toUpperCase() : null);
        checkin.setObservacoes(dto.getObservacoes());
        checkin.setDataHoraCriacao(LocalDateTime.now());
        checkin.setStatus(StatusCheckInEnum.AGUARDANDO);

        return toDTO(checkInPetRepository.saveAndFlush(checkin));
    }

    @Transactional
    public CheckInResponseDTO iniciarTrabalho(StartJobRequestDTO dto) {
        if (dto.getIdCheckIn() == null || dto.getIdGroomer() == null)
            throw new IllegalArgumentException("idCheckIn e idGroomer são obrigatórios.");

        var checkin = checkInPetRepository.findById(dto.getIdCheckIn())
                .orElseThrow(() -> new IllegalArgumentException("Check-in não encontrado: " + dto.getIdCheckIn()));

        if (checkin.getStatus() != StatusCheckInEnum.AGUARDANDO)
            throw new IllegalStateException("Só é possível iniciar check-ins em AGUARDANDO.");

        var groomer = groomerRepository.findById(dto.getIdGroomer())
                .orElseThrow(() -> new IllegalArgumentException("Groomer não encontrado: " + dto.getIdGroomer()));

        checkin.setGroomer(groomer);
        checkin.setStatus(StatusCheckInEnum.INICIADO);
        checkin.setDataHoraAlteracao(LocalDateTime.now());

        return toDTO(checkInPetRepository.saveAndFlush(checkin));
    }

    @Transactional
    public CheckInResponseDTO finalizarTrabalho(EndJobRequestDTO dto) {
        if (dto.getIdCheckIn() == null) throw new IllegalArgumentException("idCheckIn é obrigatório.");

        var checkin = checkInPetRepository.findById(dto.getIdCheckIn())
                .orElseThrow(() -> new IllegalArgumentException("Check-in não encontrado: " + dto.getIdCheckIn()));

        if (checkin.getStatus() != StatusCheckInEnum.INICIADO)
            throw new IllegalStateException("Só é possível finalizar check-ins em INICIADO.");

        checkin.setStatus(StatusCheckInEnum.FINALIZADO);
        checkin.setDataHoraFinalizacao(LocalDateTime.now());

        return toDTO(checkInPetRepository.saveAndFlush(checkin));
    }

    @Transactional(readOnly = true)
    public List<CheckInResponseDTO> listarCheckinsHoje() {
        LocalDateTime start = LocalDate.now().atStartOfDay();
        LocalDateTime end = start.plusDays(1);
        return checkInPetRepository.findAllByDataHoraCriacaoBetween(start, end)
                .stream().map(this::toDTO).toList();
    }

    @Transactional(readOnly = true)
    public List<CheckInResponseDTO> buscarPorData(String data) {
        if (data == null || data.isBlank()) {
            // opcional: default para hoje
            LocalDate hoje = LocalDate.now();
            return buscarEntre(hoje.atStartOfDay(), hoje.plusDays(1).atStartOfDay());
        }

        LocalDate d = parseDataFlex(data); // aceita dd/MM/yyyy ou yyyy-MM-dd
        LocalDateTime start = d.atStartOfDay();
        LocalDateTime end = start.plusDays(1);

        return buscarEntre(start, end);
    }

    private List<CheckInResponseDTO> buscarEntre(LocalDateTime start, LocalDateTime end) {
        return checkInPetRepository.findAllByDataHoraCriacaoBetween(start, end)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private LocalDate parseDataFlex(String texto) {
        List<DateTimeFormatter> formatos = List.of(
                DateTimeFormatter.ofPattern("dd/MM/yyyy"),
                DateTimeFormatter.ISO_LOCAL_DATE // yyyy-MM-dd
        );
        for (DateTimeFormatter f : formatos) {
            try {
                return LocalDate.parse(texto, f);
            } catch (Exception ignored) { }
        }
        throw new IllegalArgumentException("Data inválida. Use dd/MM/yyyy ou yyyy-MM-dd.");
    }

    private CheckInResponseDTO toDTO(CheckInPetEntity e) {
        var dto = new CheckInResponseDTO();
        dto.setIdCheckin(e.getIdCheckin());

        if (e.getPet() != null) {
            dto.setIdPet(e.getPet().getIdPet());
            dto.setPetNome(e.getPet().getNomePet());
            dto.setNomeTutor(e.getPet().getNomeTutor());
            if (e.getPet().getRace() != null) {
                dto.setIdRaca(e.getPet().getRace().getIdRace());
                dto.setRacaNome(e.getPet().getRace().getNameRace());
                dto.setRacaEspecie(e.getPet().getRace().getSpecie() != null
                        ? e.getPet().getRace().getSpecie().name() : null);
            }
        }

        if (e.getServicos() != null && !e.getServicos().isEmpty()) {
            dto.setServicos(
                    e.getServicos().stream()
                            .map(s -> new ServiceResponseDTO(s.getIdService(), s.getNomeService()))
                            .toList()
            );
        }

        dto.setColocaEnfeite(e.isColocaEnfeite());
        dto.setPassaPerfume(e.isPassaPerfume());
        dto.setPriority(e.getPriority());
        dto.setObservacoes(e.getObservacoes());

        if (e.getGroomer() != null) {
            dto.setGroomerId(e.getGroomer().getIdGroomer());
            dto.setGroomerNome(e.getGroomer().getNomeGroomer());
        }

        dto.setDataHoraCriacao(e.getDataHoraCriacao());
        dto.setDataHoraAlteracao(e.getDataHoraAlteracao());
        dto.setDataHoraFinalizacao(e.getDataHoraFinalizacao());
        dto.setStatus(e.getStatus());

        return dto;
    }
}
