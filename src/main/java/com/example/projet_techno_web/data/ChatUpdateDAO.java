package com.example.projet_techno_web.data;

import com.example.projet_techno_web.model.Chat;
import com.example.projet_techno_web.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ChatUpdateDAO extends JpaRepository<Chat,Integer> {
    @Transactional
    @Modifying
    @Query("update Chat c SET c.messages = :kMessages WHERE c.id = :id")
    void updateChat(@Param("kMessages") List<Message> kMessages, @Param("id") long id);
}
