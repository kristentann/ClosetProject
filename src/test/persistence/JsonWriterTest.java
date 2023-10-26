package persistence;

import model.Closet;
import model.ClothingItem;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {
    @Test
    void testWriterInvalidFile() {
        try {
            Closet c = new Closet("My work room");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyCloset() {
        try {
            Closet closet = new Closet("Jackie's Closet App");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCloset.json");
            writer.open();
            writer.write(closet);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCloset.json");
            closet = reader.read();
            Closet tops = reader.read();
            Closet bottoms = reader.read();
            Closet shoes = reader.read();
            Closet formal = reader.read();
            Closet accessories = reader.read();
            Closet jackets = reader.read();
            assertEquals(0, tops.getSizeOfTops());
            assertEquals(0, bottoms.getSizeOfBottoms());
            assertEquals(0, shoes.getSizeOfShoes());
            assertEquals(0, formal.getSizeOfFormal());
            assertEquals(0, accessories.getSizeOfAccessories());
            assertEquals(0, jackets.getSizeOfJackets());
            assertEquals("Jackie's Closet App", closet.getNameOfCloset());
        } catch (IOException e) {
            // pass
        }

    }



    @Test
    void testWriterGeneralCloset() {
        try {
            JsonReader reader = new JsonReader("./data/testWriterGeneralCloset.json");
            Closet c = reader.read();

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralCloset.json");
            writer.open();
            writer.write(c);
            writer.close();

            Closet test = reader.read();
            assertEquals("Jackie's Closet App", test.getNameOfCloset());
            LinkedList<ClothingItem> tops = test.getTops();
            LinkedList<ClothingItem> bottoms = test.getBottoms();
            LinkedList<ClothingItem> shoes = test.getShoes();
            LinkedList<ClothingItem> formal = test.getFormal();
            LinkedList<ClothingItem> accessories = test.getAccessories();
            LinkedList<ClothingItem> jackets = test.getJackets();
            assertEquals(2, tops.size());
            assertEquals(2, bottoms.size());
            assertEquals(2, shoes.size());
            assertEquals(2, formal.size());
            assertEquals(2, accessories.size());
            assertEquals(2, jackets.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}

