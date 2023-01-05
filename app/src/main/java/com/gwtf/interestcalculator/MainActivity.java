package com.gwtf.interestcalculator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText enteramount, enterrate,durationinyear,durationinmonths;
Button calculate;
TextView ci,si,amtsi,amtci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enteramount=findViewById(R.id.enteramt);
        enterrate=findViewById(R.id.enterroi);
        durationinyear=findViewById(R.id.tyminyear);
        calculate=findViewById(R.id.Calculate);
        ci=findViewById(R.id.ansci);
        amtci=findViewById(R.id.ansamt2);
        si=findViewById(R.id.anssi);
        durationinmonths=findViewById(R.id.durationinmonths);
        amtsi=findViewById(R.id.ansamt);
        calculate.setOnClickListener(view -> {
            if(enteramount.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, "Please enter the amount", Toast.LENGTH_SHORT).show();
            }
            else if(enterrate.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, "Please enter the rate of interest", Toast.LENGTH_SHORT).show();
            }
            else if(durationinyear.getText().toString().equals("") || durationinmonths.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, "Please enter the time period", Toast.LENGTH_SHORT).show();
            }
            else{


                double p=Double.parseDouble(enteramount.getText().toString());
                double r=Double.parseDouble(enterrate.getText().toString());
                int ty=Integer.parseInt(durationinyear.getText().toString());
                int tm=Integer.parseInt(durationinmonths.getText().toString());

                Double s;
                Double amts;
                Double c;
                Double amtc;
                int t=tm+ty*12;
                    s=(p*r*t)/100;
                    amts=p+s;
                    amtc=p* Math.pow((1+r/100),t);
                    c=amtc-p;

                si.setText(String.valueOf(s));
                amtsi.setText(String.valueOf(amts));
                ci.setText(String.valueOf(c));
                amtci.setText(String.valueOf(amtc));

            }
        });

    }
}