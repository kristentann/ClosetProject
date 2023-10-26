// Portions of this class references code from repository below
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerialization

package persistence;

import model.Closet;
import model.ClothingItem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Closet read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCloset(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // REQUIRES: jsonObj to be a valid object (non-null)
    // EFFECTS: parses closet from JSON object and returns it
    private Closet parseCloset(JSONObject jsonObject) {
        String nameOfCloset = jsonObject.getString("nameOfCloset");
        Closet c = new Closet(nameOfCloset);
        addTops(c, jsonObject);
        addBottoms(c, jsonObject);
        addShoes(c, jsonObject);
        addFormal(c, jsonObject);
        addAccessories(c, jsonObject);
        addJackets(c, jsonObject);
        return c;
    }

    // MODIFIES: c
    // EFFECTS: parse clothing item from the tops JSON array and adds it to clothing items
    private void addTops(Closet c, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("tops");
        for (Object json : jsonArray) {
            JSONObject nextTops = (JSONObject) json;
            addClothingItems(c, nextTops);
        }
    }


    // MODIFIES: c
    // EFFECTS: parse clothing item from the bottoms JSON array and adds it to clothing items
    private void addBottoms(Closet c, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("bottoms");
        for (Object json : jsonArray) {
            JSONObject nextBottoms = (JSONObject) json;
            addClothingItems(c, nextBottoms);
        }
    }


    // MODIFIES: c
    // EFFECTS: parse clothing item from the bottoms JSON array and adds it to clothing items
    private void addShoes(Closet c, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("shoes");
        for (Object json : jsonArray) {
            JSONObject nextShoes = (JSONObject) json;
            addClothingItems(c, nextShoes);
        }
    }


    // MODIFIES: c
    // EFFECTS: parse clothing item from the bottoms JSON array and adds it to clothing items
    private void addFormal(Closet c, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("formal");
        for (Object json : jsonArray) {
            JSONObject nextFormal = (JSONObject) json;
            addClothingItems(c, nextFormal);
        }
    }


    // MODIFIES: c
    // EFFECTS: parse clothing item from the accessories JSON array and adds it to clothing items
    private void addAccessories(Closet c, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("accessories");
        for (Object json : jsonArray) {
            JSONObject nextAccessories = (JSONObject) json;
            addClothingItems(c, nextAccessories);
        }
    }


    // MODIFIES: c
    // EFFECTS: parse clothing item from the accessories JSON array and adds it to clothing items
    private void addJackets(Closet c, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("jackets");
        for (Object json : jsonArray) {
            JSONObject nextJackets = (JSONObject) json;
            addClothingItems(c, nextJackets);
        }
    }


    // MODIFIES: c
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addClothingItems(Closet c, JSONObject jsonObject) {
        String description = jsonObject.getString("description");
        String colour = jsonObject.getString("colour");
        String size = jsonObject.getString("size");
        String brand = jsonObject.getString("brand");
        String category = jsonObject.getString("category");
        ClothingItem clothingItem = new ClothingItem(description, colour, size, brand,
                category);
        c.addClothingItem(clothingItem);

    }
}
