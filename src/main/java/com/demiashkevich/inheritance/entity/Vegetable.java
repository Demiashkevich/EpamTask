package com.demiashkevich.inheritance.entity;

public class Vegetable {

    private long vegetablesId;
    private String name;
    private double calorific;
    private double protein;
    private double carbohydrates;
    private double fats;
    private double weight;

    public Vegetable(long vegetablesID, String name, float weight, double calorific, double protein, double carbohydrates, double fats) {
        this.vegetablesId = vegetablesID;
        this.name = name;
        this.calorific = calorific*weight/100;
        this.protein = protein*weight/100;
        this.carbohydrates = carbohydrates *weight/100;
        this.fats = fats;
        this.weight = weight;
    }

    public long getVegetablesId() {
        return vegetablesId;
    }

    public double getCalorific() {
        return calorific;
    }

    public void setCalorific(double calorific) {
        this.calorific = calorific;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public void setVegetablesId(int vegetablesId) {
        this.vegetablesId = vegetablesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "Id=" + vegetablesId +
                ", name='" + name + '\'' +
                ", calorific=" + calorific +
                ", protein=" + protein +
                ", carbohydrates=" + carbohydrates +
                ", fats=" + fats +
                ", weight=" + weight;
    }
}
