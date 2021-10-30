package com.ironhack.adopterservice.controller;

import com.ironhack.adopterservice.dao.Adopter;
import com.ironhack.adopterservice.dto.AdopterDTO;
import com.ironhack.adopterservice.repository.AdopterRepository;
import com.ironhack.adopterservice.service.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/adopter")
public class AdopterController {
    @Autowired
    AdopterService adopterService;

    @Autowired
    AdopterRepository adopterRepository;

    @GetMapping
    public List<AdopterDTO> getAllAdopters(){
        return adopterService.findAll();
    }

    @GetMapping("/{id}")
    public AdopterDTO getAdopterbyId(@PathVariable Long id){
        return adopterService.findById(id);
    }

    @PostMapping
    public Adopter createAdopter(@RequestBody AdopterDTO adopterDTO) throws Exception {
        return adopterRepository.save(adopterService.create(adopterDTO));
    }

}
