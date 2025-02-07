package br.com.melpetspa.melpetspa.repository;

import br.com.melpetspa.melpetspa.entity.ClientEntity;
import br.com.melpetspa.melpetspa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
