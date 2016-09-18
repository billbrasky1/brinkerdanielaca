package com.danielbrinker.android.aca.magicball;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {


    public TextView mTheAnswer; //The random output
    private final static float ACC = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTheAnswer = (TextView) findViewById(R.id.theAnswer);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random randGenerator = new Random();

                int ourRandomNumber = randGenerator.nextInt(21);
                String ninesAnswer;


                switch(ourRandomNumber)

                {
                    case 1:
                        ninesAnswer = "It is decidedly so";
                        break;
                    case 2:
                        ninesAnswer = "Without a doubt";
                        break;
                    case 3:
                        ninesAnswer = "Yes, definitely";
                        break;
                    case 4:
                        ninesAnswer = "You may rely on it";
                        break;
                    case 5:
                        ninesAnswer = "As I see it, yes";
                        break;
                    case 6:
                        ninesAnswer = "Most likely";
                        break;
                    case 7:
                        ninesAnswer = "Outlook good";
                        break;
                    case 8:
                        ninesAnswer = "Yes";
                        break;
                    case 9:
                        ninesAnswer = "Signs point to yes";
                        break;
                    case 10:
                        ninesAnswer = "Reply hazy try again";
                        break;
                    case 11:
                        ninesAnswer = "Ask again later";
                        break;
                    case 12:
                        ninesAnswer = "Better not tell you now";
                        break;
                    case 13:
                        ninesAnswer = "Cannot predict now";
                        break;
                    case 14:
                        ninesAnswer = "Concentrate and ask again";
                        break;
                    case 15:
                        ninesAnswer = "Don't count on it";
                        break;
                    case 16:
                        ninesAnswer = "My reply is no";
                        break;
                    case 17:
                        ninesAnswer = "My sources say no";
                        break;
                    case 18:
                        ninesAnswer = "Outlook not so good";
                        break;
                    case 19:
                        ninesAnswer = "Very doubtful";
                        break;
                    case 20:
                        ninesAnswer = "It is certain";
                        break;

                    default:
                        ninesAnswer = "Nope";
                        break;
                }

                System.out.println(ninesAnswer);
                mTheAnswer.setText(ninesAnswer);
            }
        });

        SensorManager shakeTheDevice = (SensorManager) getSystemService(SENSOR_SERVICE);
        shakeTheDevice.registerListener(this,
                shakeTheDevice.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float[] values = sensorEvent.values;
        if ((Math.abs(values[0]) > ACC || Math.abs(values[1]) > ACC || Math
                .abs(values[2]) > ACC)) {
            Log.i("sensor", "running");
            showShakeReadout();
            Log.i("sensor", "running after");

            for (float i=0; i<200_000; i++) {

            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }


    private void showShakeReadout(){
        Random randGenerator = new Random();

        int ourRandomNumber = randGenerator.nextInt(21);
        String ninesAnswer;


        switch(ourRandomNumber)

        {
            case 1:
                ninesAnswer = "It is decidedly so";
                break;
            case 2:
                ninesAnswer = "Without a doubt";
                break;
            case 3:
                ninesAnswer = "Yes, definitely";
                break;
            case 4:
                ninesAnswer = "You may rely on it";
                break;
            case 5:
                ninesAnswer = "As I see it, yes";
                break;
            case 6:
                ninesAnswer = "Most likely";
                break;
            case 7:
                ninesAnswer = "Outlook good";
                break;
            case 8:
                ninesAnswer = "Yes";
                break;
            case 9:
                ninesAnswer = "Signs point to yes";
                break;
            case 10:
                ninesAnswer = "Reply hazy try again";
                break;
            case 11:
                ninesAnswer = "Ask again later";
                break;
            case 12:
                ninesAnswer = "Better not tell you now";
                break;
            case 13:
                ninesAnswer = "Cannot predict now";
                break;
            case 14:
                ninesAnswer = "Concentrate and ask again";
                break;
            case 15:
                ninesAnswer = "Don't count on it";
                break;
            case 16:
                ninesAnswer = "My reply is no";
                break;
            case 17:
                ninesAnswer = "My sources say no";
                break;
            case 18:
                ninesAnswer = "Outlook not so good";
                break;
            case 19:
                ninesAnswer = "Very doubtful";
                break;
            case 20:
                ninesAnswer = "It is certain";
                break;

            default:
                ninesAnswer = "Nope";
                break;
        }

        System.out.println(ninesAnswer);
        mTheAnswer.setText(ninesAnswer);
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
