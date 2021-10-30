package com.ironhack.adopterservice.proxy;

import com.ironhack.adopterservice.dto.AnimalDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient("animal-service")
public interface AnimalServiceProxy {

    @GetMapping("/api/v1/animal/all")
    List<AnimalDTO> getAll();

    @GetMapping("/api/v1/animal/{id}")
    AnimalDTO getById(@PathVariable Long id);


}
