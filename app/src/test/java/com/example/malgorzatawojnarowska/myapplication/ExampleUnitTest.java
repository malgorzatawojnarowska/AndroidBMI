package com.example.malgorzatawojnarowska.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void for_valid_data_bmi_kgm_return_value() {
        BMI bmiCounter = new BMIForKgM(60, 170);
        double bmi = bmiCounter.calculateBMI();
        assertEquals(20.761, bmi, 0.001);
    }

    @Test
    public void for_valid_data_bmi_lbin_return_value() {
        BMI bmiCounter = new BMIForLbIn(130, 70);
        double bmi = bmiCounter.calculateBMI();
        assertEquals(18.651, bmi, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void for_zero_bmi_throw_exception() {
        BMI bmiCounter = new BMIForKgM(0, 0);
        double bmi = bmiCounter.calculateBMI();
    }

    @Test(expected = IllegalArgumentException.class)
    public void for_too_big_height_throw_exception() {
        BMI bmiCounter = new BMIForKgM(50, 300);
        double bmi = bmiCounter.calculateBMI();
    }

    @Test(expected = IllegalArgumentException.class)
    public void for_negative_arguments_kgm_throw_exception() {
        BMI bmiCounter = new BMIForKgM(-40, -150);
        double bmi = bmiCounter.calculateBMI();
    }

    @Test(expected = IllegalArgumentException.class)
    public void for_negative_arguments_lbin_throw_exception() {
        BMI bmiCounter = new BMIForLbIn(-100, -50);
        double bmi = bmiCounter.calculateBMI();
    }


}