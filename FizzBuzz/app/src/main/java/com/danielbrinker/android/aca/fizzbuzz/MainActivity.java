package com.danielbrinker.android.aca.fizzbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button mConvertButton;
    private EditText mEditText;
    private TextView mResultText;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mConvertButton = (Button) findViewById(R.id.convertButton); //You have casted it to a button.
        mEditText = (EditText) findViewById(R.id.editText); // cast it to EditText and drill to resources and look for the ID for editText
        mResultText = (TextView) findViewById(R.id.resultText);


        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int num = Integer.parseInt(mEditText.getText().toString());

                if ((num % 3) == 0 && (num % 5) == 0) {
                    mResultText.setText("FizzBuzz");
                } else if (num % 5 == 0) {
                    mResultText.setText("Buzz");
                } else if (num % 3 == 0) {
                    mResultText.setText("Fizz");
                } else mResultText.setText("It's neither fizz nor buzz.");


            }


        });
    }
}