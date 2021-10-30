package com.ironhack.adopterservice.service;


import com.ironhack.adopterservice.dao.Adopter;
import com.ironhack.adopterservice.dto.AdopterDTO;
import com.ironhack.adopterservice.dto.AnimalDTO;
import com.ironhack.adopterservice.proxy.AnimalServiceProxy;
import com.ironhack.adopterservice.repository.AdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdopterService {

    @Autowired
    AdopterRepository adopterRepository;

    @Autowired
    AnimalServiceProxy animalServiceProxy;

    public List<AdopterDTO> findAll() {
        List<AdopterDTO> adoptersDTO = new ArrayList<>();
        var adopters =  adopterRepository.findAll();
        for(Adopter adopter: adopters){
            AdopterDTO adopterDTO = getAdopter(adopter);
            adoptersDTO.add(adopterDTO);
        }
        return adoptersDTO;
    }

    public AdopterDTO findById(Long id) {
        Optional<Adopter> adopter = adopterRepository.findById(id);
        if(adopter.isPresent()){
            return getAdopter(adopter.get());
        }
        return null;
    }


    public AdopterDTO getAdopter(Adopter adopter) {
        AdopterDTO adopterDTO = new AdopterDTO();
        adopterDTO.setName(adopter.getName());
        adopterDTO.setPetId(adopter.getPetId());
        return adopterDTO;
    }

    public Adopter create(AdopterDTO adopterDTO) throws Exception {
        Adopter adopter = new Adopter();
        adopter.setName(adopterDTO.getName());
        AnimalDTO animalDTO = animalServiceProxy.getById(adopterDTO.getPetId());
        if(animalDTO.isAvailable()){
            adopter.setPetId(adopterDTO.getPetId());
            adopter.setName(adopterDTO.getName());
            return adopter;
        }
        throw new Exception("Animal not available");
    }
}
