package edu.unc.comp210.Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cat implements Animal, Comparable<Cat>{
    private final String name;
    private double weight;

    public Cat(String name, double weight){
        this.name = name;
        this.weight = weight;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString(){
        return this.name + ": " + this.weight;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Cat){
            return(Double.compare(this.weight, ((Cat)o).getWeight()) == 0) ;
        }
        return false;

    }

    @Override
    public int compareTo(Cat o) {
        return Double.compare(this.getWeight(), o.getWeight());
    }


    public static void main(String[] args){
        Cat whiskers = new Cat("Whiskers", 5.5);
        Cat thomas = new Cat("Thomas", 5.5);
        Cat grumpyCat = new Cat("Tartar Sauce", 10);

        System.out.println(whiskers.equals(thomas));
        System.out.println(whiskers.equals(grumpyCat));
        List<Cat> list = new ArrayList<>();
        list.add(whiskers);
        list.add(grumpyCat);
        list.add(thomas);

        Collections.sort(list);

        for(Cat c : list){
            System.out.println(c);
        }

    }

}
