package ui;

import model.Closet;
import model.ClothingItem;
import model.ClothingType;
import persistence.JsonReader;
import persistence.JsonWriter;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ClosetApp {
    private static final String JSON_STORE = "./data/closetData.json";
    private Closet closet;
    private final Scanner scanner;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public ClosetApp() {
        closet = new Closet("My Closet ");
        scanner = new Scanner(System.in);
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        start();
    }

    // customises the closet by asking the users name
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void start() {
        System.out.println("Please enter your name: ");
        String userName = scanner.nextLine();

        System.out.println("Welcome to the " + userName + "'s Closet Organiser");
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addClothingItem();
                    break;
                case 2:
                    removeClothingItem();
                    break;
                case 3:
                    checkNumberOfItems();
                    break;
                case 4:
                    checkSimilarItems();
                    break;
                case 5:
                    printAllSameColourTops();
                    break;
                case 6:
                    saveCloset();
                    break;
                case 7:
                    loadCloset();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again");
            }
        }

        System.out.println("Thanks for using " + userName + "'s closet App");
    }


    // provides options for the users to know what they can use this app for
    private void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add a clothing item");
        System.out.println("2. Remove a clothing item");
        System.out.println("3. Check the number of clothing items in a category");
        System.out.println("4. Check if a similar item exists");
        System.out.println("5. Check all the tops with the same colour");
        System.out.println("6. Save Closet to file");
        System.out.println("7. Load Closet from file");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    // enables the user to add clothing to their closet
    private void addClothingItem() {
        System.out.println("Enter clothing description:");
        String description = scanner.nextLine();
        System.out.println("Enter clothing colour:");
        String colour = scanner.nextLine();
        System.out.println("Enter clothing size:");
        String size = scanner.nextLine();
        System.out.println("Enter clothing brand:");
        String brand = scanner.nextLine();
        System.out.println("Enter clothing category (Tops, Bottoms, Shoes, Formal, Accessories, Jackets):");
        String category = scanner.nextLine();

        ClothingItem item = new ClothingItem(description, colour, size, brand, category);
        closet.addClothingItem(item);
        System.out.println("Clothing item added to the closet.");
    }

    // enables users to remove clothing items from their closet
    private void removeClothingItem() {
        System.out.println("Enter clothing description to remove:");
        String description = scanner.nextLine();
        System.out.println("Enter clothing category (Tops, Bottoms, Shoes, Accessories, Jackets):");
        String category = scanner.nextLine();

        closet.removeClothingItem(description, category);
        System.out.println("Clothing item removed from the closet.");
    }

    // allows users to check the number of items inside each category then displays the amount
    private void checkNumberOfItems() {
        System.out.println("Enter category to check (Tops, Bottoms, Shoes, Accessories, Jackets):");
        String categoryStr = scanner.nextLine();
        ClothingType category = ClothingType.valueOf(categoryStr.toUpperCase());

        int count = closet.numberOfClothingInCategory(category);
        System.out.println("Number of clothing items in " + category + " category: " + count);
    }

    // allows users to see if they have similar items already in their closet
    private void checkSimilarItems() {
        System.out.println("Enter clothing description to check for similarity:");
        String description = scanner.nextLine();
        System.out.println("Enter clothing category (Tops, Bottoms, Shoes, Accessories, Jackets):");
        String category = scanner.nextLine();

        boolean hasSimilarItem = closet.hasSimilarItem(description.toUpperCase(), category);
        if (hasSimilarItem) {
            System.out.println("A similar item exists in the closet.");
        } else {
            System.out.println("No similar item found in the closet.");
        }
    }

    private void printAllSameColourTops() {
        System.out.println("Enter the colour of tops that you are looking for");
        String description = scanner.nextLine();
        //System.out.println(closet.getAllSameColourTops(description));
        for (ClothingItem c : closet.getAllSameColourTops(description.toUpperCase())) {
            System.out.println(c.getDescription());
        }
    }

    // EFFECTS: saves the closet to file
    protected void saveCloset() {
        try {
            jsonWriter.open();
            jsonWriter.write(closet);
            jsonWriter.close();
            System.out.println("Saved " + closet.getNameOfCloset() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    protected void loadCloset() {
        try {
            closet = jsonReader.read();
            System.out.println("Loaded " + closet.getNameOfCloset() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }

    }
}

