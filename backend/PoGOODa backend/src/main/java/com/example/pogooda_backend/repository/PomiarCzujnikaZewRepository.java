package com.example.pogooda_backend.repository;

import com.example.pogooda_backend.model.jpa.PomiarCzujnikaZew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface PomiarCzujnikaZewRepository extends JpaRepository<PomiarCzujnikaZew, Integer> {
    Optional<PomiarCzujnikaZew> findByCzasOdczytu(Timestamp timestamp);

    Optional<PomiarCzujnikaZew> findFirstByOrderByCzasOdczytuDesc();

}
