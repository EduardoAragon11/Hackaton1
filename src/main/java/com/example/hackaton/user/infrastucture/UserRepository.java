package com.example.hackaton.user.infrastucture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hackaton.user.domain.User;

import java.util.Optional;


@Repository
public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    Optional<T> findByEmail(String email);
}
