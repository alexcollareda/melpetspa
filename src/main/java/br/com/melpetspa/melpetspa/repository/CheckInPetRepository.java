package br.com.melpetspa.melpetspa.repository;

import br.com.melpetspa.melpetspa.entity.CheckInPetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CheckInPetRepository extends JpaRepository<CheckInPetEntity, Long> {
    List<CheckInPetEntity> findAllByDataHoraCriacaoBetween(LocalDateTime start, LocalDateTime end);
}
