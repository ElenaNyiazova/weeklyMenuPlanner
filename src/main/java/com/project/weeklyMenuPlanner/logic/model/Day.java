package com.project.weeklyMenuPlanner.logic.model;

import lombok.Getter;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Day {

    private final DayOfWeek dayOfWeek;
    private final List<Dish> dishes = new ArrayList<>();

    public Day(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<Dish> getDishesView() {
        return Collections.unmodifiableList(dishes);
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }
}
