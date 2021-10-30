package com.ironhack.adopterservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient("animal-service")
public interface AnimalServiceProxy {

    @GetMapping("/api/v1/animal/all")
    List<Animal> getAll();

    @GetMapping("/api/v1/animal/{id}")
    Optional<Animal> getById(@PathVariable Long id);


    @GetMapping("/api/v1/animal/{type}/{age}")
    List<Animal> getByTypeAndAge(@PathVariable String type, @PathVariable int age);

    @PatchMapping("/{id}")
    Animal changeStatus(@PathVariable Long id);

}
