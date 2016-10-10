package com.demiashkevich.inheritance.creator;

import com.demiashkevich.inheritance.entity.Vegetable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckCreateVegetable {

    private boolean expected;
    private int vegetableId;
    private String name;
    private float weight;

    public CheckCreateVegetable(boolean expected, int vegetableId, String name, float weight) {
        this.expected = expected;
        this.vegetableId = vegetableId;
        this.name = name;
        this.weight = weight;
    }

    @Test
    public void checkCreateVegetables(){
        boolean expected = this.expected;
        Vegetable vegetable = CreateVegetable.getVegetable(vegetableId, name, weight);
        boolean actual = false;
        if(vegetable != null){
            actual = true;
        }
        Assert.assertSame(expected, actual);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {true, 1, "CARROT", 100},
                {true, 2, "RADISH", 200},
                {false, 3, "CAR", 500},
                {false, 4, "YOG", 100},
                {true, 5, "DILL", 200},
                {false, 6, "TOR", 600}
        });

    }
}
