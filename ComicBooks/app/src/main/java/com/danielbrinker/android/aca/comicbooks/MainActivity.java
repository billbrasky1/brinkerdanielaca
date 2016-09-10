package com.danielbrinker.android.aca.comicbooks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    //This is an example of Hash maps

    private Button mConvertButton;
    private EditText mTitle;
    private EditText mIssueNum;
    private EditText mCondition;
    private EditText mBasePrice;
    private TextView mResultText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = (EditText) findViewById(R.id.titleIn);
        mIssueNum = (EditText) findViewById(R.id.issueIn);
        mCondition = (EditText) findViewById(R.id.conditionIn);
        mBasePrice = (EditText) findViewById(R.id.basePriceIn);
        mConvertButton = (Button) findViewById(R.id.convertButton);
        mResultText = (TextView) findViewById(R.id.resultText);

        final HashMap quality = new HashMap();

        //These are set in key-value pairs



        float price1 = 3.00F; //add values
        quality.put("mint", price1); //key value pair
        float price2 = 2.00f;
        quality.put("near mint", price2);
        float price3 = 1.50f;
        quality.put("very fine", price3);
        float price4 = 1.00f;
        quality.put("fine", price4);
        float price5 = 0.50f;
        quality.put("good", price5);
        float price6 = 0.25f;
        quality.put("poor", price6);

        //set up a collection, create array based off Comic class
        final Comic[] comix = new Comic[3];
        //add comics to collection
        comix[0] = new Comic("Amazing Spider-Man", "1A", "very fine", 12_000.00f);
        //passing in title, issue number, condition, base price
        comix[0].setPrice((Float) quality.get(comix[0].condition)); //call method, cast to float

        comix[1] = new Comic("Incredible Hulk", "181", "near mint", 680.00f);
        comix[1].setPrice((Float) quality.get(comix[1].condition));

        comix[2] = new Comic("Cerebus", "1A", "good", 190.00f);
        comix[2].setPrice((Float) quality.get(comix[2].condition));

        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                String title = mTitle.getText().toString();
                String issueNum = mIssueNum.getText().toString();
                String condition = mCondition.getText().toString();
                float basePrice = Float.parseFloat(mBasePrice.getText().toString());

                comix[3] = new Comic(title, issueNum, condition, basePrice);
                comix[3].setPrice((Float) quality.get(comix[3].condition));



                for (int i = 0; i < comix.length; i++) {
                    System.out.println("Title: " + comix[i].title);
                    System.out.println("Issue: " + comix[i].issueNum);
                    System.out.println("Condition: " + comix[i].condition);
                    System.out.println("Price: $" + comix[i].price + "\n");
                    mResultText.setText("Current Price: $" + comix[i].price);
                }

            }
        });
    }

    class Comic {
        String title;
        String issueNum;
        String condition;
        float basePrice;
        float price;

        Comic(String inTitle, String inIssueNum, String inCondition, float inBasePrice) {
            title = inTitle;
            issueNum = inIssueNum;
            condition = inCondition;
            basePrice = inBasePrice;
        }

        void setPrice(float factor) {
            price = basePrice * factor;
        }
    }
}











