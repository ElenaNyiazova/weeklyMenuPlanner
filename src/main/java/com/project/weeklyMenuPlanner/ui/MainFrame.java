package com.project.weeklyMenuPlanner.ui;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
@Profile("desktop")
@RequiredArgsConstructor
public class MainFrame extends JFrame {

    private final MainLayoutBuilder layoutBuilder;

    @Value("${window.width:800}")
    private int windowWidth;

    @Value("${window.height:600}")
    private int windowHeight;

    @Value("${app.name:My App}")
    private String appName;

    @PostConstruct
    private void initializeUI() {
        setTitle(appName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        layoutBuilder.fillMainWindow(this);
    }
}
