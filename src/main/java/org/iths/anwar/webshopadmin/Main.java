package org.iths.anwar.webshopadmin;

import org.iths.anwar.webshopadmin.controller.ProductManager;
import org.iths.anwar.webshopadmin.models.UI;

public class Main {
    public static void main(String[] args) {
        //UI ui = new ConsoleUI();
        UI ui = new JOptionPaneUI();
        ProductManager manager = new ProductManager(ui);

        manager.run();
    }
}
