package com.example.catchtobmw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class bolumler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolumler);
    }

    public void bolum1(View view) {
        Intent bolum1 = new Intent();
        bolum1.setClass(bolumler.this,MainActivity.class);
        startActivity(bolum1);
    }

    public void bolum2(View view) {
        Intent bolum2 = new Intent();
        bolum2.setClass(bolumler.this,bolum2.class);
        startActivity(bolum2);
    }
}