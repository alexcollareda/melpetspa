package br.com.melpetspa.melpetspa.repository;

import br.com.melpetspa.melpetspa.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Integer> {

}