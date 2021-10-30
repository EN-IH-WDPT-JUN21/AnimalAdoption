package com.ironhack.animalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public Animal changeStatus(Long id){
        Optional<Animal> changeAnimal = animalRepository.findById(id);
        if (changeAnimal.isPresent()){
            if(changeAnimal.get().isAvailable()){
                changeAnimal.get().setAvailable(false);
            } else {
                changeAnimal.get().setAvailable(true);
            }
            animalRepository.save(changeAnimal.get());
            return changeAnimal.get();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no animal with this id");
        }
    }

}
