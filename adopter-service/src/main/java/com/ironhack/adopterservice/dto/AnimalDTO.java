package com.ironhack.adopterservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDTO {
    private String name;
    private String type;
    private int age;
    private boolean available;
}
