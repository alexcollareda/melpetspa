package br.com.melpetspa.melpetspa.dto;

import br.com.melpetspa.melpetspa.entity.enums.StatusCheckInEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CheckInResponseDTO {
    private Long idCheckin;

    private Long petId;
    private String petNome;
    private String petNomeTutor;
    private Integer racaId;
    private String racaNome;
    private String racaEspecie;

    private List<ServicoResponseDTO> servicos;

    private boolean isColocaEnfeite;
    private boolean isPassaPerfume;
    private boolean isHoraRetorno;

    private LocalDateTime dataHoraRetorno;
    private String observacoes;

    private Integer groomerId;
    private String groomerNome;

    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraAlteracao;
    private LocalDateTime dataHoraFinalizacao;

    private StatusCheckInEnum status;
}
