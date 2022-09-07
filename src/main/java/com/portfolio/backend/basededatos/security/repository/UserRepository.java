package com.portfolio.backend.basededatos.security.repository;

import com.portfolio.backend.basededatos.security.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {

    public Optional<Usuario> findByEmail(String email);

    public Boolean existsByEmail(String email);
}
