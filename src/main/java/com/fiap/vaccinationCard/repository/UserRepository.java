package com.fiap.vaccinationCard.repository;

import com.fiap.vaccinationCard.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM TB_USER as T1 INNER JOIN TB_USER_VACCINE as T2 ON T1.USER_ID = T2.USER_ID INNER JOIN TB_VACCINE as T3 ON T2.VACCINE_ID = T3.VACCINE_ID INNER JOIN TB_ADDRESS as T4 ON T1.ADDRESS_ID = T4.ADDRESS_ID WHERE T1.USER_ID = :id",
            nativeQuery = true)
    User UserVaccines(Long id);

}
