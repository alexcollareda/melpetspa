package br.com.melpetspa.melpetspa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCheckInRequestDTO {
    @NotNull
    private Long idPet;

    @NotEmpty
    private List<Integer> idServicos; // Integer, igual ao @Id do serviço

    @JsonProperty("colocaEnfeite")
    private boolean colocaEnfeite;

    @JsonProperty("passaPerfume")
    private boolean passaPerfume;

    private String priority;   // envie "ALTA" | "MEDIA" | "BAIXA"
    private String observacoes;
}
