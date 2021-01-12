package com.example.projet_techno_web.data;

import com.example.projet_techno_web.model.Chat;
import com.example.projet_techno_web.model.OccupationLogement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OccupationLogementDAO extends JpaRepository<OccupationLogement,Long> {


    @Query("select o from OccupationLogement o where o.idLogement = :idL ")
    public List<OccupationLogement> findByIDL(@Param("idL") long idL);
}
