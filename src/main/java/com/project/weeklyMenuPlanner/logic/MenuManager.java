package com.project.weeklyMenuPlanner.logic;

import com.project.weeklyMenuPlanner.ui.MainFrame;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

/**
 * Класс управляющий созданием всех меню и панелей, т.е. Визуальной частью.
 * */
@Component
public class MenuManager {

    /**
     *         // Загрузить данные в оба меню в середине.
     * 4. Должен получиться лист дней недели в каждом из которых хранится лист блюд.
     * 5. Все хранится пока в списках, позже можно хранить данные в локальном файле и парсить его или в базе данныхю
     * */

    public void fillMainWindow(MainFrame mainFrame) {
        // Верхнее меню
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBorder(new BorderUIResource.EmptyBorderUIResource(2, 250, 2, 2));
        topPanel.add(new JButton("Все рецепты"));
        topPanel.add(new JButton("Войти/Регистрация"));
        mainFrame.add(topPanel, BorderLayout.PAGE_START);

        // Центральное меню
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(new LineBorder(Color.BLUE, 2));

        // CalendarMenu
        GridBagConstraints gbcCalendar = new GridBagConstraints();
        gbcCalendar.gridx = 0;
        gbcCalendar.gridy = 0;
        gbcCalendar.weightx = 2.0;
        gbcCalendar.weighty = 1.0;
        gbcCalendar.fill = GridBagConstraints.BOTH;

        JPanel calendarMenu = new JPanel();
        calendarMenu.setBorder(new LineBorder(Color.YELLOW, 2));
        centerPanel.add(calendarMenu, gbcCalendar);

        // DishesMenu
        GridBagConstraints gbcDishes = new GridBagConstraints();
        gbcDishes.gridx = 1;
        gbcDishes.gridy = 0;
        gbcDishes.weightx = 1.0;
        gbcDishes.weighty = 1.0;
        gbcDishes.fill = GridBagConstraints.BOTH;

        JPanel dishesMenu = new JPanel(new GridLayout(5, 3));
        dishesMenu.setBorder(new LineBorder(Color.RED, 2));
        centerPanel.add(dishesMenu, gbcDishes);

        mainFrame.add(centerPanel, BorderLayout.CENTER);

        // Нижнеее меню
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.setBorder(new LineBorder(Color.CYAN, 2));
        bottomPanel.add(new JButton("Button"));
        bottomPanel.add(new JButton("Button"));
        bottomPanel.add(new JButton("Button"));
        bottomPanel.add(new JButton("Button"));
        mainFrame.add(bottomPanel, BorderLayout.PAGE_END);
    }
}
