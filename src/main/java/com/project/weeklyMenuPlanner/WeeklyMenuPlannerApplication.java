package com.project.weeklyMenuPlanner;

import com.project.weeklyMenuPlanner.ui.MainFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WeeklyMenuPlannerApplication {

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");

        SpringApplication application = new SpringApplication(WeeklyMenuPlannerApplication.class);
        application.setAdditionalProfiles("desktop");
        ConfigurableApplicationContext context = application.run(args);

        context.getBean(MainFrame.class).open();
    }
}
