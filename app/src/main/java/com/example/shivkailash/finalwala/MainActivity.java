package com.example.shivkailash.finalwala;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.BaseAdapter;

public class MainActivity extends AppCompatActivity {
    public Button button;
    int[] IMAGES={R.drawable.news,R.drawable.grapes,R.drawable.pome};
    String[] NAMES={"BANANA","GRAPES","POMEGRANETES"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView)findViewById(R.id.listView);



        }
    public void openn(View view){
    if(view.getId()==R.id.videohai) {
        Intent videoActivity=new Intent(this, Video.class);
        startActivity(videoActivity);
    }
        if(view.getId()==R.id.newhai) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.agriland.ie/latest-farming-news/"));
            startActivity(browserIntent);
        }
        if(view.getId()==R.id.planthai){
        Intent practiceActivity=new Intent(this,practice.class);
        startActivity(practiceActivity);
        }
        if(view.getId()==R.id.jaihohai){
        Intent chatActivity=new Intent(this,mail.class);
        startActivity(chatActivity);
        }

    }

}
