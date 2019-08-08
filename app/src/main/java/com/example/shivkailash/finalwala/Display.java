package com.example.shivkailash.finalwala;

import android.app.Activity;
import android.os.Bundle;

public class Display extends Activity {
    @Override
    protected void onCreate(Bundle savedInstannceState){
        super.onCreate(savedInstannceState);
        setContentView(R.layout.dispaly);
        String username = getIntent().getStringExtra("Username");



    }
}
