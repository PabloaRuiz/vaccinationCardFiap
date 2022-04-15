package com.fiap.vaccinationCard.repository;

import com.fiap.vaccinationCard.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
}
