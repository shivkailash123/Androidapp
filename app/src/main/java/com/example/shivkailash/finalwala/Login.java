package com.example.shivkailash.finalwala;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    DatabaseHalper helper = new DatabaseHalper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }


    public void onButtonClick(View v) {
        if (v.getId() == R.id.Blogin) {
            EditText a = (EditText) findViewById(R.id.TFusername);
            String str = a.getText().toString();

            EditText b = (EditText) findViewById(R.id.TFpassword);
            String pass = b.getText().toString();


            String password = helper.searchPass(str);

            if (pass.equals(password)) {
                Intent i = new Intent(Login.this, MainActivity.class);
                i.putExtra("Username", str);
                startActivity(i);
            } else {
                Toast temp = Toast.makeText(Login.this, "Username and Password don't match!", Toast.LENGTH_SHORT);
                temp.show();
            }
        }
            if (v.getId() == R.id.Bsignup) {
                Intent i = new Intent(Login.this, SignUp.class);

                startActivity(i);
            }
        }
    }

