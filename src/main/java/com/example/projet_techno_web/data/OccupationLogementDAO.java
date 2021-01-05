package com.example.projet_techno_web.data;

import com.example.projet_techno_web.model.OccupationLogement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface OccupationLogementDAO extends JpaRepository<OccupationLogement,Long> {

}
