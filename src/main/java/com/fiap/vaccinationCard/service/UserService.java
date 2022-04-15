package com.fiap.vaccinationCard.service;


import com.fiap.vaccinationCard.entities.Address;
import com.fiap.vaccinationCard.entities.User;
import com.fiap.vaccinationCard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User getByIdUser(Long id) {
        return repository.getById(id);
    }
}
