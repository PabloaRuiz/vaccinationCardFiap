package com.fiap.vaccinationCard.service;


import com.fiap.vaccinationCard.entities.Address;
import com.fiap.vaccinationCard.entities.User;
import com.fiap.vaccinationCard.entities.Vaccine;
import com.fiap.vaccinationCard.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineService {

    @Autowired
    private VaccineRepository repository;

    public VaccineService(VaccineRepository repository) {
        this.repository = repository;
    }

    public Vaccine saveVaccine(Vaccine vaccine) {
        return repository.save(vaccine);
    }

    public Vaccine getByIdVaccine(Long id) {
        return repository.getById(id);
    }
}
