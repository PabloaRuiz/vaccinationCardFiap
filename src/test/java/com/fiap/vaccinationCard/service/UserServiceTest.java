package com.fiap.vaccinationCard.service;


import com.fiap.vaccinationCard.entities.Address;
import com.fiap.vaccinationCard.entities.User;
import com.fiap.vaccinationCard.entities.Vaccine;
import com.fiap.vaccinationCard.repository.UserRepository;
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
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    private UserService service;

    @MockBean
    private UserRepository repository;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        this.service = new UserService(repository);
    }

    private User createUser() {
        return new User(null, "Evelyn Fiap dos Santos", "449.513.685.98", LocalDate.of(1989, 12, 04));
    }

    private Address createAddress() {
        return new Address(1l, "Ribeirão Preto", "Sumaré", "Av Caramuru", 2450, 14800250, "Torre 1 apto 28", "São Paulo" );
    }

    private Vaccine createVaccine() {
        return new Vaccine(1l, "Gripe", LocalDate.now(), LocalDate.now().plusYears(2));
    }


    @Test
    @DisplayName("Cadastrar um usuário")
    void registerUser() {
        User user = createUser();

        Mockito.when(repository.save(user))
                .thenReturn(new User(1l, "Evelyn Fiap dos Santos", "449.513.685.98", LocalDate.of(1989, 12, 04)));


        User registeredUser = service.saveUser(user);

        Assertions.assertThat(registeredUser.getId()).isNotNull();
        Assertions.assertThat(registeredUser.getName()).isEqualTo("Evelyn Fiap dos Santos");
        Assertions.assertThat(registeredUser.getDocument()).isEqualTo(user.getDocument());
        Assertions.assertThat(registeredUser.getDateOfBirth()).isEqualTo(user.getDateOfBirth());
    }


    @Test
    @DisplayName("Buscando um usuário por id")
    void getUserId() {
        User user = createUser();
        user.setId(1l);

        Mockito.when(repository.getById(user.getId()))
                .thenReturn(new User(1l, "Evelyn Fiap dos Santos", "449.513.685.98", LocalDate.of(1989, 12, 04)));


        User getUser = service.getByIdUser(user.getId());

        Assertions.assertThat(getUser.getId()).isNotNull();
        Assertions.assertThat(getUser.getName()).isEqualTo("Evelyn Fiap dos Santos");
        Assertions.assertThat(getUser.getDocument()).isEqualTo(user.getDocument());
        Assertions.assertThat(getUser.getDateOfBirth()).isEqualTo(user.getDateOfBirth());
    }

    @Test
    @DisplayName("Carteira de vacinação")
    void cardUser() {
        User user = createUser();
        Vaccine vaccine = createVaccine();
        Address address = createAddress();
        user.addVaccines(vaccine);
        user.setAddress(address);
        user.setId(1l);

        Mockito.when(repository.getById(user.getId()))
                .thenReturn(user);

        User getUser = service.getByIdUser(user.getId());

        Assertions.assertThat(getUser.getId()).isNotNull();
        Assertions.assertThat(getUser.getName()).isEqualTo("Evelyn Fiap dos Santos");
        Assertions.assertThat(getUser.getDocument()).isEqualTo(user.getDocument());
        Assertions.assertThat(getUser.getDateOfBirth()).isEqualTo(user.getDateOfBirth());
        Assertions.assertThat(getUser.getAddress().getCity()).isEqualTo(address.getCity());
        Assertions.assertThat(getUser.getDateOfBirth()).isEqualTo(user.getDateOfBirth());
        Assertions.assertThat(getUser.getVaccines().containsAll(user.getVaccines()));
    }

}
