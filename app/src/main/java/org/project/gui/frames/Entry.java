package org.project.gui.frames;

import org.project.gui.pages.login.LoginPage;
import org.project.gui.pages.register.RegisterPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Entry extends JFrame {
    public Entry() {
        setTitle("App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setMinimumSize(new Dimension(500, 400));
        addComponentListener(
                new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e){
                        int w = getWidth();
                        int h = getHeight();
                        setTitle(w+"x"+h);
                        revalidate();
                        repaint();
                    }
                }
        );
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        LoginPage loginPage = new LoginPage(this,cardLayout,cardPanel);
        RegisterPage registerPage = new RegisterPage(this,cardLayout,cardPanel);

        cardPanel.add(loginPage, "loginPage");
        cardPanel.add(registerPage, "registerPage");

        add(cardPanel);

        setVisible(true);
    }
}
