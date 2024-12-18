package org.project.gui.frames;

import org.project.gui.pages.home.HomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Home extends JFrame {

    public Home() {
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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

        JPanel mainPanel = new HomePage();

        add(mainPanel);
        setVisible(true);
    }
}





