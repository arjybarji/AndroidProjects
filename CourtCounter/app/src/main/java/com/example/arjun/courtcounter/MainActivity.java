package com.example.arjun.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int teamAScore = 0;
    int teamBScore = 0;

    public void displayScore() {
        TextView aScore = (TextView) findViewById(R.id.teamAScoreView);
        aScore.setText("" + teamAScore);
        TextView bScore = (TextView) findViewById(R.id.teamBScoreView);
        bScore.setText("" + teamBScore);

    }

    public void add3ToA(View view) {
        teamAScore = teamAScore + 3;
        displayScore();
    }

    public void add2ToA(View view) {
        teamAScore = teamAScore + 2;
        displayScore();
    }

    public void add1ToA(View view) {
        teamAScore = teamAScore + 1;
        displayScore();
    }

    public void add3ToB(View view) {
        teamBScore = teamBScore + 3;
        displayScore();
    }

    public void add2ToB(View view) {
        teamBScore = teamBScore + 2;
        displayScore();
    }

    public void add1ToB(View view) {
        teamBScore = teamBScore + 1;
        displayScore();
    }

    public void reset(View view){
        teamAScore = 0;
        teamBScore = 0;
        displayScore();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
