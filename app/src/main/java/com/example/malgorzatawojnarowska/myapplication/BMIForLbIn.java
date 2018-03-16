package com.example.malgorzatawojnarowska.myapplication;

/**
 * Created by malgorzatawojnarowska on 15.03.2018.
 */

public class BMIForLbIn extends BMI{

    public BMIForLbIn(double mass, double height){
        super(mass, height);
    }

    @Override
    public double calculateBMI() throws IllegalArgumentException{
        if (isDataValid())
            return getMass() / (getHeight()*getHeight()) * 703;
        else
            throw new IllegalArgumentException("Invalid data");
    }

    @Override
    protected boolean isDataValid() {
        return getMass() > 110 && getHeight() > 40 && getMass() < 440 && getHeight() < 102;
    }
}
