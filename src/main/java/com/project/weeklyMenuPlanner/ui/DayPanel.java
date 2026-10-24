package com.project.weeklyMenuPlanner.ui;

import com.project.weeklyMenuPlanner.logic.model.Day;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DayPanel extends JPanel {

    public DayPanel(Day day, Border panelBorder) {
        super(new BorderLayout(4, 4));
        setBorder(BorderFactory.createCompoundBorder(
                panelBorder,
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        JLabel title = new JLabel(UiStrings.dayTitle(day.getDayOfWeek()), SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD));
        add(title, BorderLayout.NORTH);

        JPanel body = new JPanel(new BorderLayout());
        if (day.getDishesView().isEmpty()) {
            JLabel placeholder = new JLabel(UiStrings.DAY_PLACEHOLDER, SwingConstants.CENTER);
            placeholder.setForeground(Color.GRAY);
            body.add(placeholder, BorderLayout.CENTER);
        } else {
            DefaultListModel<String> model = new DefaultListModel<>();
            day.getDishesView().forEach(dish -> model.addElement(dish.getName()));
            body.add(new JScrollPane(new JList<>(model)), BorderLayout.CENTER);
        }
        add(body, BorderLayout.CENTER);
    }
}
