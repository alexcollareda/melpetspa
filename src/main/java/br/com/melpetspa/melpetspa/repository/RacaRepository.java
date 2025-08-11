package br.com.melpetspa.melpetspa.repository;

import br.com.melpetspa.melpetspa.entity.RacaEntity;
import br.com.melpetspa.melpetspa.entity.enums.SpecieEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RacaRepository extends JpaRepository<RacaEntity, Long> {
    List<RacaEntity> findBySpecie(SpecieEnum specie);
}
