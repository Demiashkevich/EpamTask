package com.demiashkevich.inheritance.reader;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class ReadFile {

    private static final Logger LOGGER = Logger.getLogger(ReadFile.class);
    private static final String RECIPE_PATH = "data/recipe.txt";

    public List<String> readRecipe(){
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(RECIPE_PATH));
        } catch (IOException exception) {
            LOGGER.error(exception);
            throw new RuntimeException();
        }
        return lines;
    }
}
