package model;

public class ClothingItem {
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
}



