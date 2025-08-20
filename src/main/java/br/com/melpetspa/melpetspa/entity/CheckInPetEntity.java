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
        @Column(name = "id_checkin")
        private Long idCheckin;

    @ManyToOne(optional = false)
    private PetEntity pet;

        @Column(name = "nome_tutor")
        private String nomeTutor;

        @ManyToMany
        @JoinTable(
                name = "checkin_servico",
                joinColumns = @JoinColumn(name = "checkin_id", referencedColumnName = "id_checkin"),
                inverseJoinColumns = @JoinColumn(name = "servico_id", referencedColumnName = "id_servico")
        )
        private List<ServiceEntity> servicos;

    @Column(name = "is_coloca_enfeite", nullable = false)
    private boolean isColocaEnfeite;

    @Column(name = "is_passa_perfume", nullable = false)
    private boolean isPassaPerfume;

    @Column(name = "priority")
        private String priority;

        @Column(name = "observacoes")
        private String observacoes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_groomer")
    private GroomerEntity groomer;

        @Column(name = "data_hora_criacao")
        private LocalDateTime dataHoraCriacao;

        @Column(name = "data_hora_alteracao")
        private LocalDateTime dataHoraAlteracao;

        @Column(name = "data_hora_finalizacao")
        private LocalDateTime dataHoraFinalizacao;

        @Enumerated(EnumType.STRING)
        @Column(name = "status")
        private StatusCheckInEnum status;

    @Column(name = "alterado", nullable = false)
    private boolean alterado; // primitivo evita null

}
