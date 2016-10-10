package com.demiashkevich.inheritance.out;

import com.demiashkevich.inheritance.action.SaladAction;
import com.demiashkevich.inheritance.entity.Salad;
import com.demiashkevich.inheritance.entity.Menu;
import com.demiashkevich.inheritance.entity.Vegetables;
import org.apache.log4j.Logger;

import java.util.List;

public class PrintConsole {

    private final static Logger LOGGER = Logger.getLogger(PrintConsole.class);

    public void printSaladList(Menu menu){
        for(Salad salad : menu.getSaladList()) {
            LOGGER.info(salad.getName());
            salad.getSaladContent().forEach(LOGGER::info);
        }
    }

    public void printSaladSortedByProtein(Salad salad){
        LOGGER.info("SORTED BY PROTEIN:");
        salad.getSaladContent().forEach(LOGGER::info);
    }

    public void printSaladCalorific(Salad salad){
        SaladAction action = new SaladAction();
        LOGGER.info("SALAD CALORIFIC:");
        LOGGER.info("Salad " + salad.getName() + " have " + action.countCalories(salad) + " calories.");
    }

    public void printSaladSearchByCalorific(Salad salad, int from, int to){
        LOGGER.info("SEARCH BY CALORIFIC:");
        SaladAction action = new SaladAction();
        List<Vegetables> list = action.searchByCalorific(salad, from, to);
        list.forEach(LOGGER::info);
    }
}
