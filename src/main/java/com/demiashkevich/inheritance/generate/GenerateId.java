package com.demiashkevich.inheritance.generate;

public class GenerateId {

    private static long vegetablesId;

    public static long generateVegetablesId(){
        return vegetablesId++;
    }

}
