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
        return getMass() > 0 && getHeight() > 0 && getMass() < 440 && getHeight() < 102;
    }
}
