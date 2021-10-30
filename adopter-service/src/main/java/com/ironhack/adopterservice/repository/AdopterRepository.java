package com.ironhack.adopterservice.repository;

import com.ironhack.adopterservice.dao.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdopterRepository extends JpaRepository<Adopter, Long> {

    Optional<Adopter> findById(Long id);
    List<Adopter> findAll();
}
