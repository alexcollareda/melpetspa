package br.com.melpetspa.melpetspa.repository;

import br.com.melpetspa.melpetspa.entity.PetEntity;
import br.com.melpetspa.melpetspa.entity.enums.SpecieEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {
    List<PetEntity> findByNomePetContainingIgnoreCase(String nomePet);
    @Query("SELECT p FROM PetEntity p JOIN p.race r WHERE r.specie = :specie")
    List<PetEntity> findByRace_Specie(SpecieEnum specie);
}
