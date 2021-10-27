package com.example.akasztofa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button plus, minus, guessButton;
    private TextView guessTV, solutionTV;
    private ImageView hangman;
    private Random r;
    private char[] abc; //35
    private int guessCounter;
    private final String[] words = {"január", "február", "március", "április", "május", "június", "július", "augusztus", "szeptember", "október", "november", "december"};
    private String randomWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                guessTV.setText(charPlus());
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                guessTV.setText(charMinus());
            }
        });
        guessButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                guessButtonPressed();
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
        guessCounter =0;
    }
    public void setBasicSolutionTV(){
        int numberOfChar = randomWord.length();
        String s = "";
        for (int i = 0; i < numberOfChar; i++) s += "_ ";
        solutionTV.setText(s);
    }
    public char charPlus(){
        char currentChar = guessTV.getText().toString().toCharArray()[0];
        int index = 0;
        if (currentChar == abc[abc.length-1]) return abc[0];
        for (int i = 0; i < abc.length; i++) {
            if(currentChar == abc[i]) index = i;
        }
        return abc[index+1];
    }
    public char charMinus(){
        char currentChar = guessTV.getText().toString().toCharArray()[0];
        int index = 0;
        if (currentChar == abc[0]) return abc[abc.length-1];
        for (int i = 0; i < abc.length; i++) {
            if(currentChar == abc[i]) index = i;
        }
        return abc[index-1];
    }
    public void guessButtonPressed(){
        String currentString = guessTV.getText().toString();
        String solChang = solutionTV.getText().toString();
        if (!(randomWord.toUpperCase().contains(currentString))) {
            //Toast.makeText(this, "Nincs benne illyen bettű ebben a szóban", Toast.LENGTH_SHORT);
            guessCounter++;
            switch (guessCounter){
                case 1: hangman.setImageResource(R.drawable.akasztofa01);break;
                case 2: hangman.setImageResource(R.drawable.akasztofa02);break;
                case 3: hangman.setImageResource(R.drawable.akasztofa03);break;
                case 4: hangman.setImageResource(R.drawable.akasztofa04);break;
                case 5: hangman.setImageResource(R.drawable.akasztofa05);break;
                case 6: hangman.setImageResource(R.drawable.akasztofa06);break;
                case 7: hangman.setImageResource(R.drawable.akasztofa07);break;
                case 8: hangman.setImageResource(R.drawable.akasztofa08);break;
                case 9: hangman.setImageResource(R.drawable.akasztofa09);break;
                case 10: hangman.setImageResource(R.drawable.akasztofa10);break;
                case 11: hangman.setImageResource(R.drawable.akasztofa11);break;
                case 12: hangman.setImageResource(R.drawable.akasztofa12);break;
                case 13:
                    hangman.setImageResource(R.drawable.akasztofa13);
                    //TODO: Alertdialopg
                break;
                default:break;
            }
        }
        else{
            for (int i= 0; i < randomWord.toCharArray().length; i++){
                if (randomWord.toCharArray()[i] == currentString.toCharArray()[0]){
                    solutionTV.setText(currentString.toCharArray(),i*2, 1);
                }
            }
        }
        solutionTV.setText(solChang);
    }

}