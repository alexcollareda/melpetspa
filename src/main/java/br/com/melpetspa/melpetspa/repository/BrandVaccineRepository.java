package br.com.melpetspa.melpetspa.repository;

import br.com.melpetspa.melpetspa.entity.BrandVaccineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandVaccineRepository extends JpaRepository<BrandVaccineEntity, Long> {
}
