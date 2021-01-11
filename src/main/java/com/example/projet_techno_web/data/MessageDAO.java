package com.example.projet_techno_web.data;

import com.example.projet_techno_web.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDAO extends JpaRepository<Message,Long> {
}
