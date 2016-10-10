package com.demiashkevich.inheritance.creator;

import com.demiashkevich.inheritance.action.TypeAction;
import com.demiashkevich.inheritance.entity.FruitingVegetables;
import com.demiashkevich.inheritance.entity.RootVegetables;
import com.demiashkevich.inheritance.entity.SheetVegetables;
import com.demiashkevich.inheritance.entity.Vegetables;

public class CreateVegetables {

    public static Vegetables getVegetables(long vegetableID, String name, float weight){
        name = name.toUpperCase();
        if(TypeAction.searchType(name, FruitingVegetables.FruitingType.class)) {
            return new FruitingVegetables(vegetableID, name, weight);
        }else if(TypeAction.searchType(name, RootVegetables.RootType.class)) {
            return new RootVegetables(vegetableID, name, weight);
        }else if(TypeAction.searchType(name, SheetVegetables.SheetType.class)) {
            return new SheetVegetables(vegetableID, name, weight);
        }
        return null;
    }



}
