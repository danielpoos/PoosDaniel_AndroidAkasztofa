package com.example.akasztofa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.RandomAccess;

public class MainActivity extends AppCompatActivity {
    private Button plus, minus, guessButton;
    private TextView guessTV, solutionTV;
    private ImageView hangman;
    private Random r;
    private char guessedChar;
    private char[] abc; //35
    private int guessCounter;
    private String[] words = {"január", "február", "március", "április", "május", "június", "július", "augusztus", "szeptember", "október", "november", "december"};
    private String randomWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
        guessButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });

    }
    public void init(){
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        guessButton = findViewById(R.id.guessbutton);
        guessTV = findViewById(R.id.a);
        solutionTV = findViewById(R.id.solution);
        hangman = findViewById(R.id.picture);
        abc = "aábcdeéfghiíjklmnoóöőpqrstuúüűvwxyz".toUpperCase().toCharArray();
        randomWord = words[r.nextInt()*12];
    }
    public void setBasicSolutionTV(){
        int numberOfChar = randomWord.length();
        String s = "";
        for (int i = 0; i < numberOfChar; i++) {
            s += "_ ";
        }
        solutionTV.setText(s);
    }
}