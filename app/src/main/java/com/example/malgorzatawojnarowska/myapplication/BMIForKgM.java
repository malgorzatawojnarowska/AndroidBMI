package com.example.malgorzatawojnarowska.myapplication;

/**
 * Created by malgorzatawojnarowska on 08.03.2018.
 */

public class BMIForKgM extends BMI {

    public BMIForKgM(double mass, double height){
        super(mass, height/100);
    }

    @Override
    public double calculateBMI() throws IllegalArgumentException{
        if (isDataValid())
            return getMass() / (getHeight()*getHeight());
        else
            throw new IllegalArgumentException("Invalid data");
    }

    @Override
    protected boolean isDataValid() {
        return getMass() > 50 && getHeight() > 100 && getMass() < 200 && getHeight() < 260;
    }
}
