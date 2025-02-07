package br.com.melpetspa.melpetspa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BrandVaccineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBrandVaccine;

    private String name;
}
