package edu.unc.comp210.Inheritance;

public abstract class Animal {
    private String name;

    public Animal(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
