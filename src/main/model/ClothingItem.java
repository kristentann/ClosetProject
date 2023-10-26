package model;

import org.json.JSONObject;
import persistence.Writable;

public class ClothingItem implements Writable {
    private String description;
    private String colour;
    private String size;
    private String brand;
    private String category;

    //EFFECT: description is set to clothingDescription,
    // colour is set to clothingColour, size is set to
    // clothingSize, brand is set to clothingBrand
    public ClothingItem(String clothingDescription, String clothingColour, String clothingSize, String clothingBrand,
                        String clothingCategory) {
        description = clothingDescription.toUpperCase();
        colour = clothingColour.toUpperCase();
        size = clothingSize.toUpperCase();
        brand = clothingBrand.toUpperCase();
        category = clothingCategory.toUpperCase();
    }

    // getter functions for ClothingItem
    public String getDescription() {

        return description;
    }

    public String getColour() {

        return colour;
    }

    public String getSize() {

        return size;
    }

    public String getBrand() {

        return brand;
    }

    public String getCategory() {

        return category;
    }

    // EFFECTS: converts the clothingItem components into a JSON object, then returns it
    @Override
    public JSONObject toJson() {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("description", this.description);
        jsonObj.put("colour", this.colour);
        jsonObj.put("size", this.size);
        jsonObj.put("brand", this.brand);
        jsonObj.put("category", this.category);

        return jsonObj;
    }
}



