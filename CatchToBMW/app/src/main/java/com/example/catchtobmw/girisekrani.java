package com.example.catchtobmw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class girisekrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girisekrani);
    }

    public void baslat (View view) {
        Intent gecis = new Intent();
        gecis.setClass(girisekrani.this,MainActivity.class);
        startActivity(gecis);
    }

    public void bolumler (View view) {
        Intent bolumler = new Intent();
        bolumler.setClass(girisekrani.this,bolumler.class);
        startActivity(bolumler);

    }
}