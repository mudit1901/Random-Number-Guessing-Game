package com.example.randomnumberguessinggame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int randomNumber = 0;
    private EditText editText;
    private TextView textView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.butoon1);

        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText variable = (EditText) findViewById(R.id.input);
                textView = findViewById(R.id.output);
                int Mudit = Integer.parseInt(variable.getText().toString());
                if (randomNumber == Mudit) {
                    textView.setText("Congratulations," + " You Got the Number");

                    Toast.makeText(MainActivity.this, "Thank You Playing Game", Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    // Set the message show for the Alert time
                    builder.setMessage("Do you want PlayAgain?");

                    // Set Alert Title
                    builder.setTitle("Alert !");

                    // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                    builder.setCancelable(false);

                    //For Positive Button Clicked
                    builder.setPositiveButton("PlayAgain", (DialogInterface.OnClickListener) (dialog, which) -> {
                        // When the user click yes button then app will close
                        Intent intent=getIntent();
                        finish();
                        startActivity(intent);
                    });

                    //For Negative Button Clicked
                    builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                        // If user click no then dialog box is canceled.
                        finish();
                    });


                    AlertDialog alertDialog = builder.create();

                    alertDialog.show();

                } else if (randomNumber < Mudit) {

                    textView.setText("Try Lower Number");
                } else {
                    textView.setText("Try Higher Number");
                }
            }
        });

    }

}