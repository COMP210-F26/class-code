package edu.unc.comp210.Generics;

import java.util.*;

public class CookoutShake implements Shake,  Comparable<CookoutShake> {
    private final int flavors;
    private final String name;

    public CookoutShake(int flavors, String name){
        this.flavors = flavors;
        this.name = name;
    }

    public int getFlavors() {
        return flavors;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof CookoutShake){
            return this.flavors == ((CookoutShake)o).getFlavors();
        }
        return false;
    }


    @Override
    public int compareTo(CookoutShake o) {
        return this.flavors - o.getFlavors();
    }

    @Override
    public String toString(){
        return this.name + ": " + this.flavors;
    }


    public static void main(String[] args){
        CookoutShake vanilla = new CookoutShake(1, "Vanilla");
        CookoutShake vanillaRaspberryCheescake = new CookoutShake(3, "VanillaRaspberryCheesecase");
        CookoutShake chocolate = new CookoutShake(1, "Chocolate");

        System.out.println(vanilla);
        System.out.println(vanilla.equals(chocolate));
        System.out.println(vanilla.equals(vanillaRaspberryCheescake));

        List<CookoutShake> menu = new ArrayList<>();
        menu.add(vanillaRaspberryCheescake);
        menu.add(vanilla);
        menu.add(chocolate);

        Collections.sort(menu);

        for(CookoutShake s: menu){
            System.out.println(s);
        }



    }

}



