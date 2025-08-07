package br.com.melpetspa.melpetspa.repository;

import br.com.melpetspa.melpetspa.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {
    List<PetEntity> findByNomePetContainingIgnoreCase(String nomePet);
}
