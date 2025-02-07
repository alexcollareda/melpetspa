package br.com.melpetspa.melpetspa.repository;

import br.com.melpetspa.melpetspa.entity.PetEntity;
import br.com.melpetspa.melpetspa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {

    @Query("SELECT pet FROM PetEntity pet WHERE pet.client.idClient = :idClient")
    List<PetEntity> findByIdClient(Long idClient);

}
