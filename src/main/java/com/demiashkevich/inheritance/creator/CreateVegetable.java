package com.demiashkevich.inheritance.creator;

import com.demiashkevich.inheritance.action.TypeAction;
import com.demiashkevich.inheritance.entity.FruitingVegetable;
import com.demiashkevich.inheritance.entity.RootVegetable;
import com.demiashkevich.inheritance.entity.SheetVegetable;
import com.demiashkevich.inheritance.entity.Vegetable;

public class CreateVegetable {

    public static Vegetable getVegetable(long vegetableID, String name, float weight){
        name = name.toUpperCase();
        if(TypeAction.searchType(name, FruitingVegetable.FruitingType.class)) {
            return new FruitingVegetable(vegetableID, name, weight);
        }else if(TypeAction.searchType(name, RootVegetable.RootType.class)) {
            return new RootVegetable(vegetableID, name, weight);
        }else if(TypeAction.searchType(name, SheetVegetable.SheetType.class)) {
            return new SheetVegetable(vegetableID, name, weight);
        }
        return null;
    }



}
