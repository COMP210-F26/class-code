package edu.unc.comp210.Encapsulation;

public class DecimalPractice {
    public static void main(String[] args){
        double actual = 0.1 + 0.1+ 0.1;
        double expected = .3;
        System.out.println(Math.abs(actual - expected) < 0.0001);
    }

}
