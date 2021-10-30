package com.ironhack.adopterservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient("animal-service")
public interface AnimalServiceProxy {

}
