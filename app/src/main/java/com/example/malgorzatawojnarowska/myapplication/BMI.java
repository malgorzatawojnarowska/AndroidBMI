package com.example.malgorzatawojnarowska.myapplication;

/**
 * Created by malgorzatawojnarowska on 08.03.2018.
 */

abstract public class BMI {

    double mass, height;

    public BMI(double mass, double height){
        this.mass = mass;
        this.height = height;
    }

    double getMass(){
        return mass;
    }

    double getHeight(){
        return height;
    }

    void setMass(double mass){
        this.mass = mass;
    }

    void setHeight(double height){
        this.height = height;
    }

    double calculateBMI(){
        return mass/(height*height);
    }

    protected boolean isDataValid() {
        return mass > 0 && height > 0;
    }


    //gettery, settery, abstract
}
