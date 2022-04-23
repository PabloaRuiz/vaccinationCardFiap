package com.fiap.vaccinationCard;

import com.fiap.vaccinationCard.entities.Address;
import com.fiap.vaccinationCard.entities.User;
import com.fiap.vaccinationCard.entities.Vaccine;
import com.fiap.vaccinationCard.repository.AddressRepository;
import com.fiap.vaccinationCard.repository.UserRepository;
import com.fiap.vaccinationCard.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.Arrays;


@SpringBootApplication
@EnableScheduling
public class VaccinationCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationCardApplication.class, args);
	}

}
