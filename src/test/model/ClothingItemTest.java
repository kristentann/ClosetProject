package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClothingItemTest {

    @Test
    public void testClothingItemConstructorAndGetters() {
        String description = "Parachute Pants";
        String colour = "Black";
        String size = "Small";
        String brand = "Oak and Fort";
        String category = "Bottoms";

        ClothingItem item = new ClothingItem(description, colour, size, brand, category);

        assertEquals(description.toUpperCase(), item.getDescription());
        assertEquals(colour.toUpperCase(), item.getColour());
        assertEquals(brand.toUpperCase(), item.getBrand());
        assertEquals(category.toUpperCase(), item.getCategory());
    }
}