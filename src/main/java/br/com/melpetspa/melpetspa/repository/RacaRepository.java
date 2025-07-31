package br.com.melpetspa.melpetspa.repository;

import br.com.melpetspa.melpetspa.entity.RacaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacaRepository extends JpaRepository<RacaEntity, Integer> {

}
