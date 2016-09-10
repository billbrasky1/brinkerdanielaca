package com.danielbrinker.android.aca.holidayschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.BitSet;

public class MainActivity extends AppCompatActivity {

    public Button mConvertButton;
    public EditText mMonthSlot;
    public EditText mDay;
    public TextView mResultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mConvertButton = (Button) findViewById(R.id.convertButton);
        mMonthSlot = (EditText) findViewById(R.id.editText);
        mDay = (EditText) findViewById(R.id.editText2);
        mResultText = (TextView) findViewById(R.id.resultText);


        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int month = Integer.parseInt(mMonthSlot.getText().toString());
                int date = Integer.parseInt(mDay.getText().toString());
                mResultText.setText(countDays(month) + date + "");


                HolidaySchedule cal = new HolidaySchedule();
                if (cal.isHoliday(countDays(month) + date)) {
                    mResultText.setText("It's a Holiday.");
                } else if (!cal.isHoliday(countDays(month) + date)){
                    mResultText.setText("Nice try. Not a Holiday.");
                }
            }

        });

    }

    private int countDays(int month) {
        int count = 877;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;
            case 2:
                count = 28;
                break;
        }
        return count;

    }



    public class HolidaySchedule {
        BitSet sked;

        public HolidaySchedule() {
            sked = new BitSet(365);
            int[] holiday = { 1, 15, 50, 148, 185, 246,
                    281, 316, 326, 359 };

            for (int i = 0; i < holiday.length; i++) {
                addHoliday(holiday[i]);
            }
        }

        public void addHoliday(int dayToAdd) {
            sked.set(dayToAdd);
        }

        public boolean isHoliday(int dayToCheck) {
            return sked.get(dayToCheck);
        }
    }



}
