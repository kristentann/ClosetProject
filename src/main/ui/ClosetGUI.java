package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLOutput;

public class ClosetGUI extends JFrame {

    private JButton addClothingItemButton;
    private JButton removeClothingItemButton;
    private JButton similarItemButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton topsButton;
    private JButton bottomsButton;
    private JButton shoesButton;
    private JButton formalButton;
    private JButton accessoriesButton;
    private JButton jacketsButton;

    private JTextField description;
    private JTextField colour;
    private JTextField size;
    private JTextField brand;
    private JTextField category;

    private JPanel addPanel;
    private JPanel removePanel;
    private JPanel similarPanel;
    private JPanel savePanel;
    private JPanel loadPanel;

    private JPanel topsPanel;
    private JPanel bottomsPanel;
    private JPanel shoesPanel;
    private JPanel formalPanel;
    private JPanel accessoriesPanel;
    private JPanel jacketsPanel;

    private Closet closet = new Closet("My Closet");
    private ClosetApp closetApp;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    public static final String JSON_STORE = "./data/closetData.json";

    // EFFECTS: creates instance of ClosetApp then creates the GUI
    public ClosetGUI() {
        super("Closet Organiser");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        description = new JTextField();
        colour = new JTextField();
        size = new JTextField();
        brand = new JTextField();
        category = new JTextField();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(5000, 3000));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(227, 203, 187));

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
            }
        });

        createMainFrame();
    }

    // EFFECTS: calls helpers to make GUI
    public void createMainFrame() {
//        addHeaderPanel();
        makeFunctionalButtons();
        makeClosetCategoryButtons();
        buttonFunctionalityFunctions();
        buttonCategoryFunctions();
        makeClosetPanels();

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        this.setVisible(true);
    }

    // EFFECTS: create functional buttons
    private void makeFunctionalButtons() {

        addClothingItemButton = new JButton();
        removeClothingItemButton = new JButton();
        similarItemButton = new JButton();
        saveButton = new JButton();
        loadButton = new JButton();

        setBoundsForFunctionButtons();
        setTextAndFontsForFunctionButtons();

        this.add(addClothingItemButton);
        this.add(removeClothingItemButton);
        this.add(similarItemButton);
        this.add(saveButton);
        this.add(loadButton);
    }

    private void setTextAndFontsForFunctionButtons() {
        addClothingItemButton.setText("Add Item");
        addClothingItemButton.setFont(new Font("Comic Sans", Font.BOLD,20));
        removeClothingItemButton.setText("Remove Item");
        removeClothingItemButton.setFont(new Font("Comic Sans", Font.BOLD,20));
        similarItemButton.setText("Similar Item?");
        similarItemButton.setFont(new Font("Comic Sans", Font.BOLD,20));
        saveButton.setText("Save Closet");
        saveButton.setFont(new Font("Comic Sans", Font.BOLD,20));
        loadButton.setText("Load Closet");
        loadButton.setFont(new Font("Comic Sans", Font.BOLD,20));
    }

    private void setBoundsForFunctionButtons() {
        addClothingItemButton.setBounds(50, 150, 200,100);
        removeClothingItemButton.setBounds(50, 250, 200, 100);
        similarItemButton.setBounds(50, 350,200,100);
        saveButton.setBounds(50,450,200,100);
        loadButton.setBounds(50,550,200,100);
    }

    // EFFECTS: create category buttons
    private void makeClosetCategoryButtons() {

        topsButton = new JButton();
        bottomsButton = new JButton();
        shoesButton = new JButton();
        formalButton = new JButton();
        accessoriesButton = new JButton();
        jacketsButton = new JButton();

        setBoundsForButtons();
        setTextAndFontsForButtons();

        this.add(topsButton);
        this.add(bottomsButton);
        this.add(shoesButton);
        this.add(formalButton);
        this.add(accessoriesButton);
        this.add(jacketsButton);
    }

    private void setTextAndFontsForButtons() {
        topsButton.setText("TOPS");
        topsButton.setFont(new Font("Comic Sans", Font.BOLD,20));
        bottomsButton.setText("BOTTOMS");
        bottomsButton.setFont(new Font("Comic Sans", Font.BOLD,20));
        shoesButton.setText("SHOES");
        shoesButton.setFont(new Font("Comic Sans", Font.BOLD,20));
        formalButton.setText("FORMAL");
        formalButton.setFont(new Font("Comic Sans", Font.BOLD,20));
        accessoriesButton.setText("ACCESSORIES");
        accessoriesButton.setFont(new Font("Comic Sans", Font.BOLD,20));
        jacketsButton.setText("JACKETS");
        jacketsButton.setFont(new Font("Comic Sans", Font.BOLD,20));
    }

    private void setBoundsForButtons() {
        topsButton.setBounds(150, 0, 200, 50);
        bottomsButton.setBounds(345,0,200,50);
        shoesButton.setBounds(540,0,200,50);
        formalButton.setBounds(735,0,200,50);
        accessoriesButton.setBounds(930,0,200,50);
        jacketsButton.setBounds(1125,0,200,50);
    }

    // EFFECTS: adds functionality to buttons for the functions
    private void buttonFunctionalityFunctions() {
        String descriptionClo = description.getText();
        String colourClo = colour.getText();
        String sizeClo = size.getText();
        String brandClo = brand.getText();
        String categoryClo = category.getText();

        ClothingItem item = new ClothingItem(descriptionClo, colourClo, sizeClo, brandClo, categoryClo);
        addClothingItemButtonFunction(item);
        removeClothingItemButtonFunction(descriptionClo, categoryClo);
        similarItemButtonFunction(descriptionClo, categoryClo);
        saveButtonFunction();
        loadButtonFunction();
    }

    private void loadButtonFunction() {
        loadButton.addActionListener(e -> closetApp.loadCloset());

        loadButton.addActionListener(e -> loadPanel.setVisible(true));
        loadButton.addActionListener(e -> addPanel.setVisible(false));
        loadButton.addActionListener(e -> removePanel.setVisible(false));
        loadButton.addActionListener(e -> similarPanel.setVisible(false));
        loadButton.addActionListener(e -> savePanel.setVisible(false));
        loadButton.addActionListener(e -> topsPanel.setVisible(false));
        loadButton.addActionListener(e -> bottomsPanel.setVisible(false));
        loadButton.addActionListener(e -> shoesPanel.setVisible(false));
        loadButton.addActionListener(e -> formalPanel.setVisible(false));
        loadButton.addActionListener(e -> accessoriesPanel.setVisible(false));
        loadButton.addActionListener(e -> jacketsPanel.setVisible(false));
    }

    private void saveButtonFunction() {
        saveButton.addActionListener(e -> closetApp.saveCloset());
        saveButton.addActionListener(e -> savePanel.setVisible(true));
        saveButton.addActionListener(e -> addPanel.setVisible(false));
        saveButton.addActionListener(e -> removePanel.setVisible(false));
        saveButton.addActionListener(e -> similarPanel.setVisible(false));
        saveButton.addActionListener(e -> loadPanel.setVisible(false));
        saveButton.addActionListener(e -> topsPanel.setVisible(false));
        saveButton.addActionListener(e -> bottomsPanel.setVisible(false));
        saveButton.addActionListener(e -> shoesPanel.setVisible(false));
        saveButton.addActionListener(e -> formalPanel.setVisible(false));
        saveButton.addActionListener(e -> accessoriesPanel.setVisible(false));
        saveButton.addActionListener(e -> jacketsPanel.setVisible(false));
    }

    private void similarItemButtonFunction(String descriptionClo, String categoryClo) {
        similarItemButton.addActionListener(e -> closet.hasSimilarItem(descriptionClo, categoryClo));

        similarItemButton.addActionListener(e -> similarPanel.setVisible(true));
        similarItemButton.addActionListener(e -> addPanel.setVisible(false));
        similarItemButton.addActionListener(e -> removePanel.setVisible(false));
        similarItemButton.addActionListener(e -> savePanel.setVisible(false));
        similarItemButton.addActionListener(e -> loadPanel.setVisible(false));
        similarItemButton.addActionListener(e -> topsPanel.setVisible(false));
        similarItemButton.addActionListener(e -> bottomsPanel.setVisible(false));
        similarItemButton.addActionListener(e -> shoesPanel.setVisible(false));
        similarItemButton.addActionListener(e -> formalPanel.setVisible(false));
        similarItemButton.addActionListener(e -> accessoriesPanel.setVisible(false));
        similarItemButton.addActionListener(e -> jacketsPanel.setVisible(false));
    }

    private void removeClothingItemButtonFunction(String descriptionClo, String categoryClo) {
        removeClothingItemButton.addActionListener(e -> closet.removeClothingItem(descriptionClo, categoryClo));
        removeClothingItemButton.addActionListener(e -> removePanel.setVisible(true));
        removeClothingItemButton.addActionListener(e -> addPanel.setVisible(false));
        removeClothingItemButton.addActionListener(e -> similarPanel.setVisible(false));
        removeClothingItemButton.addActionListener(e -> savePanel.setVisible(false));
        removeClothingItemButton.addActionListener(e -> loadPanel.setVisible(false));
        removeClothingItemButton.addActionListener(e -> topsPanel.setVisible(false));
        removeClothingItemButton.addActionListener(e -> bottomsPanel.setVisible(false));
        removeClothingItemButton.addActionListener(e -> shoesPanel.setVisible(false));
        removeClothingItemButton.addActionListener(e -> formalPanel.setVisible(false));
        removeClothingItemButton.addActionListener(e -> accessoriesPanel.setVisible(false));
        removeClothingItemButton.addActionListener(e -> jacketsPanel.setVisible(false));
    }

    private void addClothingItemButtonFunction(ClothingItem item) {
//        addClothingItemButton.addActionListener(e -> closet.addClothingItem(item));

        addClothingItemButton.addActionListener(e -> addPanel.setVisible(true));
        addClothingItemButton.addActionListener(e -> removePanel.setVisible(false));
        addClothingItemButton.addActionListener(e -> similarPanel.setVisible(false));
        addClothingItemButton.addActionListener(e -> savePanel.setVisible(false));
        addClothingItemButton.addActionListener(e -> loadPanel.setVisible(false));
        addClothingItemButton.addActionListener(e -> topsPanel.setVisible(false));
        addClothingItemButton.addActionListener(e -> bottomsPanel.setVisible(false));
        addClothingItemButton.addActionListener(e -> shoesPanel.setVisible(false));
        addClothingItemButton.addActionListener(e -> formalPanel.setVisible(false));
        addClothingItemButton.addActionListener(e -> accessoriesPanel.setVisible(false));
        addClothingItemButton.addActionListener(e -> jacketsPanel.setVisible(false));
    }

    // EFFECTS: adds functionality to buttons for the categories
    private void buttonCategoryFunctions() {
        ClothingType categoryTops = ClothingType.valueOf("TOPS");
        ClothingType categoryBottoms = ClothingType.valueOf("BOTTOMS");
        ClothingType categoryShoes = ClothingType.valueOf("SHOES");
        ClothingType categoryFormal = ClothingType.valueOf("FORMAL");
        ClothingType categoryAccessories = ClothingType.valueOf("ACCESSORIES");
        ClothingType categoryJackets = ClothingType.valueOf("JACKETS");

        topsButtonFunction(categoryTops);
        bottomsButtonFunction(categoryBottoms);
        shoesButtonFunction(categoryShoes);
        formalButtonFunction(categoryFormal);
        accessoriesButtonFunction(categoryAccessories);
        jacketsButtonFunction(categoryJackets);
    }

    private void jacketsButtonFunction(ClothingType categoryJackets) {
        jacketsButton.addActionListener(e -> closet.numberOfClothingInCategory(categoryJackets));
        jacketsButton.addActionListener(e -> jacketsPanel.setVisible(true));
        jacketsButton.addActionListener(e -> addPanel.setVisible(false));
        jacketsButton.addActionListener(e -> removePanel.setVisible(false));
        jacketsButton.addActionListener(e -> similarPanel.setVisible(false));
        jacketsButton.addActionListener(e -> savePanel.setVisible(false));
        jacketsButton.addActionListener(e -> loadPanel.setVisible(false));
        jacketsButton.addActionListener(e -> topsPanel.setVisible(false));
        jacketsButton.addActionListener(e -> bottomsPanel.setVisible(false));
        jacketsButton.addActionListener(e -> shoesPanel.setVisible(false));
        jacketsButton.addActionListener(e -> formalPanel.setVisible(false));
        jacketsButton.addActionListener(e -> accessoriesPanel.setVisible(false));
    }

    private void accessoriesButtonFunction(ClothingType categoryAccessories) {
        accessoriesButton.addActionListener(e -> closet.numberOfClothingInCategory(categoryAccessories));
        accessoriesButton.addActionListener(e -> accessoriesPanel.setVisible(true));
        accessoriesButton.addActionListener(e -> addPanel.setVisible(false));
        accessoriesButton.addActionListener(e -> removePanel.setVisible(false));
        accessoriesButton.addActionListener(e -> similarPanel.setVisible(false));
        accessoriesButton.addActionListener(e -> savePanel.setVisible(false));
        accessoriesButton.addActionListener(e -> loadPanel.setVisible(false));
        accessoriesButton.addActionListener(e -> topsPanel.setVisible(false));
        accessoriesButton.addActionListener(e -> bottomsPanel.setVisible(false));
        accessoriesButton.addActionListener(e -> shoesPanel.setVisible(false));
        accessoriesButton.addActionListener(e -> formalPanel.setVisible(false));
        accessoriesButton.addActionListener(e -> jacketsPanel.setVisible(false));
    }

    private void formalButtonFunction(ClothingType categoryFormal) {
        formalButton.addActionListener(e -> closet.numberOfClothingInCategory(categoryFormal));
        formalButton.addActionListener(e -> formalPanel.setVisible(true));
        formalButton.addActionListener(e -> addPanel.setVisible(false));
        formalButton.addActionListener(e -> removePanel.setVisible(false));
        formalButton.addActionListener(e -> similarPanel.setVisible(false));
        formalButton.addActionListener(e -> savePanel.setVisible(false));
        formalButton.addActionListener(e -> loadPanel.setVisible(false));
        formalButton.addActionListener(e -> topsPanel.setVisible(false));
        formalButton.addActionListener(e -> bottomsPanel.setVisible(false));
        formalButton.addActionListener(e -> shoesPanel.setVisible(false));
        formalButton.addActionListener(e -> accessoriesPanel.setVisible(false));
        formalButton.addActionListener(e -> jacketsPanel.setVisible(false));
    }

    private void shoesButtonFunction(ClothingType categoryShoes) {
        shoesButton.addActionListener(e -> closet.numberOfClothingInCategory(categoryShoes));
        shoesButton.addActionListener(e -> shoesPanel.setVisible(true));
        shoesButton.addActionListener(e -> addPanel.setVisible(false));
        shoesButton.addActionListener(e -> removePanel.setVisible(false));
        shoesButton.addActionListener(e -> similarPanel.setVisible(false));
        shoesButton.addActionListener(e -> savePanel.setVisible(false));
        shoesButton.addActionListener(e -> loadPanel.setVisible(false));
        shoesButton.addActionListener(e -> topsPanel.setVisible(false));
        shoesButton.addActionListener(e -> bottomsPanel.setVisible(false));
        shoesButton.addActionListener(e -> formalPanel.setVisible(false));
        shoesButton.addActionListener(e -> accessoriesPanel.setVisible(false));
        shoesButton.addActionListener(e -> jacketsPanel.setVisible(false));
    }

    private void bottomsButtonFunction(ClothingType categoryBottoms) {
        bottomsButton.addActionListener(e -> closet.numberOfClothingInCategory(categoryBottoms));
        bottomsButton.addActionListener(e -> bottomsPanel.setVisible(true));
        bottomsButton.addActionListener(e -> addPanel.setVisible(false));
        bottomsButton.addActionListener(e -> removePanel.setVisible(false));
        bottomsButton.addActionListener(e -> similarPanel.setVisible(false));
        bottomsButton.addActionListener(e -> savePanel.setVisible(false));
        bottomsButton.addActionListener(e -> loadPanel.setVisible(false));
        bottomsButton.addActionListener(e -> topsPanel.setVisible(false));
        bottomsButton.addActionListener(e -> shoesPanel.setVisible(false));
        bottomsButton.addActionListener(e -> formalPanel.setVisible(false));
        bottomsButton.addActionListener(e -> accessoriesPanel.setVisible(false));
        bottomsButton.addActionListener(e -> jacketsPanel.setVisible(false));
    }

    private void topsButtonFunction(ClothingType categoryTops) {
        topsButton.addActionListener(e -> closet.numberOfClothingInCategory(categoryTops));
        topsButton.addActionListener(e -> topsPanel.setVisible(true));
        topsButton.addActionListener(e -> addPanel.setVisible(false));
        topsButton.addActionListener(e -> removePanel.setVisible(false));
        topsButton.addActionListener(e -> similarPanel.setVisible(false));
        topsButton.addActionListener(e -> savePanel.setVisible(false));
        topsButton.addActionListener(e -> loadPanel.setVisible(false));
        topsButton.addActionListener(e -> bottomsPanel.setVisible(false));
        topsButton.addActionListener(e -> shoesPanel.setVisible(false));
        topsButton.addActionListener(e -> formalPanel.setVisible(false));
        topsButton.addActionListener(e -> accessoriesPanel.setVisible(false));
        topsButton.addActionListener(e -> jacketsPanel.setVisible(false));
    }

    // EFFECTS: calls panels related to
    private void makeClosetPanels() {
        addClothingItemPanel();
        removeClothingItemPanel();
        similarItemPanel();
        saveClosetPanel();
        loadClosetPanel();

        topsNumberPanel();
        bottomsNumberPanel();
        shoesNumberPanel();
        formalNumberPanel();
        jacketsNumberPanel();
        accessoriesNumberPanel();
    }

    // EFFECTS: create panel for addClothingItem
    private void addClothingItemPanel() {
        addPanel = new JPanel();
        addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.LINE_AXIS));
        addPanel.setBounds(400, 150, 1000,650);
        addPanel.setVisible(false);
        addPanel.add(addClothingItemGraphicsLabel());
        addPanel.add(addClothingItemContentPanel());

        this.add(addPanel);
    }

    // EFFECTS: create the other panel of the addClothingButtonPanel
    private JPanel addClothingItemContentPanel()  {
        JPanel newPanel = new JPanel();

        newPanel.setBounds(800,150,600,650);
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        newPanel.add(clothingItemDescription());
        newPanel.add(addClothingItemColour());
        newPanel.add(addClothingItemSize());
        newPanel.add(addClothingItemBrand());
        newPanel.add(clothingItemCategory());

        newPanel.add(addButton());

        return newPanel;
    }

    private JButton addButton() {
        JButton button = new JButton();
        button.addActionListener(e -> {
            String descriptionString = description.getText();
            String colourString = colour.getText();
            String sizeString = size.getText();
            String brandString = brand.getText();

            String categoryString = category.getText();
            System.out.println(descriptionString);
            System.out.println("added");
            ClothingItem item = new ClothingItem(descriptionString, colourString, sizeString,
                    brandString, categoryString);
            closet.addClothingItem(item);
        });
        button.setText("ADD ITEM");

        return button;
    }

    // EFFECTS: creates Label and TextField to input the description
    private JPanel clothingItemDescription() {
        JPanel addDescription = new JPanel();

        JLabel descriptionText = new JLabel();
        descriptionText.setText("Description: ");

        description = new JTextField();
        description.setPreferredSize(new Dimension(500,25));
        description.addActionListener(e -> description.getAction());

        addDescription.add(descriptionText);
        addDescription.add(description);

        return addDescription;
    }

    // EFFECTS: creates Label and TextField to input the colour
    private JPanel addClothingItemColour() {
        JPanel addColour = new JPanel();

        JLabel colourText = new JLabel();
        colourText.setText("Colour: ");

        colour = new JTextField();
        colour.setPreferredSize(new Dimension(200,25));
        colour.addActionListener(e -> colour.getAction());

        addColour.add(colourText);
        addColour.add(colour);

        return addColour;
    }

    // EFFECTS: creates Label and TextField to input the size
    private JPanel addClothingItemSize() {
        JPanel addSize = new JPanel();

        JLabel sizeText = new JLabel();
        sizeText.setText("Size: ");

        size = new JTextField();
        size.setPreferredSize(new Dimension(200, 25));
        size.addActionListener(e -> size.getAction());

        addSize.add(sizeText);
        addSize.add(size);

        return addSize;
    }

    // EFFECTS: creates Label and TextField to input the brand
    private JPanel addClothingItemBrand() {
        JPanel addBrand = new JPanel();

        JLabel brandText = new JLabel();
        brandText.setText("Brand: ");

        brand = new JTextField();
        brand.setPreferredSize(new Dimension(200, 25));
        brand.addActionListener(e ->  brand.getAction());

        addBrand.add(brandText);
        addBrand.add(brand);

        return addBrand;
    }

    // EFFECTS: creates Label and TextField to input the category
    private JPanel clothingItemCategory() {
        JPanel addCategory = new JPanel();

        JLabel categoryText = new JLabel();
        categoryText.setText("Category: ");

        category = new JTextField();
        category.setPreferredSize(new Dimension(200, 25));
        category.addActionListener(e -> category.getAction());

        addCategory.add(categoryText);
        addCategory.add(category);

        return addCategory;
    }


    // EFFECTS: adds the closet graphic
    private JLabel addClothingItemGraphicsLabel() {
        ImageIcon closet = new ImageIcon("./src/main/ui/guiPics/closet.png");
        Image clo = closet.getImage();
        Image newClo = clo.getScaledInstance(400,650, Image.SCALE_SMOOTH);
        closet = new ImageIcon(newClo);

        JLabel label = new JLabel(closet, JLabel.LEFT);
        label.setIcon(closet);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        return label;
    }

    // EFFECTS: create panel for removeClothingItem
    private void removeClothingItemPanel() {
        removePanel = new JPanel();
        removePanel.setBounds(400, 150, 1000,650);
        removePanel.setLayout(new BoxLayout(removePanel, BoxLayout.LINE_AXIS));

        removePanel.add(removeClothingItemGraphicsLabel());
        removePanel.add(removeClothingItemContentPanel());

        removePanel.setVisible(false);

        this.add(removePanel);
    }

    private JButton removeButton() {
        JButton button = new JButton();

        String descriptionString = description.getText();
        String categoryString = category.getText();

        button.addActionListener(e -> closet.removeClothingItem(descriptionString, categoryString));
        button.setText("REMOVE ITEM");

        return button;
    }

    // EFFECTS: create the other panel of the addClothingButtonPanel
    private JPanel removeClothingItemContentPanel()  {
        JPanel newPanel = new JPanel();

        newPanel.setBounds(800,150,600,650);
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        newPanel.add(clothingItemDescription());
        newPanel.add(clothingItemCategory());

        newPanel.add(removeButton());

        return newPanel;
    }

    // EFFECTS: adds the closed closet graphic
    private JLabel removeClothingItemGraphicsLabel() {
        ImageIcon closet = new ImageIcon("./src/main/ui/guiPics/removeCloset.png");
        Image clo = closet.getImage();
        Image newClo = clo.getScaledInstance(400,650, Image.SCALE_SMOOTH);
        closet = new ImageIcon(newClo);

        JLabel label = new JLabel(closet, JLabel.LEFT);
        label.setIcon(closet);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        return label;
    }

    // EFFECTS: create panel for similar item?
    private void similarItemPanel() {
        similarPanel = new JPanel();
        similarPanel.setBounds(300, 150, 1000,650);
        similarPanel.setLayout(new BoxLayout(similarPanel, BoxLayout.LINE_AXIS));
        similarPanel.setVisible(false);
        similarPanel.add(similarItemGraphicsLabel());
        similarPanel.add(similarItemContentLabel());

        this.add(similarPanel);

    }

    private JLabel similarItemGraphicsLabel() {
        ImageIcon closet = new ImageIcon("./src/main/ui/guiPics/similar.png");
        Image clo = closet.getImage();
        Image newClo = clo.getScaledInstance(400,650, Image.SCALE_SMOOTH);
        closet = new ImageIcon(newClo);

        JLabel label = new JLabel(closet, JLabel.LEFT);
        label.setIcon(closet);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        return label;
    }

    private JPanel similarItemContentLabel() {
        JPanel newPanel = new JPanel();

        newPanel.setBounds(800,150,600,650);
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        newPanel.add(clothingItemDescription());
        newPanel.add(clothingItemCategory());
        newPanel.add(similarButton());

        return newPanel;
    }

    private JButton similarButton() {
        JButton button = new JButton();

        String descriptionString = description.getText();
        String categoryString = category.getText();

        button.addActionListener(e -> closet.hasSimilarItem(descriptionString, categoryString));
        button.setText("CHECK SIMILAR ITEM");

        return button;
    }

    // EFFECTS: create panel for save closet
    private void saveClosetPanel() {
        savePanel = new JPanel();
        savePanel.setLayout(new BoxLayout(savePanel, BoxLayout.LINE_AXIS));
        savePanel.setBounds(650,350,200,55);
        savePanel.setVisible(false);
        savePanel.add(saveClosetText(), CENTER_ALIGNMENT);

        this.add(savePanel);

    }

    // EFFECTS: adds the text to the save panel
    private JLabel saveClosetText() {
        JLabel label = new JLabel();
        label.setText("   Your closet has been saved");
        label.setFont(Font.getFont("Comic Sans"));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        return label;
    }

    // EFFECTS: create panel for load panel
    private void loadClosetPanel() {
        loadPanel = new JPanel();
        loadPanel.setBounds(650,350,200,55);
        loadPanel.setLayout(new BoxLayout(loadPanel, BoxLayout.LINE_AXIS));
        loadPanel.setVisible(false);
        loadPanel.add(loadClosetText());

        this.add(loadPanel);
    }

    // EFFECTS: adds the text to the load panel
    private JLabel loadClosetText() {
        JLabel label = new JLabel();
        label.setText("   Your closet has been loaded");

        return label;
    }

    // EFFECTS: create panel for num of tops
    private void topsNumberPanel() {
        topsPanel = new JPanel();
        topsPanel.setBounds(150,50,200,35);
        topsPanel.setVisible(false);
        System.out.println(closet.getTops());
        int numTops = closet.getTops().size();

        JLabel numT = new JLabel(String.valueOf(numTops));
        topsPanel.add(numT);

        this.add(topsPanel);
    }


    // EFFECTS: create panel for num of bottoms
    private void bottomsNumberPanel() {
        bottomsPanel = new JPanel();
        bottomsPanel.setBounds(345,50,200,35);
        bottomsPanel.setVisible(false);
        int numBottoms = closet.getBottoms().size();

        JLabel numB = new JLabel(String.valueOf(numBottoms));
        bottomsPanel.add(numB);

        this.add(bottomsPanel);
    }

    // EFFECTS: create panel for num of shoes
    private void shoesNumberPanel() {
        shoesPanel = new JPanel();
        shoesPanel.setBounds(540,50,200,35);
        shoesPanel.setVisible(false);
        int numShoes = closet.getShoes().size();

        JLabel numS = new JLabel(String.valueOf(numShoes));
        shoesPanel.add(numS);

        this.add(shoesPanel);
    }

    // EFFECTS: create panel for num of formal
    private void formalNumberPanel() {
        formalPanel = new JPanel();
        formalPanel.setBounds(735,50,200,35);
        formalPanel.setVisible(false);
        int numFormal = closet.getFormal().size();

        JLabel numF = new JLabel(String.valueOf(numFormal));
        formalPanel.add(numF);

        this.add(formalPanel);
    }

    // EFFECTS: create panel for num of accessories
    private void accessoriesNumberPanel() {
        accessoriesPanel = new JPanel();
        accessoriesPanel.setBounds(930,50,200,35);
        accessoriesPanel.setVisible(false);
        int numAccessories = closet.getAccessories().size();

        JLabel numA = new JLabel(String.valueOf(numAccessories));
        accessoriesPanel.add(numA);

        this.add(accessoriesPanel);

    }

    // EFFECTS: create panel for num of jackets
    private void jacketsNumberPanel() {
        jacketsPanel = new JPanel();
        jacketsPanel.setBounds(1125,50,200,35);
        jacketsPanel.setVisible(false);
        int numJackets = closet.getJackets().size();

        JLabel numJ = new JLabel(String.valueOf(numJackets));
        jacketsPanel.add(numJ);

        this.add(jacketsPanel);
    }


    public static void main(String[] args) {
        new ClosetGUI();
    }
}