package com.codecool.cmdprog;

import com.codecool.api.*;

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
                    System.out.println("Enter the type of hanger - 'simple' or 'combination': ");
                    String type = sc.nextLine();
                    System.out.println("Enter a unique id number for the hanger: ");
                    int id = Integer.parseInt(sc.nextLine());
                    try {
                        Hanger hanger = createHanger(type, id, wardrobe);
                    } catch (NullPointerException e) {
                        System.out.println("Invalid type given, please try again.");
                    } catch (HangerAlreadyExistsException hae) {
                        System.out.println("This id is already taken, please try again.");
                    }
                    break;
                case "2":
                    // create clothing method
                    break;
                case "3":
                    // add clothing to hanger method
                    break;
                case "4":
                    System.out.println("Enter the id of the clothing to check: ");
                    try {
                        Clothing clothingToFind = wardrobe.findClothingById(sc.nextLine());
                        if (wardrobe.isSpaceFree(clothingToFind)) {
                            System.out.println("There is still space.");
                        } else {
                            System.out.println("The wardrobe is full!");
                        }
                    } catch (NoSuchClothingException e) {
                        System.out.println("Exception occurred: " + e.getMessage());
                    }

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

    private Hanger createHanger(String type, int id, Wardrobe wardrobe) throws NullPointerException, HangerAlreadyExistsException {
        for (Hanger hanger:wardrobe.getHangers()) {
            if (hanger.getId() == id) {
                throw new HangerAlreadyExistsException();
            }
        }
        if (type.equals("simple")) {
            return new SimpleHanger(id);
        } else if (type.equals("combination")) {
            return new CombinationHanger(id);
        } else {
            throw new NullPointerException();
        }
    }


}
