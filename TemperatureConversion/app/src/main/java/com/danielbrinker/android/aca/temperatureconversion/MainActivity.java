package com.danielbrinker.android.aca.temperatureconversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mFah;
    TextView mCel;
    TextView mOutputTextView;
    Button mConvertButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFah = (TextView) findViewById(R.id.fahText);
        mCel = (TextView) findViewById(R.id.celText);
        mOutputTextView = (TextView) findViewById(R.id.outputText);
        mConvertButton = (Button) findViewById(R.id.calcButton);



        mConvertButton.setOnClickListener(new View.OnClickListener() {
            String currentFah;
            String convertedTemp;
            String currentCel;

            @Override
            public void onClick(View view) {


                if (!mFah.getText().toString().equals("")) {
                    currentFah = mFah.getText().toString();
                    double fahValue = Double.parseDouble(currentFah);


                    fahValue = fahValue - 32;
                    fahValue = fahValue / 9;
                    fahValue = fahValue * 5;

                    convertedTemp = String.valueOf(fahValue);

                    mOutputTextView.setText(currentFah + " fahrenheit is" + convertedTemp + " celsius.");
                    mFah.setText("");

                    mCel.setText(convertedTemp);


                } else if (!mCel.getText().toString().equals("")) {
                    currentCel = mCel.getText().toString();
                    double celValue = Double.parseDouble(currentCel);

                    celValue = celValue * 9;
                    celValue = celValue / 5;
                    celValue = celValue + 32;


                    convertedTemp = String.valueOf(celValue);

                  mOutputTextView.setText(currentCel + " celsius is" + convertedTemp + " fahrenheit.");
                    mCel.setText("");
                }



            }
        });

        mFah.getText();

        float fah = 86;
        System.out.println(fah + " degrees in Fahrenheit is: ");
        // To convert Fahrenheit to Celcius
        // begin by subtracting 32
        fah = fah - 32;
        //Divide answer by 5
        fah = fah / 9;
        //multiply that answer by 5
        fah = fah * 5;
        System.out.println(fah + " degrees Celcius\n");

        float cel = 33;
        System.out.println(cel + " degrees Celsius is  ...");
        //To convert Celsius into Fahrenheit
        //Begin by multiplying by 9
        cel = cel *9;
        // Divide the answer by 5
        cel = cel / 5;
        //Add 32 to the answer
        cel = cel + 32;
        System.out.println(cel + " degrees in Fahrenheit");

    }
}


//Temp in Fahrenheit. Hit a button and it converts the temperature to Celsius.