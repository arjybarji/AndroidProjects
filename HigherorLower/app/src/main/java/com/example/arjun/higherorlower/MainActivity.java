package com.example.arjun.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int number;
    int score;

    public void buttonClicked(View view){
        EditText num = (EditText) findViewById(R.id.userEntry);
        String stringNum = num.getText().toString();
        int intNum = Integer.parseInt(stringNum);

        if (intNum > number){
            Toast.makeText(getApplicationContext(),"Too High",Toast.LENGTH_LONG).show();
        }else if(number > intNum){
            Toast.makeText(getApplicationContext(),"Too Low",Toast.LENGTH_LONG).show();
        }else{
            Random rand = new Random();
            number = rand.nextInt(16);
            score = score +1;
            TextView textView = (TextView) findViewById(R.id.score);
            textView.setText(score + "");
            Toast.makeText(getApplicationContext(),"CORRECT",Toast.LENGTH_LONG).show();
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = 0;
        TextView textView = (TextView) findViewById(R.id.score);
        textView.setText(0 + "");
        Random rand = new Random();
        number = rand.nextInt(16);

    }
}
