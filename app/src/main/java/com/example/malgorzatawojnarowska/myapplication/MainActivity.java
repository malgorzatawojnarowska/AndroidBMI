package com.example.malgorzatawojnarowska.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    EditText etmass, etheight;
    Button bcount;
    TextView tvmass, tvheight;
    Switch switch1;
    public static final String SAVE = "MySavedSettingsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bcount = (Button)findViewById(R.id.bCount);
        etmass = (EditText)findViewById(R.id.etMass);
        etheight = (EditText)findViewById(R.id.etHeight);
        tvmass = (TextView)findViewById(R.id.tvMass);
        tvheight = (TextView)findViewById(R.id.tvHeight);
        switch1 = (Switch)findViewById(R.id.switch1);
        final Intent intent = new Intent(this, BMIResult.class);

        /*if(savedInstanceState!=null){
            tvresult.setText(savedInstanceState.getString("k"));
        }*/

        SharedPreferences load = getSharedPreferences(SAVE, MODE_PRIVATE);
        switch1.setChecked(load.getBoolean("units", false));
        etmass.setText(load.getString("mass", ""));
        etheight.setText(load.getString("height", ""));

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    setNull();
                    setLbIn();
                    bcount.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(validData())
                                showMsg();
                            else {
                                BMIForLbIn bmi = new BMIForLbIn(Double.parseDouble(etmass.getText().toString()), Double.parseDouble(etheight.getText().toString()));
                                intent.putExtra("bmi", String.valueOf(bmi.calculateBMI()));
                                startActivity(intent);
                            }
                        }
                    });
                }
                else{
                    setNull();
                    setKgM();
                    bcount.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(validData())
                                showMsg();
                            else {
                                BMIForKgM bmi = new BMIForKgM(Double.parseDouble(etmass.getText().toString()), Double.parseDouble(etheight.getText().toString()));
                                intent.putExtra("bmi", String.valueOf(bmi.calculateBMI()));
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });

        if(!switch1.isChecked()) {
            setKgM();
            bcount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (validData())
                        showMsg();
                    else {
                        BMIForKgM bmi = new BMIForKgM(Double.parseDouble(etmass.getText().toString()), Double.parseDouble(etheight.getText().toString()));
                        intent.putExtra("bmi", String.valueOf(bmi.calculateBMI()));
                        startActivity(intent);
                    }
                }
            });
        }
        else{
            setLbIn();
            bcount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (validData())
                        showMsg();
                    else {
                        BMIForLbIn bmi = new BMIForLbIn(Double.parseDouble(etmass.getText().toString()), Double.parseDouble(etheight.getText().toString()));
                        intent.putExtra("bmi", String.valueOf(bmi.calculateBMI()));
                        startActivity(intent);
                    }
                }
            });

        }


    }
    /*
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("k", tvresult.getText().toString());
        super.onSaveInstanceState(outState);

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.author:
                startActivity(new Intent(this, OAutorze.class));
                break;
            case R.id.save:
                SharedPreferences saveSettings = getSharedPreferences(SAVE, MODE_PRIVATE);
                SharedPreferences.Editor editor = saveSettings.edit();
                editor.putBoolean("units", switch1.isChecked()).putString("mass", etmass.getText().toString()).putString("height", etheight.getText().toString());
                editor.apply();
                break;
        }

        return true;
    }

    private boolean validData(){
        return etheight.getText().toString().equals("") || etmass.getText().toString().equals("");
    }

    private void showMsg(){
        Toast.makeText(getApplicationContext(), R.string.novalidval, Toast.LENGTH_LONG).show();
    }

    private void setNull(){
        etheight.setText(null);
        etmass.setText(null);
    }

    private void setKgM(){
        tvmass.setText(R.string.massKg);
        tvheight.setText(R.string.heightM);
    }

    private void setLbIn(){
        tvmass.setText(R.string.massLb);
        tvheight.setText(R.string.heightIn);
    }
}
