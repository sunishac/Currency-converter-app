//HomeWork1
//File Name:MainActivity.java
//Student Name: Sunisha Chalasani

package com.example.chala.currencyconvertor;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.chala.currencyconvertor.R.id.audButton;
import static com.example.chala.currencyconvertor.R.id.gbpButton;
import static com.example.chala.currencyconvertor.R.id.usdButton;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.buttonConvert);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputTxt=(EditText) findViewById(R.id.inputText);
                //double db = Double.parseDouble(inputTxt.getText().toString());

                double o=0;
                try {
                    o = Double.parseDouble(inputTxt.getText().toString());
                } catch(NumberFormatException nfe) {

                }


                RadioButton radioAud = (RadioButton)findViewById(R.id.audButton);
                RadioButton radioUsd = (RadioButton)findViewById(R.id.usdButton);
                RadioButton radioGbp = (RadioButton)findViewById(R.id.gbpButton);
                RadioButton radioInr = (RadioButton)findViewById(R.id.inrButton);
                RadioButton radioCad = (RadioButton)findViewById(R.id.cadButton);

                if(radioAud.isChecked()) {
                    if(radioUsd.isChecked())
                    {
                        o=(1/1.34)*o;
                    }
                    if(radioGbp.isChecked())
                    {
                        o=(0.83/1.34)*o;
                    }
                }
                if(radioCad.isChecked()){
                    if(radioUsd.isChecked())
                    {
                        o=(1/1.32)*o;
                    }
                    if(radioGbp.isChecked())
                    {
                        o=(0.83/1.32)*o;
                    }
                }
                if(radioInr.isChecked())
                {
                    if(radioUsd.isChecked())
                    {
                        o=(1/68.14)*o;
                    }
                    if(radioGbp.isChecked())
                    {
                        o=(0.83/68.14)*o;
                    }
                }

                TextView tv = (TextView)findViewById(R.id.resultText);
                tv.setText(Double.toString(o));

                Log.d("demo", "convert button clicked");
            }
        });

    }

    public void clearClicked(View v) {
        RadioButton bt1=(RadioButton) findViewById(R.id.audButton);
        RadioButton bt2=(RadioButton) findViewById(R.id.cadButton);
        RadioButton bt3=(RadioButton) findViewById(R.id.inrButton);
        RadioButton bt4=(RadioButton) findViewById(R.id.usdButton);
        RadioButton bt5=(RadioButton) findViewById(R.id.gbpButton);
        EditText ed=(EditText) findViewById(R.id.inputText);
        TextView tv=(TextView) findViewById(R.id.resultText);
        bt1.setChecked(false);
        bt2.setChecked(false);
        bt3.setChecked(false);
        bt4.setChecked(false);
        bt5.setChecked(false);
        ed.setText("  ");
        tv.setText(" ");
        Log.d("demo", "clear button clicked");
    }

}