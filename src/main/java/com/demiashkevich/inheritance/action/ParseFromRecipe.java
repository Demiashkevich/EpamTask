package com.demiashkevich.inheritance.action;

import com.demiashkevich.inheritance.creator.CreateVegetables;
import com.demiashkevich.inheritance.entity.Menu;
import com.demiashkevich.inheritance.entity.Salad;
import com.demiashkevich.inheritance.entity.Vegetables;
import org.apache.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.demiashkevich.inheritance.generate.GenerateId.generateVegetablesId;

public class ParseFromRecipe {

    private static final Logger LOGGER = Logger.getLogger(ParseFromRecipe.class);
    private static final String SPACE = "\\s+";
    private static final String LITTER = "(?i).*[a-zа-я].*";
    private static final String NUMBER = "[-+]?\\d+";
    private static final byte VEGETABLES_NAME = 0;
    private static final byte VEGETABLES_WEIGHT = 1;
    private static final byte SALAD_NAME = 0;
    private static final byte SALAD_PRODUCTS = 1;

    public Menu parseRecipe(List<String> recipes){
        Menu menu = new Menu();
        for(String recipe : recipes) {
            Salad salad = new Salad();
            recipe = recipe.replaceAll(SPACE, "");
            String[] saladConsist = recipe.split(":");
            salad.setName(saladConsist[SALAD_NAME]);
            recipe = saladConsist[SALAD_PRODUCTS];
            Map<String, Float> products = this.convertProducts(recipe);
            for(Map.Entry<String, Float> product : products.entrySet()) {
                Vegetables vegetables = CreateVegetables.getVegetables(generateVegetablesId(), product.getKey(), product.getValue());
                if(vegetables != null) {
                    salad.add(vegetables);
                }
                if(salad.size() == products.size()) {
                    menu.add(salad);
                    LOGGER.debug(salad.getName() + " was created and add in " + menu.getClass().getSimpleName());
                }
            }
        }
        return menu;
    }

    private Map<String, Float> convertProducts(String recipe){
        Map<String, Float> vegetables = new LinkedHashMap<>();
        String name;
        float weight;
        String[] components = recipe.split(",");
        for(String component : components) {
            String[] nameAndWeight = component.split("-");
            if(nameAndWeight.length == 2){
                if(isNumeric(nameAndWeight[VEGETABLES_WEIGHT]) && isString(nameAndWeight[VEGETABLES_NAME])) {
                    name = nameAndWeight[VEGETABLES_NAME];
                    weight = Float.parseFloat(nameAndWeight[VEGETABLES_WEIGHT]);
                    vegetables.put(name, weight);
                }
                else {
                    break;
                }
            }
        }
        return vegetables;
    }

    private boolean isNumeric(String weight){
        return weight.matches(NUMBER);
    }

    private boolean isString(String name){
        return name.matches(LITTER);
    }
}
