package com.danielbrinker.android.aca.pong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by danielbrinker on 10/5/16.
 */

public class TryAgain extends Activity{




        private Button mTryAgainButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            setContentView(R.layout.tryagain);

            mTryAgainButton = (Button) findViewById(R.id.tryAgainButton);


            mTryAgainButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(TryAgain.this, MainActivity.class);
                    //  Intent intent = new Intent(WelcomeScreen.this,MainActivity.class);
                    startActivity(intent);


                }
            });

        }



}
