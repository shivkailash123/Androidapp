package com.example.shivkailash.finalwala;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Activity {
    DatabaseHalper helper =new DatabaseHalper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }
public void onSignUpClick(View v) {
    if (v.getId() == R.id.Bsignupbutton)
    {
        EditText name=(EditText )findViewById(R.id.TFname);
        EditText email=(EditText )findViewById(R.id.TFemail);
        EditText Uname=(EditText )findViewById(R.id.TFuname);
        EditText pass1=(EditText )findViewById(R.id.TFpass1);
        EditText pass2=(EditText )findViewById(R.id.TFpass2);
        String namestr=name.getText().toString();
        String emailstr=email.getText().toString();
        String unamestr=Uname.getText().toString();
        String pass1str=pass1.getText().toString();
        String pass2str=pass2.getText().toString();
        if(!pass1str.equals(pass2str)){
            Toast pass =Toast.makeText(SignUp.this,"password dont match!",Toast.LENGTH_SHORT);
            pass.show();
        }
        else
        {
            Contact c= new Contact();
            c.setName(namestr);
            c.setEmail(emailstr);
            c.setUname(unamestr);
            c.setPass(pass1str);
            helper.insertContact(c);
            Toast pass =Toast.makeText(SignUp.this,"Registration sucessfull",Toast.LENGTH_SHORT);
            pass.show();

            /****** Create Thread that will sleep for 5 seconds****/
            Thread background = new Thread() {
                public void run() {
                    try {
                        // Thread will sleep for 5 seconds
                        sleep(1*1000);

                        // After 5 seconds redirect to another intent
                        Intent i=new Intent(getBaseContext(),Login.class);
                        startActivity(i);

                        //Remove activity
                        finish();
                    } catch (Exception e) {
                    }
                }
            };
            // start thread
            background.start();

        }
    }
    }
}
