package edu.unc.comp210.Inheritance;

public class Dolphin extends Animal implements Character{

    public Dolphin(String name){
        super(name);
    }


    @Override
    public void speak() {
        System.out.println("click click click");
    }
}
