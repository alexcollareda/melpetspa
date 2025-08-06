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

    @ManyToMany
    @JoinTable(
            name = "checkin_servico",
            joinColumns = @JoinColumn(name = "checkin_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id"))
    private List<ServicoEntity> servicos = new ArrayList<>();

    private boolean isColocaEnfeite;
    private boolean isPassaPerfume;
    private boolean isHoraRetorno;
    private LocalDateTime dataHoraRetorno;
    private String priority;
    private String observacoes;

    @ManyToOne
    private GroomerEntity groomer;

    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraAlteracao;
    private LocalDateTime dataHoraFinalizacao;

    @Enumerated(EnumType.STRING)
    private StatusCheckInEnum status;

}
