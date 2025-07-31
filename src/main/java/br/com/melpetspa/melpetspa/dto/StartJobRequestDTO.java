package br.com.melpetspa.melpetspa.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartJobRequestDTO {
    private Long idCheckIn;
    private Integer idGroomer;
}
