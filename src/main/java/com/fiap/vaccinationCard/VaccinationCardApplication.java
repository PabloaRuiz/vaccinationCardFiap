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

import java.time.LocalDate;
import java.util.Arrays;


@SpringBootApplication
public class VaccinationCardApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private VaccineRepository vaccineRepository;


	public static void main(String[] args) {
		SpringApplication.run(VaccinationCardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Address address = new Address(null, "Ribeirão Preto", "Sumaré", "Av Caramuru", 2450, 14800250, "Torre 1 apto 28", "São Paulo" );
		Vaccine vaccine = new Vaccine(null, "Gripe", LocalDate.now(), LocalDate.now().plusYears(2));

		User user = new User(null, "Evelyn Fiap dos Santos", "449.513.685.98", LocalDate.of(1989, 12, 04));

		addressRepository.save(address);
		vaccineRepository.save(vaccine);
		user.getVaccines().addAll(Arrays.asList(vaccine));
		user.setAddress(address);
		userRepository.save(user);






	}
}
