package org.iths.anwar.webshopadmin.models;

public interface UI {
    // Ask user for input and return the text
    public String prompt(String message);

    // Show a message to user or for confirmation
    public void info(String message);

    // Show a menu and return user's choice
    public String menu();
}
