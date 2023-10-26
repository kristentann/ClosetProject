package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class ClosetTest {
    private Closet closet;

    @BeforeEach
    public void setUp() {
        closet = new Closet("My Closet");
    }

    @Test
    public void testAddClothingItem() {
        // Test adding clothing items to each category
        ClothingItem item1 = new ClothingItem("High Neck Cropped Tank", "White"
                , "Small", "Oak and Fort", "Tops");
        ClothingItem item2 = new ClothingItem("Maxi Skirt with back slit", "Olive green",
                "Medium", "Oak and Fort", "Bottoms");
        ClothingItem item3 = new ClothingItem("550s", "White with juniper", "8.5",
                "New Balance", "Shoes");
        ClothingItem item4 = new ClothingItem("KERWIN MAXI DRESS BLACK", "Black",
                "8.5", "Princess Polly", "Formal");
        ClothingItem item5 = new ClothingItem("Blue Double Heart Tag Pendant", "Silver",
                "Small", "Tiffany and Co", "Accessories");
        ClothingItem item6 = new ClothingItem("Slim Fit Define Jacket", "Black",
                "Medium", "Lululemon", "Jackets");

        closet.addClothingItem(item1);
        closet.addClothingItem(item2);
        closet.addClothingItem(item3);
        closet.addClothingItem(item4);
        closet.addClothingItem(item5);
        closet.addClothingItem(item6);

        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // Test adding clothing items for an occasion
        ClothingItem item7 = new ClothingItem("Shine Bustier", "Burgundy",
                "Small", "Aritzia", "Tops");

        closet.addClothingItem(item7);
        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.TOPS));

    }

    @Test
    public void testRemoveClothingItem() {
        ClothingItem item1 = new ClothingItem("High Neck Cropped Tank", "White"
                , "Small", "Oak and Fort", "TOPS");
        ClothingItem item2 = new ClothingItem("Maxi Skirt with back slit", "Olive green",
                "Medium", "Oak and Fort", "BOTTOMS");
        ClothingItem item3 = new ClothingItem("550s", "White with juniper", "8.5",
                "New Balance", "SHOES");
        ClothingItem item4 = new ClothingItem("KERWIN MAXI DRESS BLACK", "Black",
                "8.5", "Princess Polly", "FORMAL");
        ClothingItem item5 = new ClothingItem("Blue Double Heart Tag Pendant", "Silver",
                "Small", "Tiffany and Co", "ACCESSORIES");
        ClothingItem item6 = new ClothingItem("Slim Fit Define Jacket", "Black",
                "Medium", "Lululemon", "JACKETS");


        closet.addClothingItem(item1);
        closet.addClothingItem(item2);
        closet.addClothingItem(item3);
        closet.addClothingItem(item4);
        closet.addClothingItem(item5);
        closet.addClothingItem(item6);

        // TOPS:
        // Test removing item
        closet.removeClothingItem("HIGH NECK CROPPED TANK", "TOPS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // Test removing from the wrong category
        closet.removeClothingItem("Maxi Skirt with back slit", "TOPS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // BOTTOMS:
        // Test removing item
        closet.removeClothingItem("MAXI SKIRT WITH BACK SLIT", "BOTTOMS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // Test removing from the wrong category
        closet.removeClothingItem("High Neck Cropped Tank", "BOTTOMS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // SHOES:
        // Test removing item
        closet.removeClothingItem("550S", "SHOES");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // Test removing from the wrong category
        closet.removeClothingItem("High Neck Cropped Tank", "SHOES");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // FORMAL:
        // Test removing item
        closet.removeClothingItem("KERWIN MAXI DRESS BLACK", "FORMAL");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // Test removing from wrong category
        closet.removeClothingItem("KERWIN MAXI DRESS BLACK", "JACKETS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));


        // ACCESSORIES:
        // Test removing item
        closet.removeClothingItem("BLUE DOUBLE HEART TAG PENDANT", "ACCESSORIES");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // Test removing from the wrong category
        closet.removeClothingItem("High Neck Cropped Tank", "ACCESSORIES");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // JACKETS:
        // TEST REMOVING ITEM
        closet.removeClothingItem("SLIM FIT DEFINE JACKET", "JACKETS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        closet.removeClothingItem("High Neck Cropped Tank", "JACKETS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));

    }

    @Test
    public void testAddingMultipleItemsToTops() {
        ClothingItem item1 = new ClothingItem("Cropped Tank", "White", "Small",
                "Brandy Melville", "TOPS");
        ClothingItem item2 = new ClothingItem("Sleeveless Blouse", "Blue",
                "Medium", "SM", "TOPS");

        closet.addClothingItem(item1);
        closet.addClothingItem(item2);

        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));

    }

    @Test
    public void testAddingMultipleItemsToBottoms() {

        ClothingItem item3 = new ClothingItem("Maxi Skirt with back slit", "Olive green",
                "Medium", "Oak and Fort", "BOTTOMS");
        ClothingItem item4 = new ClothingItem("Denim Jeans", "Blue", "28",
                "Brand D", "BOTTOMS");


        closet.addClothingItem(item3);
        closet.addClothingItem(item4);

        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));


    }

    @Test
    public void testAddingMultipleItemsToShoes() {

        ClothingItem item3 = new ClothingItem("550s", "White with juniper", "8.5",
                "New Balance", "SHOES");
        ClothingItem item4 = new ClothingItem("Panda Jordans", "Black and White", "8.5",
                "Nike", "SHOES");

        closet.addClothingItem(item3);
        closet.addClothingItem(item4);

        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));

    }

    @Test
    public void testAddingMultipleItemsToFormal() {
        ClothingItem item4 = new ClothingItem("KERWIN MAXI DRESS BLACK", "Black",
                "8.5", "Princess Polly", "FORMAL");
        ClothingItem item5 = new ClothingItem("Maxi Satin Dress With Back Cowl", "Silver",
                "Small", "Meshki", "FORMAL");

        closet.addClothingItem(item4);
        closet.addClothingItem(item5);

        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));

    }

    @Test
    public void testAddingMultipleItemsToAccessories() {
        ClothingItem item3 = new ClothingItem("Blue Double Heart Tag Pendant", "Silver",
                "Small", "Tiffany and Co", "ACCESSORIES");
        ClothingItem item4 = new ClothingItem("Earrings", "Gold",
                "Small", "Tiffany and Co", "ACCESSORIES");

        closet.addClothingItem(item3);
        closet.addClothingItem(item4);

        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));


    }

    @Test
    public void testAddingMultipleItemsToJackets() {
        ClothingItem item3 = new ClothingItem("Slim Fit Define Jacket", "Black",
                "Medium", "Lululemon", "JACKETS");
        ClothingItem item4 = new ClothingItem("Denim Jacket", "Washed Blue",
                "Medium", "Levi's", "JACKETS");


        closet.addClothingItem(item3);
        closet.addClothingItem(item4);

        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.JACKETS));


    }


    @Test
    public void testForJacketsSoNotLast() {
        ClothingItem item1 = new ClothingItem("High Neck Cropped Tank", "White"
                , "Small", "Oak and Fort", "TOPS");
        ClothingItem item2 = new ClothingItem("Maxi Skirt with back slit", "Olive green",
                "Medium", "Oak and Fort", "BOTTOMS");
        ClothingItem item3 = new ClothingItem("550s", "White with juniper", "8.5",
                "New Balance", "SHOES");
        ClothingItem item4 = new ClothingItem("Maxi Satin Dress With Back Cowl", "Silver",
                "Small", "Meshki", "FORMAL");
        ClothingItem item5 = new ClothingItem("Slim Fit Define Jacket", "Black",
                "Medium", "Lululemon", "JACKETS");
        ClothingItem item6 = new ClothingItem("Blue Double Heart Tag Pendant", "Silver",
                "Small", "Tiffany and Co", "ACCESSORIES");

        closet.addClothingItem(item1);
        closet.addClothingItem(item2);
        closet.addClothingItem(item3);
        closet.addClothingItem(item4);
        closet.addClothingItem(item5);
        closet.addClothingItem(item6);

        // TOPS:
        // Test removing item
        closet.removeClothingItem("HIGH NECK CROPPED TANK", "TOPS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // Test removing from the wrong category
        closet.removeClothingItem("Maxi Skirt with back slit", "TOPS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // BOTTOMS:
        // Test removing item
        closet.removeClothingItem("MAXI SKIRT WITH BACK SLIT", "BOTTOMS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // Test removing from the wrong category
        closet.removeClothingItem("High Neck Cropped Tank", "BOTTOMS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // SHOES:
        // Test removing item
        closet.removeClothingItem("550S", "SHOES");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // Test removing from the wrong category
        closet.removeClothingItem("High Neck Cropped Tank", "SHOES");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // FORMAL:
        // Test removing item
        closet.removeClothingItem("MAXI SATIN DRESS WITH BACK COWL", "FORMAL");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        closet.removeClothingItem("Maxi Satin Dress With Back Cowl", "SHOES");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // ACCESSORIES:
        // Test removing item
        closet.removeClothingItem("SLIM FIT DEFINE JACKET", "JACKETS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));

        // Test removing from the wrong category
        closet.removeClothingItem("High Neck Cropped Tank", "JACKETS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));

        // JACKETS:
        // TEST REMOVING ITEM
        closet.removeClothingItem("BLUE DOUBLE HEART TAG PENDANT", "ACCESSORIES");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));

        closet.removeClothingItem("High Neck Cropped Tank", "ACCESSORIES");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));


    }

    @Test
    public void testRemovingNonExistentItem() {
        ClothingItem item1 = new ClothingItem("High Neck Cropped Tank", "White"
                , "Small", "Oak and Fort", "TOPS");
        ClothingItem item2 = new ClothingItem("Maxi Skirt with back slit", "Olive green",
                "Medium", "Oak and Fort", "BOTTOMS");
        ClothingItem item3 = new ClothingItem("550s", "White with juniper", "8.5",
                "New Balance", "SHOES");
        ClothingItem item4 = new ClothingItem("Maxi Satin Dress With Back Cowl", "Silver",
                "Small", "Meshki", "FORMAL");
        ClothingItem item5 = new ClothingItem("Blue Double Heart Tag Pendant", "Silver",
                "Small", "Tiffany and Co", "ACCESSORIES");
        ClothingItem item6 = new ClothingItem("Slim Fit Define Jacket", "Black",
                "Medium", "Lululemon", "JACKETS");


        // TOPS
        closet.addClothingItem(item1);
        closet.removeClothingItem("Hat", "TOPS");
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.TOPS));

        // BOTTOMS:
        closet.addClothingItem(item2);
        closet.removeClothingItem("Hat", "BOTTOMS");
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));

        // SHOES:
        closet.addClothingItem(item3);
        closet.removeClothingItem("Hat", "SHOES");
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.SHOES));

        // FORMAL:
        closet.addClothingItem(item4);
        closet.removeClothingItem("Hat", "FORMAL");
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));

        // Accessories:
        closet.addClothingItem(item5);
        closet.removeClothingItem("Hat", "ACCESSORIES");
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));

        // Jackets:
        closet.addClothingItem(item6);
        closet.removeClothingItem("Hat", "JACKETS");
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));


    }

    @Test
    public void testRemovingItemsFromAnEmptyCategory() {
        closet.removeClothingItem("T-shirt", "TOPS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));

        closet.removeClothingItem("Jeans", "BOTTOMS");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));

        closet.removeClothingItem("550s", "SHOES");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));

        closet.removeClothingItem("Suit", "FORMAL");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));

        closet.removeClothingItem("Hat", "ACCESSORIES");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));

        closet.removeClothingItem("Denim Jacket", "JACKET");
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));


    }

    @Test
    public void testRemovingNonExistentItemsFromACategory() {
        ClothingItem item1 = new ClothingItem("High Neck Cropped Tank", "White"
                , "Small", "Oak and Fort", "TOPS");
        ClothingItem item2 = new ClothingItem("Maxi Skirt with back slit", "Olive green",
                "Medium", "Oak and Fort", "BOTTOMS");
        ClothingItem item3 = new ClothingItem("550s", "White with juniper", "8.5",
                "New Balance", "SHOES");
        ClothingItem item4 = new ClothingItem("Maxi Satin Dress With Back Cowl", "Silver",
                "Small", "Meshki", "FORMAL");
        ClothingItem item5 = new ClothingItem("Blue Double Heart Tag Pendant", "Silver",
                "Small", "Tiffany and Co", "ACCESSORIES");
        ClothingItem item6 = new ClothingItem("Slim Fit Define Jacket", "Black",
                "Medium", "Lululemon", "JACKETS");

        closet.addClothingItem(item1);
        closet.addClothingItem(item2);
        closet.addClothingItem(item3);
        closet.addClothingItem(item4);
        closet.addClothingItem(item5);
        closet.addClothingItem(item6);

        closet.removeClothingItem("T-shirt", "TOPS");
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.TOPS));

        closet.removeClothingItem("Jeans", "BOTTOMS");
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));

        closet.removeClothingItem("550s", "SHOES");
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.SHOES));

        closet.removeClothingItem("Suit", "FORMAL");
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));

        closet.removeClothingItem("Hat", "ACCESSORIES");
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));

        closet.removeClothingItem("Denim Jacket", "JACKETS");
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

    }


    @Test
    public void testHasSimilarItem() {
        // empty
        assertFalse(closet.hasSimilarItem("Green Shirt", "Tops"));
        assertFalse(closet.hasSimilarItem("Black Jeans", "Bottoms"));
        assertFalse(closet.hasSimilarItem("550's", "Shoes"));
        assertFalse(closet.hasSimilarItem("Dress", "Formal"));
        assertFalse(closet.hasSimilarItem("Necklace", "Accessories"));
        assertFalse(closet.hasSimilarItem("Denim Jacket", "Jackets"));

        ClothingItem item1 = new ClothingItem("HIGH NECK CROPPED TANK", "White"
                , "Small", "Oak and Fort", "TOPS");
        ClothingItem item2 = new ClothingItem("MAXI SKIRT WITH BACK SLIT", "Olive green",
                "Medium", "Oak and Fort", "BOTTOMS");
        ClothingItem item3 = new ClothingItem("550S", "White with juniper", "8.5",
                "New Balance", "SHOES");
        ClothingItem item4 = new ClothingItem("Maxi Satin Dress With Back Cowl", "Silver",
                "Small", "Meshki", "Formal");
        ClothingItem item5 = new ClothingItem("Blue Double Heart Tag Pendant", "Silver",
                "Small", "Tiffany and Co", "Accessories");
        ClothingItem item6 = new ClothingItem("Slim Fit Define Jacket", "Black",
                "Medium", "Lululemon", "Jackets");


        closet.addClothingItem(item1);
        closet.addClothingItem(item2);
        closet.addClothingItem(item3);
        closet.addClothingItem(item4);
        closet.addClothingItem(item5);
        closet.addClothingItem(item6);

        // Test having a similar item in the list
        assertTrue(closet.hasSimilarItem("HIGH NECK CROPPED TANK", "TOPS"));
        assertTrue(closet.hasSimilarItem("MAXI SKIRT WITH BACK SLIT", "BOTTOMS"));
        assertTrue(closet.hasSimilarItem("550S", "SHOES"));
        assertTrue(closet.hasSimilarItem("MAXI SATIN DRESS WITH BACK COWL", "FORMAL"));
        assertTrue(closet.hasSimilarItem("BLUE DOUBLE HEART TAG PENDANT", "ACCESSORIES"));
        assertTrue(closet.hasSimilarItem("SLIM FIT DEFINE JACKET", "JACKETS"));

        // Test not having a similar item in the list
        assertFalse(closet.hasSimilarItem("Green Shirt", "Tops"));
        assertFalse(closet.hasSimilarItem("Black Jeans", "Bottoms"));
        assertFalse(closet.hasSimilarItem("Black Jeans", "Shoes"));
        assertFalse(closet.hasSimilarItem("Black Jeans", "Formal"));
        assertFalse(closet.hasSimilarItem("Black Jeans", "Accessories"));
        assertFalse(closet.hasSimilarItem("Black Jeans", "Jackets"));

    }

    @Test
    public void testNumberOfClothingInCategory() {
        // Test adding multiple clothing items to the same category
        ClothingItem item1 = new ClothingItem("High Neck Cropped Tank", "White"
                , "Small", "Oak and Fort", "Tops");
        ClothingItem item2 = new ClothingItem("FRONT ZIP MOCK NECK SCUBA TANK", "White"
                , "Small", "Oak and Fort", "Tops");
        ClothingItem item3 = new ClothingItem("Maxi Skirt with back slit", "Olive green",
                "Medium", "Oak and Fort", "Bottoms");
        ClothingItem item4 = new ClothingItem("501 90S WOMEN'S JEANS", "Medium Wash",
                "28", "Levi's", "Bottoms");


        closet.addClothingItem(item1);
        closet.addClothingItem(item2);
        closet.addClothingItem(item3);
        closet.addClothingItem(item4);

        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));

        // Test adding items to other categories
        ClothingItem item5 = new ClothingItem("550s", "White with juniper", "8.5",
                "New Balance", "Shoes");
        ClothingItem item6 = new ClothingItem("Blue Double Heart Tag Pendant", "Silver",
                "Small", "Tiffany and Co", "Accessories");

        closet.addClothingItem(item5);
        closet.addClothingItem(item6);

        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        ClothingItem item7 = new ClothingItem("Slim Fit Define Jacket", "Black",
                "Small", "Lululemon", "Jackets");

        closet.addClothingItem(item7);
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        ClothingItem item8 = new ClothingItem("Maxi Satin Dress With Back Cowl", "Silver",
                "Small", "Meshki", "Formal");

        closet.addClothingItem(item8);
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));

    }

    @Test
    public void testNumberOfClothingInCategoryAgain() {
        // empty closet
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        // duplicates

        ClothingItem item1 = new ClothingItem("HIGH NECK CROPPED TANK", "White"
                , "Small", "Oak and Fort", "TOPS");
        ClothingItem item2 = new ClothingItem("MAXI SKIRT WITH BACK SLIT", "Olive green",
                "Medium", "Oak and Fort", "BOTTOMS");
        ClothingItem item3 = new ClothingItem("550S", "White with juniper", "8.5",
                "New Balance", "SHOES");
        ClothingItem item4 = new ClothingItem("BLUE DOUBLE HEART TAG PENDANT", "Silver",
                "Small", "Tiffany and Co", "ACCESSORIES");
        ClothingItem item5 = new ClothingItem("SLIM FIT DEFINE JACKET", "Black",
                "Medium", "Lululemon", "Jackets");
        ClothingItem item6 = new ClothingItem("Maxi Satin Dress With Back Cowl", "Silver",
                "Small", "Meshki", "Formal");

        closet.addClothingItem(item1);
        closet.addClothingItem(item1);
        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.TOPS));

        closet.addClothingItem(item2);
        closet.addClothingItem(item2);
        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));


        closet.addClothingItem(item3);
        closet.addClothingItem(item3);
        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.SHOES));

        closet.addClothingItem(item4);
        closet.addClothingItem(item4);
        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));

        closet.addClothingItem(item5);
        closet.addClothingItem(item5);
        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        closet.addClothingItem(item6);
        closet.addClothingItem(item6);
        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.FORMAL));


    }

    @Test
    public void testHasSimilarItemHelper() {
        // tests with an empty category list

        LinkedList<ClothingItem> tops = new LinkedList<>();
        LinkedList<ClothingItem> bottoms = new LinkedList<>();
        LinkedList<ClothingItem> shoes = new LinkedList<>();
        LinkedList<ClothingItem> formal = new LinkedList<>();
        LinkedList<ClothingItem> accessories = new LinkedList<>();
        LinkedList<ClothingItem> jackets = new LinkedList<>();

        assertFalse(closet.hasSimilarItemHelper("Shirt", tops));
        assertFalse(closet.hasSimilarItemHelper("Jeans", bottoms));
        assertFalse(closet.hasSimilarItemHelper("Sneakers", shoes));
        assertFalse(closet.hasSimilarItemHelper("Dress", formal));
        assertFalse(closet.hasSimilarItemHelper("Necklace", accessories));
        assertFalse(closet.hasSimilarItemHelper("Bomber Jacket", jackets));


        ClothingItem item1 = new ClothingItem("HIGH NECK CROPPED TANK", "White"
                , "Small", "Oak and Fort", "TOPS");
        ClothingItem item2 = new ClothingItem("MAXI SKIRT WITH BACK SLIT", "Olive green",
                "Medium", "Oak and Fort", "BOTTOMS");
        ClothingItem item3 = new ClothingItem("550S", "White with juniper", "8.5",
                "New Balance", "SHOES");
        ClothingItem item4 = new ClothingItem("Maxi Satin Dress With Back Cowl", "Silver",
                "Small", "Meshki", "Formal");
        ClothingItem item5 = new ClothingItem("Blue Double Heart Tag Pendant", "Silver",
                "Small", "Tiffany and Co", "Accessories");
        ClothingItem item6 = new ClothingItem("Slim Fit Define Jacket", "Black",
                "Medium", "Lululemon", "Jackets");

        tops.add(item1);
        bottoms.add(item2);
        shoes.add(item3);
        formal.add(item4);
        accessories.add(item5);
        jackets.add(item6);

        // tests with different descriptions but has items inside

        assertFalse(closet.hasSimilarItemHelper("Shirt", tops));
        assertFalse(closet.hasSimilarItemHelper("Jeans", bottoms));
        assertFalse(closet.hasSimilarItemHelper("Sneakers", shoes));
        assertFalse(closet.hasSimilarItemHelper("Dress", shoes));
        assertFalse(closet.hasSimilarItemHelper("Necklace", accessories));
        assertFalse(closet.hasSimilarItemHelper("Bomber Jacket", jackets));


        // tests with the right descriptions
        assertTrue(closet.hasSimilarItemHelper("HIGH NECK CROPPED TANK", tops));
        assertTrue(closet.hasSimilarItemHelper("MAXI SKIRT WITH BACK SLIT", bottoms));
        assertTrue(closet.hasSimilarItemHelper("550S", shoes));
        assertTrue(closet.hasSimilarItemHelper("MAXI SATIN DRESS WITH BACK COWL", formal));
        assertTrue(closet.hasSimilarItemHelper("BLUE DOUBLE HEART TAG PENDANT", accessories));
        assertTrue(closet.hasSimilarItemHelper("SLIM FIT DEFINE JACKET", jackets));
    }

    // switch functions:
    @Test
    public void testAddClothingItemUnknownCategory() {
        ClothingItem unknownItem = new ClothingItem("Unknown Item", "Unknown",
                "unknown", "unknown", "unknown");

        closet.addClothingItem(unknownItem);

        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        assertEquals("UNKNOWN", unknownItem.getCategory());
    }

    @Test
    public void testNumberOfClothingInUnknownCategory() {
        ClothingItem unknownItem = new ClothingItem("Unknown Item", "Unknown",
                "unknown", "unknown", "unknown");

        closet.addClothingItem(unknownItem);

        assertNotEquals(1, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertNotEquals(1, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertNotEquals(1, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertNotEquals(1, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertNotEquals(1, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertNotEquals(1, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        ClothingItem unknownItem1 = new ClothingItem("Unknown Item 1", "Unknown",
                "unknown", "unknown", "UnknownClothing");
        ClothingItem unknownItem2 = new ClothingItem("Unknown Item 2", "Unknown",
                "unknown", "unknown", "unknown");

        closet.addClothingItem(unknownItem1);
        closet.addClothingItem(unknownItem2);

        // Verify that the items with unknown categories are not counted in any category
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.FORMAL));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.SHOES));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.JACKETS));

    }

    @Test
    public void testAddingClothingItemWithDifferentCases() {
        ClothingItem item1 = new ClothingItem("High Neck Cropped Tank", "White",
                "Small", "Oak and Fort", "tops");
        ClothingItem item2 = new ClothingItem("Front Zip Mock Neck Scuba Tank", "White",
                "Small", "Oak and Fort", "ToPs");
        closet.addClothingItem(item1);
        closet.addClothingItem(item2);

        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.TOPS));

        ClothingItem item3 = new ClothingItem("MAXI SKIRT WITH BACK SLIT", "Olive green",
                "Medium", "Oak and Fort", "BOTTOMS");
        ClothingItem item4 = new ClothingItem("90's jeans", "washed blue",
                "28", "Levis", "bOtToms");


        closet.addClothingItem(item3);
        closet.addClothingItem(item4);


        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));


        ClothingItem item5 = new ClothingItem("550S", "White with juniper", "8.5",
                "New Balance", "SHOES");
        ClothingItem item6 = new ClothingItem("Converse", "White with juniper",
                "8.5", "Converse", "ShoeS");

        closet.addClothingItem(item5);
        closet.addClothingItem(item6);

        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.SHOES));

        ClothingItem item7 = new ClothingItem("BLUE DOUBLE HEART TAG PENDANT", "Silver",
                "Small", "Tiffany and Co", "ACCESSORIES");
        ClothingItem item8 = new ClothingItem("yuh", "gold",
                "Small", "Tiffany and Co", "accEsSorieS");

        closet.addClothingItem(item7);
        closet.addClothingItem(item8);

        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.ACCESSORIES));

        ClothingItem item9 = new ClothingItem("SLIM FIT DEFINE JACKET", "Black",
                "Medium", "Lululemon", "Jackets");
        ClothingItem item10 = new ClothingItem("DEFINE JACKET", "olive green",
                "Medium", "Lululemon", "JACKETS");

        closet.addClothingItem(item9);
        closet.addClothingItem(item10);


        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.JACKETS));

        ClothingItem item11 = new ClothingItem("Maxi Satin Dress With Back Cowl", "Silver",
                "Small", "Meshki", "Formal");
        ClothingItem item12 = new ClothingItem("KERWIN MAXI DRESS BLACK", "Black",
                "8.5", "Princess Polly", "Formal");

        closet.addClothingItem(item11);
        closet.addClothingItem(item12);

        assertEquals(2, closet.numberOfClothingInCategory(ClothingType.FORMAL));

    }

    @Test
    public void testUserMadeAMistakeInInputtingItems() {
        ClothingItem item3 = new ClothingItem(" ", "White",
                "Small", "Oak and Fort", " ");
        ClothingItem item4 = new ClothingItem(" ", "White",
                "Small", "Oak and Fort", " ");


        closet.addClothingItem(item3);
        closet.addClothingItem(item4);

        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(0, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));


        ClothingItem item1 = new ClothingItem("High Neck Cropped Tank", "White",
                "Small", "Oak and Fort", "tops");
        ClothingItem item2 = new ClothingItem("High Neck Cropped Tank", "White",
                "Small", "Oak and Fort", "bottoms");

        closet.addClothingItem(item1);
        closet.addClothingItem(item2);

        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.TOPS));
        assertEquals(1, closet.numberOfClothingInCategory(ClothingType.BOTTOMS));

    }

    @Test
    public void testGetAllSameColourTops() {

        assertEquals( new LinkedList<>(), closet.getAllSameColourTops("Pink"));

        ClothingItem item1 = new ClothingItem("High Neck Cropped Tank", "White",
                "Small", "Oak and Fort", "Tops");
        ClothingItem item2 = new ClothingItem("Front Zip Mock Neck Scuba Tank", "White",
                "Small", "Oak and Fort", "ToPs");

        closet.addClothingItem(item1);
        closet.addClothingItem(item2);

        assertTrue(closet.getAllSameColourTops("WHITE").contains(item1));
        assertTrue(closet.getAllSameColourTops("WHITE").contains(item2));
        assertFalse(closet.getAllSameColourTops("WHITE").contains("Define Jacket"));

        assertFalse(closet.getAllSameColourTops("PINK").contains("High Neck Cropped Tank"));
        assertFalse(closet.getAllSameColourTops("PINK").contains("Front Zip Mock Neck Scuba Tank"));
        assertFalse(closet.getAllSameColourTops("PINK").contains("Define Jacket"));

    }


}


