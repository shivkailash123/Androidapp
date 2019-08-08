package com.example.shivkailash.finalwala;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Video extends AppCompatActivity {
    int[] IMAGES={R.drawable.banana,R.drawable.grapes,R.drawable.pome,R.drawable.organic,R.drawable.sunflower};
    String[] NAMES={"BANANA","GRAPES","POMEGRANETES","ORGANIC FARMING","SUNFLOWER"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videov);
        ListView listView=(ListView)findViewById(R.id.listView);
        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if ((i==0)){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=gaMqJfH8yXE"));
                    startActivity(browserIntent);
                }
                else if((i==1)){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=-huCxDl80lg"));
                    startActivity(browserIntent);
                }
                else if((i==3)){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=7kOY9RyFrLo"));
                    startActivity(browserIntent);
                }
            }

        });

    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view =getLayoutInflater().inflate(R.layout.custom,null);
            ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
            TextView textView_name=(TextView)view.findViewById(R.id.textView_name);
            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            return view;
        }
    }
    public void process(){

    }
}
