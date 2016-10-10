package com.demiashkevich.inheritance.action;

import com.demiashkevich.inheritance.entity.Salad;
import com.demiashkevich.inheritance.entity.Vegetable;
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
        for(Vegetable vegetable : salad.getSaladContent())
            calories += vegetable.getCalorific();
        return Math.round(calories);
    }

    public void sortByProtein(Salad salad){
        Collections.sort(salad.getSaladContent(), new ComparatorProtein());
    }

    public List<Vegetable> searchByCalorific(Salad salad, double from, double to){
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

    private class ComparatorProtein implements Comparator<Vegetable> {
        @Override
        public int compare(Vegetable vegetable1, Vegetable vegetable2) {
                if(vegetable1.getProtein() > vegetable2.getProtein())
                    return 1;
                else if(vegetable1.getProtein() < vegetable2.getProtein())
                    return -1;
                return 0;
            }
    }
}

