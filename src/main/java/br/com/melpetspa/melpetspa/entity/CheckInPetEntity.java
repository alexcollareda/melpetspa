package br.com.melpetspa.melpetspa.entity;

import br.com.melpetspa.melpetspa.entity.enums.StatusCheckInEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CheckInPetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCheckin;

    @ManyToOne(optional = false)
    private PetEntity pet;
    @Column(name = "nome_tutor")
    private String nomeTutor;

    @ManyToMany
    @JoinTable(
            name = "checkin_servico",
            joinColumns = @JoinColumn(name = "checkin_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "servico_id",
                    referencedColumnName = "id_servico" // <- referencia certa
            )
    )
    private List<ServiceEntity> servicos = new ArrayList<>();

    private boolean isColocaEnfeite;
    private boolean isPassaPerfume;
    private String priority;
    private String observacoes;

    @ManyToOne
    private GroomerEntity groomer;

    @Enumerated(EnumType.STRING)
    private StatusCheckInEnum status;

}
