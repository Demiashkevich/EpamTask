package com.demiashkevich.inheritance.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Salad> saladList;

    public Menu(){
        saladList = new ArrayList<>();
    }

    public List<Salad> getSaladList() {
        return saladList;
    }

    public void setSaladList(List<Salad> saladList) {
        this.saladList = saladList;
    }

    public void add(Salad salad){
        saladList.add(salad);
    }

    public Salad get(int index) {
        return getSaladList().get(index);
    }

    public Salad set(int index, Salad element) {
        return getSaladList().set(index, element);
    }

    public int size() {
        return getSaladList().size();
    }

}
