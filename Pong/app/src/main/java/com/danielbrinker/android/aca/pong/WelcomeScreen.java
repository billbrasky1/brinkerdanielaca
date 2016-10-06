package com.danielbrinker.android.aca.pong;

/**
 * Created by danielbrinker on 10/5/16.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class WelcomeScreen extends Activity {

    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        mStartButton = (Button) findViewById(R.id.startButton);



        mStartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WelcomeScreen.this,MainActivity.class);
                startActivity(intent);


            }
        });

    }


}

  /*
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(WelcomeScreen.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        */