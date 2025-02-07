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
public class CompanyEntity extends DefaultEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompany;

    private String cnpj;
    private String companyName;
    private String email;
    private String phoneNumber;

    // Relacionamento ManyToMany com UserEntity
    @ManyToMany
    @JoinTable(
            name = "company_user", // Tabela intermediária
            joinColumns = @JoinColumn(name = "idCompany"), // Coluna de chave estrangeira para CompanyEntity
            inverseJoinColumns = @JoinColumn(name = "idUser") // Coluna de chave estrangeira para UserEntity
    )
    private List<UserEntity> users;
}
