package com.example.projet_techno_web.data;

import com.example.projet_techno_web.model.Logement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogementDAO extends JpaRepository<Logement,Long> {

}
