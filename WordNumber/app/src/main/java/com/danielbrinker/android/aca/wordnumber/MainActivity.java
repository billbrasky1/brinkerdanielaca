package com.danielbrinker.android.aca.wordnumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

                long num = 0;
                char firstChar = mEditText.getText().toString().toLowerCase().charAt(0); //eualsIgnore, is that working?
                char secondChar = mEditText.getText().toString().toLowerCase().charAt(1);

                switch (firstChar) {
                    case 'o':
                        num = 1L;
                        break;
                    case 't':
                        if (secondChar == 'w') {

                            num = 2L;
                        } else if (secondChar == 'h') {
                            num = 3L;
                        } else if (secondChar == 'e') {
                            num = 10L;
                        }
                        break;
                    case 'f':
                        if (secondChar == 'o') {

                            num = 4L;
                        } else if (secondChar == 'i') {
                            num = 5L;
                        }
                        break;
                    case 's':
                        if (secondChar == 'i') {

                            num = 6L;
                        } else if (secondChar == 'e') {
                            num = 7L;
                        }
                        break;
                    case 'e':
                        num = 8L;
                        break;
                    case 'n':
                        num = 9L;
                        break;

                        //You don't need a 'break;' here since this is the last one. I could put a default though.
                    /* You could do it like this:
                    case 'n':
                    num = 9L;
                    break;
                    mResultText.setText("Don't you know your numbers, yo?");
                    */
                }
                mResultText.setText(num + "");
                    if (num == 0) {
                            mResultText.setText("Try Again");
                    } else  mResultText.setText(num + "");



            }
        });

    }
}














   /* System.out.println("Type out the word for number, one through ten: ");
    char numberGiven = numberGiven.next().charAt(0);
    char numberGiven = numberGiven.next().charAt(1);
char numberGiven = numberGiven.charAt(0,1);
    switch(numberGiven)

    {
        case‘on ':
        System.out.println("1");
        break;
        case‘tw’:
        System.out.println("2");
        break;
        case‘th’:
        System.out.println(“3”);
        break;
        case‘fo’:
        System.out.println(“4”);
        break;
        case‘fi’:
       System.out.println(“5”);
        break;
        case‘si’:
        System.out.println(“6”);
        break;
        case‘se’:
        System.out.println(“7”);
        break;
        case‘ei’:
        System.out.println(“8”);
        break;
        case‘ni’:
        System.out.println(“9”);
        break;
        case‘te’:
        System.out.println(“10”);
        break;
        default:
            System.out.println(“Please spell out a number that is one through ten”);
    }
    });
}

}
*/