package org.project.gui.pages.home;

import org.project.gui.pages.home.panels.*;
import org.project.gui.pages.home.panels.Menu;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {
    private CardLayout cardLayout;
    private JPanel contentPanel;
    public HomePage() {
        super(new BorderLayout());
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        Menu menuPanel = new Menu(cardLayout,contentPanel);

        Inventory inventory = new Inventory();
        Orders orders = new Orders();
        Products products= new Products();
        Store store = new Store();

        contentPanel.add(inventory, "Inventory");
        contentPanel.add(orders, "Orders");
        contentPanel.add(products, "Products");
        contentPanel.add(store, "Store");

        add(menuPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }
}
