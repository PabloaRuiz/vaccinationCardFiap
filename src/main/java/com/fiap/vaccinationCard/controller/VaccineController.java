package com.fiap.vaccinationCard.controller;

import com.fiap.vaccinationCard.dto.VaccineDto;
import com.fiap.vaccinationCard.entities.Vaccine;
import com.fiap.vaccinationCard.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vaccine")
public class VaccineController {

    private VaccineService service;

    @Autowired
    public VaccineController(VaccineService service) {
        this.service = service;
    }


    @GetMapping("/days/{days}/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineDto> getVaccine(@PathVariable Integer days, @PathVariable Long id){
        List<Vaccine>  listObj = service.getVaccines(days, id);
        List<VaccineDto> objDto = listObj.stream().map(obj -> new VaccineDto().convertVaccine(obj)).collect(Collectors.toList());
        return objDto;
    }

    @GetMapping("/user/{id}/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineDto> getVaccineName(@PathVariable Long id, @PathVariable String name){
        List<Vaccine>  listObj = service.getVaccineName(id, name);
        List<VaccineDto> objDto = listObj.stream().map(obj -> new VaccineDto().convertVaccine(obj)).collect(Collectors.toList());
        return objDto;
    }
}