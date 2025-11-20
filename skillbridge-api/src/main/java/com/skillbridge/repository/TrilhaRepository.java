package com.skillbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skillbridge.model.Trilha;

public interface TrilhaRepository extends JpaRepository<Trilha, Long> {
}
