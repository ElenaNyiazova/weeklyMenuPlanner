package com.project.weeklyMenuPlanner.ui;

import com.project.weeklyMenuPlanner.logic.MenuManager;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainFrame extends JFrame {

    @Value("${window.width:800}")
    private int windowWidth;

    @Value("${window.height:600}")
    private int windowHeight;

    @Value("${app.name:My App}")
    private String appName;

    @Autowired
    private MenuManager menuManager;

    @Autowired
    public MainFrame() {
    }

    @PostConstruct
    private void initializeUI() {
        setTitle(appName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        menuManager.fillMainWindow(this);
    }
}
