package com.fiap.vaccinationCard.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.vaccinationCard.entities.Vaccine;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VaccineDto {

    @JsonProperty("Vacina")
    private String name;

    @JsonProperty("Aplicação")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "UTC")
    private LocalDate application;

    @JsonProperty("Vencimento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "UTC")
    private LocalDate validity;

    @JsonProperty("Status")
    private String ShelfLife;


    public VaccineDto convertVaccine(Vaccine vaccine) {
        return new VaccineDto(
                vaccine.getName(),
                vaccine.getApplication(),
                vaccine.getValidity(),
                vaccine.getShelfLife().name()
        );
    }
}