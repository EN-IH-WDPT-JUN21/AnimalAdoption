package com.ironhack.animalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class Data implements CommandLineRunner {

    @Autowired
    AnimalRepository animalRepository;

    //private final Faker faker;

//    public Data(AnimalRepository animalRepository, Faker faker) {
//        this.animalRepository = animalRepository;
//        this.faker = faker;
//    }

    @Override
    public void run(String... args) throws Exception {
        animalRepository.saveAll(List.of(
                new Animal("Freckles","Dog",7,true),
                new Animal("Lua","Dog",1,false),
                new Animal("Baby","Cat",14,false),
                new Animal("Vinnie","Dog",5,true)
        ));

    }

//    @Override
//    public void run(String... args) {
//        String[] animalsType = {"cat","dog","hamster","rabbit"};
//        Boolean[] available = {true, false};
//        List<Animal> animals = IntStream.rangeClosed(1, 10)
//                .mapToObj(i -> new Animal(
//                        faker.name(),
//                        animalsType[faker.random().nextInt(animalsType.length)],
//                        faker.number().numberBetween(1,15),
//                        available[faker.random().nextInt(available.length)]
//                        )).collect(Collectors.toList());
//                animalRepository.saveAll(animals);
//    }
}
