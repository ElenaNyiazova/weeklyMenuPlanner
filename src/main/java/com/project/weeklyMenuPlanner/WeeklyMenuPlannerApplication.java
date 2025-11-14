package com.project.weeklyMenuPlanner;

import com.project.weeklyMenuPlanner.config.AppConfig;
import com.project.weeklyMenuPlanner.ui.MainFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class WeeklyMenuPlannerApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Launch in EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = context.getBean(MainFrame.class);
            mainFrame.setVisible(true);
        });
    }
}
