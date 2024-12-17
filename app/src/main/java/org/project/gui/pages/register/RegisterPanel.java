package org.project.gui.pages.register;

import javax.swing.*;
import java.awt.*;

public class RegisterPanel extends JPanel {

    public RegisterPanel(CardLayout cardLayout, JPanel cardPanel) {
        setBackground(Color.BLUE);
        setLayout(null);

        JLabel registerLabel = new JLabel("Register");
        registerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(150, 30));

        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 30));

        JLabel confirmPasswordLabel = new JLabel("Confirm Password");
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setPreferredSize(new Dimension(150, 30));



        JButton backTologinButton = new JButton("Back to Login");
        backTologinButton.setFont(new Font("Arial", Font.BOLD, 14));
        backTologinButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "loginPage");
        });

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "registerPage");
        });

        registerLabel.setBounds(90, 20, 150, 40);
        emailLabel.setBounds(50, 80, 120, 30);
        emailField.setBounds(170, 80, 150, 30);
        passwordLabel.setBounds(50, 125, 120, 30);
        passwordField.setBounds(170, 125, 150, 30);
        confirmPasswordLabel.setBounds(50, 170, 120, 30);
        confirmPasswordField.setBounds(170, 170, 150, 30);
        backTologinButton.setBounds(55, 225, 140, 40);
        registerButton.setBounds(215, 225, 100, 40);

        add(registerLabel);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(backTologinButton);
        add(registerButton);


        setPreferredSize(new Dimension(370, 300));
    }
}
