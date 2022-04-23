package com.fiap.vaccinationCard.repository;

import com.fiap.vaccinationCard.entities.Vaccine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class VaccineRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private VaccineRepository repository;

    private Vaccine createVaccine(LocalDate VaccineDate) {
        Vaccine vacina = new Vaccine(null, "Gripe", LocalDate.now(), LocalDate.now().minusDays(10));
        entityManager.persist(vacina);
        return vacina;
    }

}
