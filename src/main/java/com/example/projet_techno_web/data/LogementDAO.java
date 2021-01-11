package com.example.projet_techno_web.data;

import com.example.projet_techno_web.model.Logement;
import com.example.projet_techno_web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogementDAO extends JpaRepository<Logement,Long> {

    @Query("select l from Logement  where l.ville like :x")
    public List<Logement> findByVille(@Param("x") String keyWord);

}
