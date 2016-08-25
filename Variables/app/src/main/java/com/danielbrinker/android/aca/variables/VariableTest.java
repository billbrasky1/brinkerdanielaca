package com.danielbrinker.android.aca.variables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VariableTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable_test);

        byte numerito = 1;
        System.out.println("This is a byte.");
        short numero = 20;
        System.out.println("This is a short.");
        int entero = 30;
        System.out.println("This is an integer.");
        long largo = 400000;
        System.out.println("Right here we have a long type.");
        float flotador = 4.5f;
        System.out.println("This is a float.");
        double doble = 4000000000.5555d;
        System.out.println("This on is a double.");
        boolean booleano = true;
        System.out.println("In Apple speak, that thar be a bool type.");
        char caracter = '~';
        System.out.println("This one's quite the character.");
    }
}
