package com.example.projet_techno_web.data;

import com.example.projet_techno_web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserUpdateDAO extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query("update User u SET u.eMail = :kEmail WHERE u.id= :x")
    void updateUserMail(@Param("kEmail") String kEmail, @Param("x") long x);

    @Transactional
    @Modifying
    @Query("update User u SET u.password = :kPW WHERE u.id= :x")
    void updateUserPW(@Param("kPW") String kPW, @Param("x") long x);

    @Transactional
    @Modifying
    @Query("update User u SET u.lName = :key WHERE u.id= :x")
    void updateUserLName(@Param("key") String key, @Param("x") long x);

    @Transactional
    @Modifying
    @Query("update User u SET u.fName = :key WHERE u.id= :x")
    void updateUserFName(@Param("key") String key, @Param("x") long x);
}


