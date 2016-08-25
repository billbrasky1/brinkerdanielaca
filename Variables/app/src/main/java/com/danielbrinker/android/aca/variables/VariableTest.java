package com.danielbrinker.android.aca.variables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VariableTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable_test);

        byte numerito = 1;
        System.out.println("Numerito: " + numerito);
        short numero = 20;
        System.out.println("Numero: " + numero);
        int entero = 30;
        System.out.println("Entero: " + entero);
        long largo = 400000;
        System.out.println("Largo: " + largo);
        float flotador = 4.5f;
        System.out.println("Flotador: " + flotador);
        double doble = 4000000000.5555d;
        System.out.println("Doble: " + doble);
        boolean booleano = true;
        System.out.println("Booleano: " + booleano);
        char caracter = '~';
        System.out.println("Caracter: " + caracter);
    }
}
