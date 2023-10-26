package persistence;

import model.Closet;
import model.ClothingItem;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Closet nameOfCloset = reader.read();
            Closet tops = reader.read();
            Closet bottoms = reader.read();
            Closet shoes = reader.read();
            Closet formal = reader.read();
            Closet accessories = reader.read();
            Closet jackets = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyCloset() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCloset.json");
        try {
            Closet closet = reader.read();
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
    void testReaderGeneralCloset() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCloset.json");
        try {
         Closet closet = reader.read();
         LinkedList<ClothingItem> tops = closet.getTops();
         LinkedList<ClothingItem> bottoms = closet.getBottoms();
         LinkedList<ClothingItem> shoes = closet.getShoes();
         LinkedList<ClothingItem> formal = closet.getFormal();
         LinkedList<ClothingItem> accessories = closet.getAccessories();
         LinkedList<ClothingItem> jackets = closet.getJackets();
         assertEquals(2, tops.size());
         assertEquals(2, bottoms.size());
         assertEquals(2, shoes.size());
         assertEquals(2, formal.size());
         assertEquals(2, accessories.size());
         assertEquals(2, jackets.size());
         assertEquals("Jackie's Closet App", closet.getNameOfCloset());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
