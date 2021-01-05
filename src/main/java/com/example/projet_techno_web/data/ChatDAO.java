package com.example.projet_techno_web.data;

import com.example.projet_techno_web.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatDAO extends JpaRepository<Chat, Long> {

    @Query("select c from Chat c where c.idR= :iDR AND c.idS= :iDS")
    public List<Chat> findByIdS(@Param("iDR") Long iDR, @Param("iDS") Long iDS);

    @Query("select c from Chat c where c.idR= :iDS AND c.idS= :iDR")
    public List<Chat> findByIdR(@Param("iDR") Long iDR, @Param("iDS") Long iDS);
}
