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
public class UserEntity extends DefaultEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String name;
    private String phone;
    private String email;
    private String password;

    // Relacionamento ManyToMany com CompanyEntity
    @ManyToMany(mappedBy = "users") // "users" refere-se à propriedade na classe CompanyEntity
    private List<CompanyEntity> companies;
}
