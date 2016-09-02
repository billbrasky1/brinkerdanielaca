package com.danielbrinker.android.aca.daysinyear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.danielbrinker.android.aca.daysinyear.utils.DayCounter;


public class MainActivity extends AppCompatActivity {


    DayCounter mDayCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDayCounter = new DayCounter();
        /* David usually initializes it in the next block of code.
            Not before this block. Otherwise, it uses up system resources.
            It would be possible to do so, however.

        */
        int year = 2016;

        for (int month = 1; month < 13; month++) {
            for (int day = 1; day <= mDayCounter.countDays(month, year); day++) {
                System.out.println(month + "/" + day + "/" + year);
            }


        }


    }


}
