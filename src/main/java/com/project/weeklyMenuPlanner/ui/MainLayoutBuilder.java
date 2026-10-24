package com.project.weeklyMenuPlanner.ui;

import com.project.weeklyMenuPlanner.logic.WeekMenuService;
import com.project.weeklyMenuPlanner.logic.model.Day;
import com.project.weeklyMenuPlanner.logic.model.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Сборка главного окна: баннер, панель навигации, календарь недели и плитки блюд.
 */
@Component
@Profile("desktop")
@RequiredArgsConstructor
public class MainLayoutBuilder {

    private final WeekMenuService weekMenuService;
    private final UiProperties uiProperties;

    @Value("${app.name:Weekly Menu Planner}")
    private String appName;

    public void fillMainWindow(Container root) {
        if (root instanceof JFrame frame) {
            frame.setLayout(new BorderLayout());
        }

        root.add(buildHeaderPanel(), BorderLayout.NORTH);
        root.add(buildCenterPanel(), BorderLayout.CENTER);
    }

    private JPanel buildHeaderPanel() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel banner = new JLabel(appName, SwingConstants.CENTER);
        banner.setFont(banner.getFont().deriveFont(Font.BOLD, 22f));
        banner.setBorder(BorderFactory.createEmptyBorder(12, 8, 8, 8));
        header.add(banner);

        JPanel toolbar = new JPanel(new BorderLayout());
        toolbar.setBorder(BorderFactory.createEmptyBorder(4, 12, 8, 12));

        JPanel navigation = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        navigation.add(new JButton(UiStrings.ALL_RECIPES));
        toolbar.add(navigation, BorderLayout.WEST);

        JPanel auth = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        auth.add(new JButton(UiStrings.REGISTER));
        auth.add(new JButton(UiStrings.LOGIN));
        toolbar.add(auth, BorderLayout.EAST);

        header.add(toolbar);
        return header;
    }

    private JPanel buildCenterPanel() {
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(8, 12, 12, 12));

        GridBagConstraints gbcCalendar = new GridBagConstraints();
        gbcCalendar.gridx = 0;
        gbcCalendar.gridy = 0;
        gbcCalendar.weightx = uiProperties.getCalendarWeight();
        gbcCalendar.weighty = 1.0;
        gbcCalendar.fill = GridBagConstraints.BOTH;
        gbcCalendar.insets = new Insets(0, 0, 0, 8);
        centerPanel.add(buildCalendarPanel(), gbcCalendar);

        GridBagConstraints gbcDishes = new GridBagConstraints();
        gbcDishes.gridx = 1;
        gbcDishes.gridy = 0;
        gbcDishes.weightx = uiProperties.getDishesWeight();
        gbcDishes.weighty = 1.0;
        gbcDishes.fill = GridBagConstraints.BOTH;
        centerPanel.add(buildDishesPanel(), gbcDishes);

        return centerPanel;
    }

    private JPanel buildCalendarPanel() {
        JPanel calendar = new JPanel(new GridLayout(1, 7, 8, 8));
        calendar.setBorder(BorderFactory.createCompoundBorder(
                sectionBorder(Color.YELLOW),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        for (Day day : weekMenuService.getWeekDays()) {
            calendar.add(new DayPanel(day, cellBorder(Color.ORANGE)));
        }
        return calendar;
    }

    private JPanel buildDishesPanel() {
        int rows = uiProperties.getDishRows();
        int cols = uiProperties.getDishColumns();
        JPanel dishes = new JPanel(new GridLayout(rows, cols, 8, 8));
        dishes.setBorder(BorderFactory.createCompoundBorder(
                sectionBorder(Color.RED),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        int capacity = rows * cols;
        int index = 0;
        for (Dish dish : weekMenuService.getAvailableDishes()) {
            if (index >= capacity) {
                break;
            }
            dishes.add(new DishTile(dish, cellBorder(Color.PINK)));
            index++;
        }
        while (index < capacity) {
            dishes.add(new JPanel());
            index++;
        }
        return dishes;
    }

    private Border sectionBorder(Color debugColor) {
        if (uiProperties.isDebugBorders()) {
            return new LineBorder(debugColor, 2);
        }
        return BorderFactory.createEmptyBorder();
    }

    private Border cellBorder(Color debugColor) {
        if (uiProperties.isDebugBorders()) {
            return new LineBorder(debugColor, 1);
        }
        return BorderFactory.createLineBorder(new Color(220, 220, 220));
    }
}
