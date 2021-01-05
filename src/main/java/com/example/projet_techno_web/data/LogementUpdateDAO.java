package com.example.projet_techno_web.data;

import com.example.projet_techno_web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LogementUpdateDAO extends JpaRepository<User, Integer> {
    @Modifying
    @Query("update Logement l SET l.adresse = :kAdressse WHERE l.idMembre= :x")
    int updateUser(@Param("kAdressse") String kAdressse, @Param("x") long x);
}


