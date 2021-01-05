package com.example.projet_techno_web.data;

import com.example.projet_techno_web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDAO extends JpaRepository<User, Long> {

    @Query("select u from User u where u.eMail like :x")
    public List<User> findByEMail(@Param("x") String keyWord);

    @Query("select u from User u where u.lName like :x")
    public List<User> findByLName(@Param("x") String keyWord);

}
