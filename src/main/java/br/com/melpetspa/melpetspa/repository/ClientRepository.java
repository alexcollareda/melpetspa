package br.com.melpetspa.melpetspa.repository;

import br.com.melpetspa.melpetspa.entity.ClientEntity;
import br.com.melpetspa.melpetspa.entity.RaceEntity;
import br.com.melpetspa.melpetspa.entity.enums.SpeciesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByPhone(String phone);

    ClientEntity findByCpf(String cpf);
}
