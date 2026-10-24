package com.project.weeklyMenuPlanner.logic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    private Long id;
    private String name;

    public Dish(String name) {
        this.name = name;
    }
}
