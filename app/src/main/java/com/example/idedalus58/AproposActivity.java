package com.example.idedalus58;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class AproposActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apropos);

        // pour la fleche en haut a gauche pour le retour:

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar .setDisplayHomeAsUpEnabled(true);
    }


}
