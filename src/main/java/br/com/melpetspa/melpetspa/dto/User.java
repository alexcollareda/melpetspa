package br.com.melpetspa.melpetspa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String username;
    private String accessType;  // Tipo de acesso: user ou client
}
