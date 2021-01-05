package com.example.projet_techno_web.data;

import com.example.projet_techno_web.model.Logement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogementDAO extends JpaRepository<Logement, Long> {

    @Query("select l from Logement l where l.idMembre = :x")
    public List<Logement> findByIdMembre(@Param("x") Long keyId);

}
