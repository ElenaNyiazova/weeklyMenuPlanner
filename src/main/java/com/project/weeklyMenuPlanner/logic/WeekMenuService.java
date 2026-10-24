package com.project.weeklyMenuPlanner.logic;

import com.project.weeklyMenuPlanner.logic.model.Day;
import com.project.weeklyMenuPlanner.logic.model.Dish;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class WeekMenuService {

    private final List<Day> weekDays = new ArrayList<>();
    private final List<Dish> availableDishes = new ArrayList<>();

    @PostConstruct
    void initDemoData() {
        weekDays.clear();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            weekDays.add(new Day(dayOfWeek));
        }

        availableDishes.clear();
        long id = 1;
        for (String name : Arrays.asList(
                "Борщ",
                "Оливье",
                "Греческий салат",
                "Сырники",
                "Плов",
                "Куриный суп",
                "Цезарь",
                "Омлет",
                "Медовик",
                "Паста карбонара",
                "Рыба на пару",
                "Голубцы",
                "Блины",
                "Харчо",
                "Рататуй"
        )) {
            availableDishes.add(new Dish(id++, name));
        }
    }

    public List<Day> getWeekDays() {
        return Collections.unmodifiableList(weekDays);
    }

    public List<Dish> getAvailableDishes() {
        return Collections.unmodifiableList(availableDishes);
    }
}
