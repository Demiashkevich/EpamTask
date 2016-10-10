package com.demiashkevich.inheritance.entity;

import java.util.ArrayList;
import java.util.List;

public class Salad {

    private String name;
    private List<Vegetables> saladContent;

    public Salad() {
        saladContent = new ArrayList<>();
    }

    public boolean isEmpty() {
        return getSaladContent().isEmpty();
    }

    public void add(Vegetables vegetables){
        saladContent.add(vegetables);
    }

    public List<Vegetables> getSaladContent() {
        return saladContent;
    }

    public Vegetables getSaladContent(int index){
        return saladContent.get(index);
    }

    public int size(){
        return saladContent.size();
    }

    public void setSaladContent(List<Vegetables> saladContent) {
        this.saladContent = saladContent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
