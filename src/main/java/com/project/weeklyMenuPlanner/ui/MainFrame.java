package com.project.weeklyMenuPlanner.ui;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainFrame extends JFrame {

    @Value("${window.width:400}")
    private int windowWidth;

    @Value("${window.height:200}")
    private int windowHeight;

    @Value("${app.name:My App}")
    private String appName;

    @Autowired
    public MainFrame() {
    }

    @PostConstruct
    private void initializeUI() {
        setTitle(appName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Hello World!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        add(label, BorderLayout.CENTER);
    }
}
