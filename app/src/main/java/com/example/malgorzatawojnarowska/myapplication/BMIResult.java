package com.example.malgorzatawojnarowska.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Locale;


public class BMIResult extends AppCompatActivity {
    ConstraintLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);

        myLayout = findViewById(R.id.resultLayout);
        TextView tvbmi = findViewById(R.id.bmiResult);

        Intent i = getIntent();

        String bmi = i.getStringExtra("bmi");
        double bmivalue = Double.parseDouble(bmi);

        tvbmi.setText(String.format(Locale.getDefault(),"%.2f", bmivalue));


        if(bmivalue<18.5) myLayout.setBackgroundColor(Color.YELLOW);
        else if (bmivalue>=25) myLayout.setBackgroundColor(Color.RED);
        else myLayout.setBackgroundColor(Color.GREEN);


    }
}
