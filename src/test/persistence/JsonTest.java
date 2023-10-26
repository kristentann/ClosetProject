package persistence;

import model.ClothingItem;
import model.ClothingType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkThingy(String name, ClothingType clothingType, ClothingItem clothingItem) {
        assertEquals(name, clothingItem.getDescription());
        assertEquals(clothingType, clothingItem.getCategory());
    }
}
