package com.demiashkevich.inheritance.entity;

public class SheetVegetables extends Vegetables {

    public enum SheetType {
        DILL(31, 2.6, 7.6, 0.5), SPINACH(226, 2.9, 2.5, 0.3);

        private double calorific;
        private double protein;
        private double carbohydrates;
        private double fats;

        SheetType(double calorific, double protein, double carbohydrates, double fats) {
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

    public SheetVegetables(long vegetablesID, String name, float weight) {
        super(vegetablesID, name, weight, SheetType.valueOf(name).getCalorific(), SheetType.valueOf(name).getProtein(),
                SheetType.valueOf(name).getCarbohydrates(), SheetType.valueOf(name).getFats());
    }
    
}
