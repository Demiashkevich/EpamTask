package com.demiashkevich.inheritance.entity;

import java.util.ArrayList;
import java.util.List;

public class Salad {

    private String name;
    private List<Vegetable> saladContent;

    public Salad() {
        saladContent = new ArrayList<>();
    }

    public boolean isEmpty() {
        return getSaladContent().isEmpty();
    }

    public void add(Vegetable vegetable){
        saladContent.add(vegetable);
    }

    public List<Vegetable> getSaladContent() {
        return saladContent;
    }

    public Vegetable getSaladContent(int index){
        return saladContent.get(index);
    }

    public int size(){
        return saladContent.size();
    }

    public void setSaladContent(List<Vegetable> saladContent) {
        this.saladContent = saladContent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
