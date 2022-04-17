package com.fiap.vaccinationCard.entities;

import com.fiap.vaccinationCard.entities.enums.Status;

import javax.persistence.*;

@Entity
@Table(name = "Tb_Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;
    private String city;
    private String district;
    private String street;
    private Integer number;
    private Integer zipCode;
    private String complement;
    private String state;

    public Address() {
    }

    public Address(Long id, String city, String district, String street, Integer number, Integer zipCode, String complement, String state) {
        this.id = id;
        this.city = city;
        this.district = district;
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.complement = complement;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", zipCode=" + zipCode +
                ", complement='" + complement + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
