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
                null, // where should the popup be placed, null == put it in the middle of screen
                "Choose an option", // Label
                "Webshop Administration", // Title of the popup
                JOptionPane.QUESTION_MESSAGE, // Icon
                null, // Custom picture/icon
                options, // The choices
                options[0] // When popup is open select the first choice
        );
        // choice will be the full string like for example: "1. Add product"
        // substring is to only take the digit
        return choice != null ? choice.substring(0, 1) : "4";
    }
}
