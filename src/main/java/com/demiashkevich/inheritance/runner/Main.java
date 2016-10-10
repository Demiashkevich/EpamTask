package com.demiashkevich.inheritance.runner;

import com.demiashkevich.inheritance.action.ParseFromRecipe;
import com.demiashkevich.inheritance.entity.Menu;
import com.demiashkevich.inheritance.out.PrintConsole;
import com.demiashkevich.inheritance.reader.ReadFile;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        List<String> recipes = readFile.readRecipe();

        ParseFromRecipe fromRecipe = new ParseFromRecipe();
        Menu menu = fromRecipe.parseRecipe(recipes);

        PrintConsole printConsole = new PrintConsole();

        printConsole.printSaladList(menu);
        printConsole.printSaladSearchByCalorific(menu.get(0), 1, 100);
        printConsole.printSaladSortedByProtein(menu.get(0));
        printConsole.printSaladCalorific(menu.get(0));
    }

}

