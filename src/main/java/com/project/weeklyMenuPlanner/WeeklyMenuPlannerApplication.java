package com.project.weeklyMenuPlanner;

import com.project.weeklyMenuPlanner.ui.MainFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class WeeklyMenuPlannerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WeeklyMenuPlannerApplication.class);
        application.setAdditionalProfiles("desktop");
        ConfigurableApplicationContext context = application.run(args);

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = context.getBean(MainFrame.class);
            mainFrame.setVisible(true);
        });
    }
}
