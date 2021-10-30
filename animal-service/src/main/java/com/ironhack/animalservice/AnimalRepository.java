package com.ironhack.animalservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Optional<Animal> findById(Long id);
    List<Animal> findByType(String type);
    List<Animal> findByAge(int age);
    List<Animal> findByTypeAndAge(String type, int age);
}
