package com.demiashkevich.inheritance.action;

import com.demiashkevich.inheritance.creator.CreateVegetables;
import com.demiashkevich.inheritance.entity.Salad;
import com.demiashkevich.inheritance.entity.Vegetables;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CheckSaladAction {

    private Salad salad;
    private SaladAction action = new SaladAction();

    @Before
    public void createSalad(){
        Vegetables vegetables1 = CreateVegetables.getVegetables(1, "CARROT", 100);
        Vegetables vegetables2 = CreateVegetables.getVegetables(2, "RADISH", 100);
        Vegetables vegetables3 = CreateVegetables.getVegetables(3, "DILL", 100);
        Vegetables vegetables4 = CreateVegetables.getVegetables(4, "TOMATOES", 300);
        salad = new Salad();
        salad.add(vegetables1);
        salad.add(vegetables2);
        salad.add(vegetables3);
        salad.add(vegetables4);
    }

    @Test
    public void checkCountCalories(){
        Assert.assertEquals(320, action.countCalories(salad), 0.1);
    }

    @Test
    public void checkSortByProtein(){
        String[] saladExpected = {"RADISH", "CARROT", "TOMATOES", "DILL"};
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
        List<Vegetables> vegetables = action.searchByCalorific(salad, 20, 35);
        String[] saladActual = new String[vegetables.size()];
        for(int i = 0; i < saladActual.length; i++) {
            saladActual[i] = vegetables.get(i).getName();
        }
        Assert.assertArrayEquals(saladExpected, saladActual);
    }
}
