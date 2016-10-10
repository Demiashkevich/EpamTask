package com.demiashkevich.inheritance.entity;

public class FruitingVegetables extends Vegetables {

    public enum FruitingType {
        TOMATOES(14, 0.8, 3.8, 0.1), CUCUMBER(23, 1.1, 5, 0.2);

        private double calorific;
        private double protein;
        private double carbohydrates;
        private double fats;

        private FruitingType(double calorific, double protein, double carbohydrates, double fats) {
             this.calorific = calorific;
             this.protein = protein;
             this.carbohydrates = carbohydrates;
             this.fats = fats;
        }

        public double getCalorific() {
            return calorific;
        }

        public double getProtein() {
            return protein;
        }

        public double getCarbohydrates() {
            return carbohydrates;
        }

        public double getFats() {
            return fats;
        }

    }

    public FruitingVegetables(long vegetablesID, String name, float weight) {
        super(vegetablesID, name, weight, FruitingType.valueOf(name).getCalorific(), FruitingType.valueOf(name).getProtein(),
                FruitingType.valueOf(name).getCarbohydrates(), FruitingType.valueOf(name).getFats());
    }
}




