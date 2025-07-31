package br.com.melpetspa.melpetspa.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePetRequestDTO {
    private String nomePet;
    private String nomeTutor;
    private Integer idRaca;
}