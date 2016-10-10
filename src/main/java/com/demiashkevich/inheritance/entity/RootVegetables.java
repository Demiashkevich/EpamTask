package com.demiashkevich.inheritance.entity;

public class RootVegetables extends Vegetables {

    public enum RootType {
        CARROT(226, 1.3, 7, 0.6), RADISH(21, 1.2, 4.6, 0.1);

        private double calorific;
        private double protein;
        private double carbohydrates;
        private double fats;

        RootType(double calorific, double protein, double carbohydrates, double fats) {
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

    public RootVegetables(long vegetablesID, String name, float weight) {
        super(vegetablesID, name, weight, RootType.valueOf(name).getCalorific(), RootType.valueOf(name).getProtein(),
                RootType.valueOf(name).getCarbohydrates(), RootType.valueOf(name).getFats());
    }
    
}
