package com.ironhack.animalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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

    public List<AnimalDTO> findAll() {
        List<AnimalDTO> animalsDTO = new ArrayList<>();
        var adopters =  animalRepository.findAll();
        for(Animal animal: adopters){
            AnimalDTO animalDTO = getAnimal(animal);
            animalsDTO.add(animalDTO);
        }
        return animalsDTO;
    }

    public AnimalDTO findById(Long id) {
        Optional<Animal> adopter = animalRepository.findById(id);
        if(adopter.isPresent()){
            return getAnimal(adopter.get());
        }
        return null;
    }


    public AnimalDTO getAnimal(Animal animal) {
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setName(animal.getName());
        animalDTO.setAge(animal.getAge());
        animalDTO.setType(animal.getType());
        animalDTO.setAvailable(animal.isAvailable());
        return animalDTO;
    }

}
