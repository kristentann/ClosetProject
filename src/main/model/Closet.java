package model;

import java.util.LinkedList;
import java.util.Objects;

public class Closet {

    private final String clothingDescription;
    private final LinkedList<ClothingItem> tops;
    private final LinkedList<ClothingItem> bottoms;
    private final LinkedList<ClothingItem> shoes;
    private final LinkedList<ClothingItem> formal;
    private final LinkedList<ClothingItem> accessories;
    private final LinkedList<ClothingItem> jackets;

    public Closet(String clothingDescription) {

        this.clothingDescription = clothingDescription;
        this.tops = new LinkedList<>();
        this.bottoms = new LinkedList<>();
        this.shoes = new LinkedList<>();
        this.formal = new LinkedList<>();
        this.accessories = new LinkedList<>();
        this.jackets = new LinkedList<>();
    }


    // sourced from library.java (abstraction practice projects)
    // REQUIRES: category has to be one of the categories
    // written below and must be uppercase
    // MODIFIES: this
    // EFFECTS: adds a new item of clothing to the closet
    public void addClothingItem(ClothingItem item) {
        ClothingItem item1 = item;

        switch (item1.getCategory()) {
            case "TOPS":
                tops.add(item);
                break;
            case "BOTTOMS":
                bottoms.add(item);
                break;
            case "SHOES":
                shoes.add(item);
                break;
            case "FORMAL":
                formal.add(item);
                break;
            case "ACCESSORIES":
                accessories.add(item);
                break;
            case "JACKETS":
                jackets.add(item);
                break;
            default:
                break;
        }
    }

    // MODIFIES: this
    // EFFECTS: removes a new item of clothing to the closet by description
    public void removeClothingItem(String description, String category) {
        if (category.equals("Tops")) {
            removeClothingItemHelper(description, tops);
        } else if (category.equals("Bottoms")) {
            removeClothingItemHelper(description, bottoms);
        } else if (category.equals("Shoes")) {
            removeClothingItemHelper(description, shoes);
        } else if (category.equals("Formal")) {
            removeClothingItemHelper(description, formal);
        } else if (category.equals("Accessories")) {
            removeClothingItemHelper(description, accessories);
        } else if (category.equals("Jackets")) {
            removeClothingItemHelper(description, jackets);
        }
    }

    // EFFECTS: it removes clothing item from a given list
    @SuppressWarnings({"checkstyle:NeedBraces", "checkstyle:SuppressWarnings"})
    public void removeClothingItemHelper(String description, LinkedList<ClothingItem> category) {
        for (ClothingItem c : category)
            if (c.getDescription().contentEquals(description)) {
                category.remove(c);
            }
    }


    // sourced from librarySystem.java (data abstraction problem)
    // MODIFIES: this
    // EFFECT: returns the number of clothing in each category
    public int numberOfClothingInCategory(ClothingType category) {

        int number = 0;

        switch (category) {
            case TOPS:
                number = tops.size();
                break;
            case BOTTOMS:
                number = bottoms.size();
                break;
            case SHOES:
                number = shoes.size();
                break;
            case FORMAL:
                number = formal.size();
                break;
            case ACCESSORIES:
                number = accessories.size();
                break;
            default:
                number = jackets.size();
                break;
        }
        return number;
    }


    // EFFECTS: returns true if user has similar item in list,
    //  returns false if user does not have similar item in list.
    public boolean hasSimilarItem(String description, String category) {
        boolean result = false;

        if (category.equals("TOPS")) {
            result = hasSimilarItemHelper(description, tops);
        } else if (category.equals("BOTTOMS")) {
            result = hasSimilarItemHelper(description, bottoms);
        } else if (category.equals("SHOES")) {
            result = hasSimilarItemHelper(description, shoes);
        } else if (category.equals("FORMAL")) {
            result = hasSimilarItemHelper(description, formal);
        } else if (category.equals("ACCESSORIES")) {
            result = hasSimilarItemHelper(description, accessories);
        } else if (category.equals("JACKETS")) {
            result = hasSimilarItemHelper(description, jackets);
        }

        return result;
    }


    // EFFECTS: helper function
    public boolean hasSimilarItemHelper(String description, LinkedList<ClothingItem> category) {
        for (ClothingItem c : category) {
            if (c.getDescription().contentEquals(description)) {
                return true;
            }

        }
        return false;
    }

    // EFFECTS: returns a list of all the tops with the certain colour
    public LinkedList<ClothingItem> getAllSameColourTops(String colour) {


        LinkedList<ClothingItem> sameColourTops = new LinkedList<>();

        for (ClothingItem c : tops) {
            if (c.getColour().equals(colour)) {
                sameColourTops.add(c);
            }
        }
        System.out.println(sameColourTops);
        return sameColourTops;
    }

}