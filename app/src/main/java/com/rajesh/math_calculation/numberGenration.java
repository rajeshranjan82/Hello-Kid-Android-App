package com.rajesh.math_calculation;

import java.util.ArrayList;
import java.util.Random;

public class numberGenration {

    public ArrayList<Integer> numbervalue ()
    {
        ArrayList<Integer> randomeValue= new ArrayList();
        Random randomNumber =new Random();
        int firstNumber=randomNumber.nextInt(20);
        int secondNumber=randomNumber.nextInt(20);
        randomeValue.add(firstNumber);
        randomeValue.add(secondNumber);

        return randomeValue;
    }
}
