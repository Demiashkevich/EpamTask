package com.demiashkevich.inheritance.action;

import com.demiashkevich.inheritance.entity.FruitingVegetables;
import com.demiashkevich.inheritance.entity.RootVegetables;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckTypeAction {

    private boolean expected;
    private String name;
    private Class typeEnum;

    public CheckTypeAction(boolean expected, String name, Class typeClass) {
        this.expected = expected;
        this.name = name;
        this.typeEnum = typeClass;
    }

    @Test
    public void checkSearchType(){
        boolean expected = this.expected;
        String name = this.name;
        name = name.toUpperCase();
        Class typeEnum = this.typeEnum;
        boolean actual = TypeAction.searchType(name, typeEnum);
        Assert.assertSame(expected, actual);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {true, "CARROT", RootVegetables.RootType.class},
                {false, "TOY", RootVegetables.RootType.class},
                {true, "CUCUMBER", FruitingVegetables.FruitingType.class},
                {false, "YOGA", FruitingVegetables.FruitingType.class}
        });

    }
}
