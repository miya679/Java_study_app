package app.component;

import app.AppConfig;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public final class ComponentFactory {
    private ComponentFactory() {
    }

    public static JTextField createTextField() {
        JTextField textField = new JTextField(20);
        textField.setFont(createFont(16));
        textField.setSize(200, 30);
        return textField;
    }

    public static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(createFont(16));
        button.setBackground(AppConfig.BACKGROUND_COLOR);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        return button;
    }

    public static JLabel createLabel(String text, int fontSize, int horizontalAlignment) {
        JLabel label = new JLabel(text, horizontalAlignment);
        label.setFont(createFont(fontSize));
        label.setForeground(Color.BLACK);
        return label;
    }

    private static Font createFont(int size) {
        return new Font(AppConfig.FONT_NAME, Font.PLAIN, size);
    }
}
