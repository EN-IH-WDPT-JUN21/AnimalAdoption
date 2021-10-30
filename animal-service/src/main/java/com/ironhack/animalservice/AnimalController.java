package com.ironhack.animalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/animal")
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    AnimalService animalService;

    @GetMapping("/all")
    public List<AnimalDTO> getAll(){
        return animalService.findAll();
    }

    @GetMapping("/{id}")
    public AnimalDTO getById(@PathVariable Long id){
        return animalService.findById(id);
    }

//    @GetMapping("/{type}")
//    public List<Animal> getByType(@PathVariable String type){
//        return animalRepository.findByType(type);
//    }
//
//    @GetMapping("/{age}")
//    public List<Animal> getByAge(@PathVariable int age){
//        return animalRepository.findByAge(age);
//    }

    @GetMapping
    public List<Animal> getByTypeAndAge(@RequestParam String type, @RequestParam int age){
        return animalRepository.findByTypeAndAge(type, age);
    }

    @PatchMapping("/{id}")
    public Animal changeStatus(@PathVariable Long id){
        return animalService.changeStatus(id);
    }

}
