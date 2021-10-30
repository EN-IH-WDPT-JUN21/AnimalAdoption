package com.ironhack.animalservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    private String name;
    private String type;
    private int age;
    private boolean available;
}
