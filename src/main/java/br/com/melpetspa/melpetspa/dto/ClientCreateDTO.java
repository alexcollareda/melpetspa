package br.com.melpetspa.melpetspa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientCreateDTO {
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private List<PetCreateDTO> pets;
}
