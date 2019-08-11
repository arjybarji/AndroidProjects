package com.example.arjun.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void buttonClicked(View view){
        EditText pounds = (EditText) findViewById(R.id.poundsAmount);
        EditText euros = (EditText) findViewById(R.id.eurosAmount);

        String eurosText = euros.getText().toString();
        String poundsText = pounds.getText().toString();

        boolean numericEuros = true;
        boolean numericPounds = true;

        try {
            Double num = Double.parseDouble(eurosText);
            Double num1 = Double.parseDouble(poundsText);
        } catch (NumberFormatException e) {
            numericEuros = false;
            numericPounds = false;
        }

        if(numericEuros  && numericPounds) {
            Double convertedEuros = 0.0;
            Double convertedPounds = 0.0;

            if (eurosText == "") {
                convertedEuros = 0.0;
            } else {
                convertedEuros = Double.parseDouble(eurosText) * 0.90;
            }

            if (poundsText == "") {
                convertedPounds = 0.0;
            } else {
                convertedPounds = Double.parseDouble(poundsText) * 1.12;
            }

            Toast.makeText(getApplicationContext(), "€" + eurosText + " = £" + convertedEuros +
                    ". £" + poundsText + " = €" + convertedPounds, Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(getApplicationContext(),"Please enter a number",Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
