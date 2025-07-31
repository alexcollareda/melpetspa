package br.com.melpetspa.melpetspa.repository;

import br.com.melpetspa.melpetspa.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoEntity, Integer> {

}