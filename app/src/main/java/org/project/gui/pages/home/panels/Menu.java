package org.project.gui.pages.home.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    public Menu(CardLayout cardLayout,JPanel contentPanel) {
        setBackground(Color.BLUE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton menuItem1 = new JButton("Inventory");
        JButton menuItem2 = new JButton("Orders");
        JButton menuItem3 = new JButton("Products");
        JButton menuItem4 = new JButton("Store");

        menuItem1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        menuItem2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        menuItem3.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        menuItem4.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Inventory");
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Orders");
            }
        });

        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Products");
            }
        });
        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Store");
            }
        });

        add(menuItem1);
        add(menuItem2);
        add(menuItem3);
        add(menuItem4);
    }
}
