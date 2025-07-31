package br.com.melpetspa.melpetspa.repository;

import br.com.melpetspa.melpetspa.entity.GroomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroomerRepository extends JpaRepository<GroomerEntity, Integer> {

}
