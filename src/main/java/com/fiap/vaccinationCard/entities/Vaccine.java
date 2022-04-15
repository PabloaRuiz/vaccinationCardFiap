package com.fiap.vaccinationCard.entities;

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
    private LocalDate application;
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
}
