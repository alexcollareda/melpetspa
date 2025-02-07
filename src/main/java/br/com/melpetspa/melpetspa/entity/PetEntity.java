package br.com.melpetspa.melpetspa.entity;

import br.com.melpetspa.melpetspa.entity.enums.GenderEnum;
import br.com.melpetspa.melpetspa.entity.enums.SpeciesEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PetEntity extends DefaultEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPet;

    private String name;

    private String chipCode;

    @ManyToOne
    private RaceEntity race;

    @Enumerated(EnumType.STRING) // Isso é necessário para enumerar corretamente os valores de enum
    private SpeciesEnum speciesEnum;

    @Enumerated(EnumType.STRING)
    private GenderEnum genderEnum;

    private String photo;

    private LocalDate bornDate;

    // Relacionamento ManyToOne com ClientEntity
    @ManyToOne
    @JoinColumn(name = "id_client") // Chave estrangeira para o cliente
    private ClientEntity client;
}
