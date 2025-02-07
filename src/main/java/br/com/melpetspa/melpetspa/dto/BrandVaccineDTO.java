package br.com.melpetspa.melpetspa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandVaccineDTO {
    private Long idBrandVaccine;
    private String name;
}