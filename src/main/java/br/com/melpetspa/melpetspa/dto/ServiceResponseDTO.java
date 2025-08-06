package br.com.melpetspa.melpetspa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponseDTO {
    private Integer idService;
    private String nomeService;

}
