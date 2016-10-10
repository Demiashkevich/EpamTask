package com.demiashkevich.inheritance.action;

import com.demiashkevich.inheritance.entity.Salad;
import com.demiashkevich.inheritance.entity.Vegetables;
import com.demiashkevich.inheritance.exception.DiapasonException;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SaladAction {

    private static final Logger LOGGER = Logger.getLogger(SaladAction.class);

    public double countCalories(Salad salad){
        double calories = 0;
        for(Vegetables vegetables : salad.getSaladContent())
            calories += vegetables.getCalorific();
        return Math.round(calories);
    }

    public void sortByProtein(Salad salad){
        Collections.sort(salad.getSaladContent(), new ComparatorProtein());
    }

    public List<Vegetables> searchByCalorific(Salad salad, double from, double to){
        try {
            if (from <= 0 || to <= 0) {
                throw new DiapasonException();
            }
        }catch (DiapasonException exception){
            LOGGER.error("Illegal calorific diapason. ", exception);
        }
        return salad.getSaladContent().stream()
                .filter((p)-> p.getCalorific() > from && p.getCalorific() < to)
                .collect(Collectors.toList());
    }

    private class ComparatorProtein implements Comparator<Vegetables> {
        @Override
        public int compare(Vegetables vegetables1, Vegetables vegetables2) {
                if(vegetables1.getProtein() > vegetables2.getProtein())
                    return 1;
                else if(vegetables1.getProtein() < vegetables2.getProtein())
                    return -1;
                return 0;
            }
    }
}

