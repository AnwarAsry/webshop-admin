package org.iths.anwar.webshopadmin;

import javax.swing.*;

public class JOptionPaneUI implements UI {
    @Override
    public String prompt(String message) {
        String input = JOptionPane.showInputDialog(null, message);
        // Checks input null so system won't crash
        if (input == null) return "";
        return input;
    }

    @Override
    public void info(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public String menu() {
        String[] options = {"1. Add product", "2. List all products", "3. Show product details", "4. Exit"};
        String choice = (String) JOptionPane.showInputDialog(
                null,
                "Choose an option",
                "Webshop Administration",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        return choice != null ? choice.substring(0, 1) : "4";
    }
}
