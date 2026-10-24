package com.project.weeklyMenuPlanner.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Создаёт и показывает главное окно на EDT. Не наследует {@link JFrame}, чтобы Spring
 * мог создать бин без инициализации AWT (headless-safe до вызова {@link #open()}).
 */
@Component
@Profile("desktop")
@RequiredArgsConstructor
public class MainFrame {

    private final MainLayoutBuilder layoutBuilder;

    @Value("${window.width:800}")
    private int windowWidth;

    @Value("${window.height:600}")
    private int windowHeight;

    @Value("${app.name:My App}")
    private String appName;

    public void open() {
        if (GraphicsEnvironment.isHeadless()) {
            throw new IllegalStateException(
                    "Графическая среда недоступна (headless). Запустите приложение с -Djava.awt.headless=false");
        }
        SwingUtilities.invokeLater(this::createAndShow);
    }

    private void createAndShow() {
        JFrame frame = new JFrame(appName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);
        frame.setLocationRelativeTo(null);
        layoutBuilder.fillMainWindow(frame);
        frame.setVisible(true);
    }
}
