package com.project.weeklyMenuPlanner.ui;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("desktop")
@Getter
public class UiProperties {

    @Value("${ui.calendar.weight:2}")
    private double calendarWeight;

    @Value("${ui.dishes.weight:1}")
    private double dishesWeight;

    @Value("${ui.dish.columns:3}")
    private int dishColumns;

    @Value("${ui.dish.rows:5}")
    private int dishRows;

    @Value("${ui.debug-borders:false}")
    private boolean debugBorders;
}
