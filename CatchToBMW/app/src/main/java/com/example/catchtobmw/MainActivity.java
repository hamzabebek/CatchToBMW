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

public class MainActivity extends AppCompatActivity {

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
                int randomX = new Random().nextInt(1000 - 0) + 0;
                int randomY = new Random().nextInt(1000 - 0) + 0;
                handler.postDelayed(this, 700);
                bmwlogo.setX(randomX);
                bmwlogo.setY(randomY);
            }
        };
        handler.post(run);

        new CountDownTimer(21000, 1000) {
            @Override
            public void onTick(long l) {
                timeText.setText("Time Left : " + l / 1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("Time Off");
                handler.removeCallbacks(run);
                bmwlogo.setVisibility(View.INVISIBLE);
                AlertDialog.Builder oyunsonu = new AlertDialog.Builder(MainActivity.this);
                oyunsonu.setTitle("Time is Off");
                oyunsonu.setMessage("İf you want to get next level please click on ' Next Level' or click on 'Play Again' and play this level again.");
                oyunsonu.setPositiveButton("Next Level", (dialogInterface, i) -> {
                    Intent bolum2 = new Intent();
                    bolum2.setClass(MainActivity.this,bolum2.class);
                    startActivity(bolum2);
                });
                oyunsonu.setNegativeButton("Play Again", (dialogInterface, i) -> {
                    Intent anabolum = getIntent();
                    finish();
                    startActivity(anabolum);
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