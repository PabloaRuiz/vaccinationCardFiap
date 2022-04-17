package com.fiap.vaccinationCard.controller;


import com.fiap.vaccinationCard.dto.UserVaccinesDto;
import com.fiap.vaccinationCard.entities.User;
import com.fiap.vaccinationCard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping("/Vaccines/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserVaccinesDto getUserCardVaccines(@PathVariable Long id){
        User obj = service.getUserVaccines(id);
        UserVaccinesDto UserDto = new UserVaccinesDto().convertCustomer(obj);
        return UserDto;
    }

}