package com.example.projet_techno_web.data;

import com.example.projet_techno_web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserUpdateDAO extends JpaRepository<User, Integer> {
    @Modifying
    @Query("update User u SET u.eMail = :kEmail WHERE u.id= :x")
    int updateUser(@Param("kEmail") String kEmail, @Param("x") long x);
}


