package br.com.melpetspa.melpetspa.repository;

import br.com.melpetspa.melpetspa.entity.RaceEntity;
import br.com.melpetspa.melpetspa.entity.enums.SpeciesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaceRepository extends JpaRepository<RaceEntity, Long> {
    List<RaceEntity> findBySpecies(SpeciesEnum species);
}