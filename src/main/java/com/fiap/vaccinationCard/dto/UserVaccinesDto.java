package com.fiap.vaccinationCard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.vaccinationCard.entities.User;
import com.fiap.vaccinationCard.entities.Vaccine;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserVaccinesDto {

    @JsonProperty("Nome")
    private String name;

    @JsonProperty("Idade")
    private int Age;

    @JsonProperty("CPF")
    private String document;


    @JsonProperty("E-mail")
    private String email;

    @JsonProperty("Cidade")
    private String city;

    @JsonProperty("Bairro")
    private String district;

    @JsonProperty("Rua")
    private String street;

    @JsonProperty("nº")
    private Integer number;

    @JsonProperty("CEP")
    private Integer zipCode;

    @JsonProperty("Complemento")
    private String complement;

    @JsonProperty("UF")
    private String state;

    @JsonProperty("Vacinas")
    private List<Vaccine> vaccines;


    public UserVaccinesDto convertCustomer(User user) {
        return new UserVaccinesDto(
                user.getName(),
                user.getAge(),
                user.getDocument(),
                user.getEmail(),
                user.getAddress().getCity(),
                user.getAddress().getDistrict(),
                user.getAddress().getStreet(),
                user.getAddress().getNumber(),
                user.getAddress().getZipCode(),
                user.getAddress().getComplement(),
                user.getAddress().getState(),
                user.getVaccines());
    }
}