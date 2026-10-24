package com.project.weeklyMenuPlanner.ui;

public final class UiStrings {

    private UiStrings() {
    }

    public static final String ALL_RECIPES = "Все рецепты";
    public static final String REGISTER = "Зарегистрироваться";
    public static final String LOGIN = "Войти";
    public static final String DAY_PLACEHOLDER = "Перенесите блюдо";
    public static final int DISH_NAME_MAX_LENGTH = 20;

    public static String dayTitle(java.time.DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY -> "Понедельник";
            case TUESDAY -> "Вторник";
            case WEDNESDAY -> "Среда";
            case THURSDAY -> "Четверг";
            case FRIDAY -> "Пятница";
            case SATURDAY -> "Суббота";
            case SUNDAY -> "Воскресенье";
        };
    }

    public static String truncateDishName(String name) {
        if (name == null) {
            return "";
        }
        if (name.length() <= DISH_NAME_MAX_LENGTH) {
            return name;
        }
        return name.substring(0, DISH_NAME_MAX_LENGTH) + "...";
    }
}
