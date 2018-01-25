package com.a.aman.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText enterNumber;

    int randomNumber;

    public void makeToast(String string) {

        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterNumber = (findViewById(R.id.idEtEnterNumber));


        Button guessButton = (findViewById(R.id.idBtGuess));

        final Random rNumber = new Random();
        randomNumber = rNumber.nextInt(20) + 1;

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                int guessInt = 0;
                try {
                    guessInt = Integer.parseInt(enterNumber.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "enter number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (guessInt > randomNumber) {
                    makeToast("higher");
                } else if (guessInt < randomNumber) {
                    makeToast("lower");
                } else {

                    makeToast("That's right! Try again");
                    randomNumber = rNumber.nextInt(20) + 1;

                }


            }


        });
    }
}
