package br.com.melpetspa.melpetspa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateCheckInRequestDTO {
    private List<Integer> idServicos;
    private String priority;
    private Boolean colocaEnfeite;
    private Boolean passaPerfume;
    private String observacoes;
}
