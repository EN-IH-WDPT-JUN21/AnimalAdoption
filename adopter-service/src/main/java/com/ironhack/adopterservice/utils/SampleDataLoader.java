package com.ironhack.adopterservice.utils;

import com.ironhack.adopterservice.dao.Adopter;
import com.ironhack.adopterservice.repository.AdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SampleDataLoader implements CommandLineRunner {
    @Autowired
    AdopterRepository adopterRepository;

    @Override
    public void run(String... args) throws Exception {

        adopterRepository.saveAll(List.of(
                new Adopter("Tatiana", 3L),
                new Adopter("Sofia", 2L)));
    }
}
