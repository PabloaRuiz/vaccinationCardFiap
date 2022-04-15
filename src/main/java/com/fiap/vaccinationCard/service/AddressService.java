package com.fiap.vaccinationCard.service;

import com.fiap.vaccinationCard.entities.Address;
import com.fiap.vaccinationCard.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public Address saveAddress(Address address) {
        return repository.save(address);
    }

    public Address getByIdAddress(Long id) {
        return repository.getById(id);
    }
}
