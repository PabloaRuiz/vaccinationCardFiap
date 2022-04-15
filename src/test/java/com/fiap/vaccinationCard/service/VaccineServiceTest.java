package com.fiap.vaccinationCard.service;


import com.fiap.vaccinationCard.entities.Address;
import com.fiap.vaccinationCard.entities.User;
import com.fiap.vaccinationCard.entities.Vaccine;
import com.fiap.vaccinationCard.repository.VaccineRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
public class VaccineServiceTest {

    private VaccineService service;

    @MockBean
    private VaccineRepository repository;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        this.service = new VaccineService(repository);
    }

    private Vaccine createVaccine() {
        return new Vaccine(null, "Gripe", LocalDate.now(), LocalDate.now().plusYears(2));
    }


    @Test
    @DisplayName("Cadastrando uma vacina")
    void registerVaccine() {
        Vaccine vaccine = createVaccine();

        Mockito.when(repository.save(vaccine))
                .thenReturn(new Vaccine(1l, "Gripe", LocalDate.now(), LocalDate.now().plusYears(2)));


        Vaccine registeredVaccine = service.saveVaccine(vaccine);

        Assertions.assertThat(registeredVaccine.getId()).isNotNull();
        Assertions.assertThat(registeredVaccine.getApplication()).isEqualTo(vaccine.getApplication());
        Assertions.assertThat(registeredVaccine.getValidity()).isEqualTo(LocalDate.of(2024,04,15));
    }

    @Test
    @DisplayName("Buscando um endereço por id")
    void getAddressId() {
        Vaccine vaccine  = createVaccine();
        vaccine.setId(1l);

        Mockito.when(repository.getById(vaccine.getId()))
                .thenReturn(new Vaccine(1l, "Gripe", LocalDate.now(), LocalDate.now().plusYears(2)));


        Vaccine getVaccine = service.getByIdVaccine(vaccine.getId());

        Assertions.assertThat(getVaccine.getId()).isNotNull();
        Assertions.assertThat(getVaccine.getApplication()).isEqualTo(vaccine.getApplication());
        Assertions.assertThat(getVaccine.getValidity()).isEqualTo(LocalDate.of(2024,04,15));
    }

}







