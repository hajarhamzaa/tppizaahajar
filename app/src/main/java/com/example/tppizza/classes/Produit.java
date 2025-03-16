package com.example.tppizza.classes;

import java.io.Serializable;

public class Produit implements Serializable { // ✅ Implement Serializable
    private static final long serialVersionUID = 1L; // Required for serialization

    private static int counter = 1;
    private int id;
    private String name;
    private int rating;
    private int image;
    private String time;
    private String ingredients;
    private String description;
    private String steps;

    // Constructor
    public Produit(String name, int rating, int image, String time, String ingredients, String description, String steps) {
        this.id = counter++;
        this.name = name;
        this.rating = rating;
        this.image = image;
        this.time = time;
        this.ingredients = ingredients;
        this.description = description;
        this.steps = steps;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getRating() { return rating; }
    public int getImage() { return image; }
    public String getTime() { return time; }
    public String getIngredients() { return ingredients; }
    public String getDescription() { return description; }
    public String getSteps() { return steps; }

    @Override
    public String toString() {
        return name;
    }
}
