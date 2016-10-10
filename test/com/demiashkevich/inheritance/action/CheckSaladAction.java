package com.demiashkevich.inheritance.action;

import com.demiashkevich.inheritance.creator.CreateVegetable;
import com.demiashkevich.inheritance.entity.Salad;
import com.demiashkevich.inheritance.entity.Vegetable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CheckSaladAction {

    private Salad salad;
    private SaladAction action = new SaladAction();

    @Before
    public void createSalad(){
        Vegetable vegetable1 = CreateVegetable.getVegetable(1, "CARROT", 100);
        Vegetable vegetable2 = CreateVegetable.getVegetable(2, "RADISH", 100);
        Vegetable vegetable3 = CreateVegetable.getVegetable(3, "DILL", 100);
        Vegetable vegetable4 = CreateVegetable.getVegetable(4, "TOMATO", 300);
        salad = new Salad();
        salad.add(vegetable1);
        salad.add(vegetable2);
        salad.add(vegetable3);
        salad.add(vegetable4);
    }

    @Test
    public void checkCountCalories(){
        Assert.assertEquals(320, action.countCalories(salad), 0.1);
    }

    @Test
    public void checkSortByProtein(){
        String[] saladExpected = {"RADISH", "CARROT", "TOMATO", "DILL"};
        String [] saladActual = new String[salad.size()];
        action.sortByProtein(salad);
        for(int i = 0; i < salad.size(); i++) {
            saladActual[i] = salad.getSaladContent(i).getName();
        }
        Assert.assertArrayEquals(saladExpected, saladActual);
    }

    @Test
    public void checkSearchByCalorific(){
        String[] saladExpected = {"RADISH", "DILL"};
        List<Vegetable> vegetables = action.searchByCalorific(salad, 20, 35);
        String[] saladActual = new String[vegetables.size()];
        for(int i = 0; i < saladActual.length; i++) {
            saladActual[i] = vegetables.get(i).getName();
        }
        Assert.assertArrayEquals(saladExpected, saladActual);
    }
}
