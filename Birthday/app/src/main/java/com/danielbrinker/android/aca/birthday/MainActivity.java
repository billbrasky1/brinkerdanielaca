package com.danielbrinker.android.aca.birthday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    String Birthday; {

        String date = new String ("MM/DD/YYYY");
        System.out.println("Month:");
        System.out.println(date.substring(0, 2));
        System.out.println("Day:");
        System.out.println(date.substring(3, 5));
        System.out.println("Year:");
        System.out.println(date.substring(6, 10));
        System.out.println("You won't make it to the next year!");

    }

    }
}

