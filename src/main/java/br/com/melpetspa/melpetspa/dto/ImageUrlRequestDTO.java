package br.com.melpetspa.melpetspa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageUrlRequestDTO {
    @NotBlank(message = "A URL da imagem é obrigatória")
    @Pattern(regexp = "^https?://.*$", message = "A URL deve ser válida")
    private String photoUrl;
}