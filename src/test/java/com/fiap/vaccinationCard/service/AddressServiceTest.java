package com.fiap.vaccinationCard.service;


import com.fiap.vaccinationCard.entities.Address;
import com.fiap.vaccinationCard.entities.User;
import com.fiap.vaccinationCard.repository.AddressRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
public class AddressServiceTest {

    private AddressService service;

    @MockBean
    private AddressRepository repository;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        this.service = new AddressService(repository);
    }

    private Address createAddress() {
        return new Address(null, "Ribeirão Preto", "Sumaré", "Av Caramuru", 2450, 14800250, "Torre 1 apto 28", "São Paulo" );
    }


    @Test
    @DisplayName("Cadastrar um endereço")
    void registerAddress() {
        Address address = createAddress();

        Mockito.when(repository.save(address))
                .thenReturn(new Address(1l, "Ribeirão Preto", "Sumaré", "Av Caramuru", 2450, 14800250, "Torre 1 apto 28", "São Paulo" ));


        Address registeredAddress = service.saveAddress(address);

        Assertions.assertThat(registeredAddress.getId()).isNotNull();
        Assertions.assertThat(registeredAddress.getCity()).isEqualTo(address.getCity());
        Assertions.assertThat(registeredAddress.getDistrict()).isEqualTo(address.getDistrict());
        Assertions.assertThat(registeredAddress.getStreet()).isEqualTo(address.getStreet());
        Assertions.assertThat(registeredAddress.getComplement()).isEqualTo(address.getComplement());
        Assertions.assertThat(registeredAddress.getState()).isEqualTo(address.getState());
    }

    @Test
    @DisplayName("Buscando um endereço por id")
    void getAddressId() {
        Address address = createAddress();
        address.setId(1l);

        Mockito.when(repository.getById(address.getId()))
                .thenReturn(new Address(1l, "Ribeirão Preto", "Sumaré", "Av Caramuru", 2450, 14800250, "Torre 1 apto 28", "São Paulo" ));


        Address getAddress = service.getByIdAddress(address.getId());

        Assertions.assertThat(getAddress.getId()).isNotNull();
        Assertions.assertThat(getAddress.getCity()).isEqualTo(address.getCity());
        Assertions.assertThat(getAddress.getDistrict()).isEqualTo(address.getDistrict());
        Assertions.assertThat(getAddress.getStreet()).isEqualTo(address.getStreet());
        Assertions.assertThat(getAddress.getComplement()).isEqualTo(address.getComplement());
        Assertions.assertThat(getAddress.getState()).isEqualTo(address.getState());
    }
}
