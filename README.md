### Webshop Administration
This project is a Java console application built as part of a course assignment.
The goal is to demonstrate object-oriented programming (OOP) concepts in practice by developing a simple administration system for a webshop. The application is not only a webshop demo, but also a showcase of my understanding of Java and object-oriented design.
It highlights how OOP concepts can be applied to build modular, reusable, and maintainable code.

## ✨ Features
- Add new products to the webshop
- List all available products
- View detailed information about a specific product
- Data persistence with JSON

## 🛠️ Technologies & Concepts
The project is written in Java and focuses on applying fundamental OOP principles:
- Classes & Objects – to represent products
- Interfaces – to define common operations for product repositories
- Abstract classes & Inheritance – to model different types of products (e.g., digital vs. physical)
- Polymorphism – to handle multiple product types dynamically
- Method overloading – to provide flexible ways of adding products
- Jackson library - for data storing

## How to use
Inside Main.java you can choose which UI the program uses:
```
// UI ui = new ConsoleUI();   // Use console-based interface
UI ui = new JOptionPaneUI();  // Use graphical dialog interface
```

