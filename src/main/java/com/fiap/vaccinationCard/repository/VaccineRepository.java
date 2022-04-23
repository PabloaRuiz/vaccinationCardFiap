package com.fiap.vaccinationCard.repository;

import com.fiap.vaccinationCard.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

    @Query(value = "SELECT * FROM tb_vaccine as t1 " +
            " inner join tb_user_vaccine as t2 " +
            " on t1.vaccine_id = t2.vaccine_id " +
            " inner join tb_user as t3 " +
            " on t2.user_id = t3.user_id " +
            " where t1.validity between date_sub(now(), interval :days day) and now() " +
            " and t3.user_id = :id",
    nativeQuery = true)
    List<Vaccine> getVaccine(Integer days, Long id);

    @Query(value = "SELECT * FROM tb_vaccine as t1 inner join tb_user_vaccine as t2 on t1.vaccine_id = t2.vaccine_id inner join tb_user as t3 on t2.user_id = t3.user_id where t2.user_id = :id and t1.name = :name",
            nativeQuery = true )
    List<Vaccine> getVaccineName(Long id, String name);

}
