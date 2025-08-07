package br.com.melpetspa.melpetspa.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCheckInRequestDTO {

    private Long idPet;
    private List<Integer> idServicos;
    private boolean isColocaEnfeite;
    private boolean isPassaPerfume;
    private String priority;
    private String observacoes;
}
