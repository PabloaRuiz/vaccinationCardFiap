package com.fiap.vaccinationCard.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fiap.vaccinationCard.entities.enums.Status;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_vaccine")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="vaccine_id")
    private Long id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "UTC")
    private LocalDate application;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "UTC")
    private LocalDate validity;


    public Vaccine() {
    }

    public Vaccine(Long id, String name, LocalDate application, LocalDate validity) {
        this.id = id;
        this.name = name;
        this.application = application;
        this.validity = validity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getApplication() {
        return application;
    }

    public void setApplication(LocalDate application) {
        this.application = application;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }


    public Status getShelfLife() {
        if (getValidity().isBefore(LocalDate.now())) {
            return Status.VENCIDA;
        } else {
            return  Status.EM_DIA;
        }
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", application=" + application +
                ", validity=" + validity +
                '}';
    }
}
