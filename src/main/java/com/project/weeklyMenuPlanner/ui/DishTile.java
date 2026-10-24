package com.project.weeklyMenuPlanner.ui;

import com.project.weeklyMenuPlanner.logic.model.Dish;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DishTile extends JPanel {

    public DishTile(Dish dish, Border tileBorder) {
        super(new BorderLayout(4, 4));
        setBorder(BorderFactory.createCompoundBorder(
                tileBorder,
                BorderFactory.createEmptyBorder(6, 6, 6, 6)));

        JPanel imagePlaceholder = new JPanel();
        imagePlaceholder.setBackground(new Color(240, 240, 240));
        imagePlaceholder.setPreferredSize(new Dimension(80, 80));
        add(imagePlaceholder, BorderLayout.CENTER);

        String displayName = UiStrings.truncateDishName(dish.getName());
        JLabel nameLabel = new JLabel(displayName, SwingConstants.CENTER);
        nameLabel.setToolTipText(dish.getName());
        add(nameLabel, BorderLayout.SOUTH);
    }
}
