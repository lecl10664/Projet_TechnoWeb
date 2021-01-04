package com.example.projet_techno_web.repo;

import com.example.projet_techno_web.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepo extends JpaRepository<Home,Long> {

}
