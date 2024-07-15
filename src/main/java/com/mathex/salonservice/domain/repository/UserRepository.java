package com.mathex.salonservice.domain.repository;

import com.mathex.salonservice.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username); // Adicionando o método existsByUsername
}
