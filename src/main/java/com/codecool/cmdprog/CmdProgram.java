package com.codecool.cmdprog;

import com.codecool.api.Hanger;
import com.codecool.api.Wardrobe;

import java.util.Scanner;

public class CmdProgram {

    private final Scanner sc = new Scanner(System.in);

    public void run() {
        Menu mainMenu = new Menu("Main Menu - Press ", new String[]{"To create a new wardrobe", "To exit."});
        while (true) {
            mainMenu.displayMenu();
            switch (sc.nextLine()) {
                case "1":
                    System.out.println("Enter the size of the wardrobe (a number): ");
                    int size = Integer.parseInt(sc.nextLine());
                    handleWardrobe(new Wardrobe(size));
                    break;
                case "2":
                    System.out.println("Closing program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid input!");
            }
        }
    }

    private void handleWardrobe(Wardrobe wardrobe) {
        Menu menu = new Menu("Wardrobe Menu - Press ", new String[]{"To create a new hanger",
            "To create new clothing", "To put clothes in wardrobe", "To check if a piece of clothing can be stored in the wardrobe",
            "To remove a piece of clothing from the wardrobe", "To return to the main menu"});
        while (true) {
            menu.displayMenu();
            switch (sc.nextLine()) {
                case "1":
                    // create hanger method
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Invalid input!");
            }
        }

    }


}
