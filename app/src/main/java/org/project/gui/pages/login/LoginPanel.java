package org.project.gui.pages.login;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    public LoginPanel(CardLayout cardLayout, JPanel cardPanel) {
        setBackground(Color.BLUE);
        setLayout(null);

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 24));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(150, 30));

        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 30));

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "homePage");
        });

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "registerPage");
        });

        loginLabel.setBounds(90, 20, 150, 40);
        emailLabel.setBounds(50, 80, 120, 30);
        emailField.setBounds(170, 80, 150, 30);
        passwordLabel.setBounds(50, 125, 120, 30);
        passwordField.setBounds(170, 125, 150, 30);
        loginButton.setBounds(75, 180, 100, 40);
        registerButton.setBounds(195, 180, 100, 40);

        add(loginLabel);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registerButton);


        setPreferredSize(new Dimension(370, 300));
    }
}
