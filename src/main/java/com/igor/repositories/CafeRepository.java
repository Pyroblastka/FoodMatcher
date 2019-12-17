package com.igor.repositories;

import com.igor.entities.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Long> {
    Cafe findByName(String name);
}
