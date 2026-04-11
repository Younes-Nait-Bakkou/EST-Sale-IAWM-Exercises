package com.example.allexercises;

public class MealTD2 {
    private String name;
    private String description;
    private double price;
    private boolean isSelected;

    public MealTD2(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isSelected = false;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { isSelected = selected; }
}