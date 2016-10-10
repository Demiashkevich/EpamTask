package com.demiashkevich.inheritance.action;

import com.demiashkevich.inheritance.entity.Menu;
import com.demiashkevich.inheritance.entity.Salad;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckParseFromRecipe {

    @Test
    public void parseRecipe(){
        List<String> recipes = new ArrayList<>();
        recipes.add("TOOL: CUCUMBER-100, DILL-100, TOMATOES-200");
        recipes.add("ROOM: YOG-100, DILL-100, TOMATOES-200");
        recipes.add("LOOP: SPINACH-200, DILL-100, TOMATOES-200");
        ParseFromRecipe parse = new ParseFromRecipe();
        Menu menu = parse.parseRecipe(recipes);
        String[] actualName = new String[menu.size()];
        String[] expectedName = {"TOOL", "LOOP"};
        for(int i = 0; i < menu.size(); i++){
            Salad salad = menu.get(i);
            actualName[i] = salad.getName();
        }
        Assert.assertArrayEquals(expectedName, actualName);
    }

}
