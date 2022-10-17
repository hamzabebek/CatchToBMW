package com.example.catchtobmw;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class bolum2 extends AppCompatActivity {

    TextView scoreText;
    TextView timeText;
    int score;
    ImageView bmwlogo;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeText = findViewById(R.id.timeText);
        scoreText = findViewById(R.id.scoreText);
        bmwlogo = findViewById(R.id.imageView);
        score = 0;
        Runnable run = new Runnable() {
            @Override
            public void run() {
                int randomX = new Random().nextInt(800);
                int randomY = new Random().nextInt(800);
                handler.postDelayed(this, 400);
                bmwlogo.setX(randomX);
                bmwlogo.setY(randomY);
            }
        };
        handler.post(run);

        new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                timeText.setText("Time Left : " + l / 1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("Time Off");
                handler.removeCallbacks(run);
                bmwlogo.setVisibility(View.INVISIBLE);
                AlertDialog.Builder oyunsonu = new AlertDialog.Builder(bolum2.this);
                oyunsonu.setTitle("GAME İS OVER");
                oyunsonu.setMessage("Game is over please back to main menu or play again.");
                oyunsonu.setPositiveButton("Main menu", (dialogInterface, i) -> {
                    Intent girisekrani = new Intent();
                    girisekrani.setClass(bolum2.this,girisekrani.class);
                    startActivity(girisekrani);
                });
                oyunsonu.setNegativeButton("Play Again", (dialog, which) -> {
                    Intent yeniden = getIntent();
                    finish();
                    startActivity(yeniden);
                });
                oyunsonu.show();
            }

        }.start();
    }

    public void skorver(View view) {
        score = score + 1;
        scoreText.setText("Score : " + score);
    }

}