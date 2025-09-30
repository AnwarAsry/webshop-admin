package org.iths.anwar.webshopadmin;

public class Main {
    public static void main(String[] args) {
        UI ui = new ConsoleUI();
        //UI ui = new JOptionPaneUI();
        ProductManager manager = new ProductManager(ui);

        manager.run();
    }
}
