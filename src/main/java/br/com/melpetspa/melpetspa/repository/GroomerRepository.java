package br.com.melpetspa.melpetspa.repository;

import br.com.melpetspa.melpetspa.entity.GroomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroomerRepository extends JpaRepository<GroomerEntity, Integer> {

    List<GroomerEntity> findByAtivoTrue();

}
