package br.com.melpetspa.melpetspa.dto;

import br.com.melpetspa.melpetspa.entity.enums.StatusCheckInEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckInResponseDTO {
    private Long idCheckin;

    private Long petId;
    private String petNome;
    private String petNomeTutor;
    private Integer racaId;
    private String racaNome;
    private String racaEspecie;

    private List<ServiceResponseDTO> servicos;

    private boolean isColocaEnfeite;
    private boolean isPassaPerfume;
    private String priority;
    private String observacoes;

    private Integer groomerId;
    private String groomerNome;

    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraAlteracao;
    private LocalDateTime dataHoraFinalizacao;

    private StatusCheckInEnum status;
}
