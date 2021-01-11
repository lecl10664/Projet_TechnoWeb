package com.example.projet_techno_web.data;

import com.example.projet_techno_web.model.Chat;
import com.example.projet_techno_web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatDAO extends JpaRepository<Chat, Long> {

    @Query("select c from Chat c where c.idS = :idR AND c.idR = :idS")
    public List<Chat> findByIDs(@Param("idS") long idS, @Param("idR") long idR );

}
