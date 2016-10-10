package com.demiashkevich.inheritance.action;

import java.util.EnumSet;

public class TypeAction {
    public static  <E extends Enum<E>> boolean searchType(String name, Class<E> type){
        EnumSet<E> set = EnumSet.allOf(type);
        return set.stream().anyMatch((types) -> types.name().equalsIgnoreCase(name));
    }
}
