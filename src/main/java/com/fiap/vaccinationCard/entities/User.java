package com.fiap.vaccinationCard.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String document;
    private LocalDate dateOfBirth;

    @OneToOne
    @JoinColumn(name ="address_id")
    private Address address;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "vaccine_id"),
            name = "tb_user_vaccine")
    private List<Vaccine> vaccines = new ArrayList<Vaccine>();

    public User() {
    }

    public User(Long id, String name, String document, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.dateOfBirth = dateOfBirth;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    public void addVaccines(Vaccine vaccine) {
        this.vaccines.add(vaccine);
    }
}
