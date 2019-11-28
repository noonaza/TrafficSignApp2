package com.example.trafficsignapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    Button moreinfoButton, aboutButton;
    ListView listView;
    String[] titleStrings, detailStrings,subStrings;
    int[] ints = new int[]{R.drawable.traffic_01,R.drawable.traffic_02,R.drawable.traffic_03,R.drawable.traffic_04,R.drawable.traffic_05,R.drawable.traffic_06,R.drawable.traffic_07,R.drawable.traffic_08
            ,R.drawable.traffic_08,R.drawable.traffic_09,R.drawable.traffic_10,R.drawable.traffic_11,R.drawable.traffic_12,R.drawable.traffic_13,R.drawable.traffic_14,R.drawable.traffic_15
            ,R.drawable.traffic_16,R.drawable.traffic_17,R.drawable.traffic_18,R.drawable.traffic_19,R.drawable.traffic_20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        //get ค่าข้อมูล จาก DB
        titleStrings = getResources().getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);

        //Sub
        subStrings = new String[detailStrings.length];
        for (int i = 0; i < detailStrings.length; i++)   {
            subStrings[i] = detailStrings[i].substring(0, 20)+"...";
        }

        //นับข้อมูลไปส่งผลบน listview
        Mydapter mydapter = new Mydapter(MainActivity.this,ints,titleStrings,subStrings);
        listView.setAdapter(mydapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,Detail.class);
                intent.putExtra("Icon", ints[i]);
                intent.putExtra("Title", titleStrings[i]);
                intent.putExtra("Detail", detailStrings[i]);
                startActivity(intent);
            }
        });

        moreinfoButton = findViewById(R.id.btn_moreinfo);
        aboutButton = findViewById(R.id.btn_about);


        moreinfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moreinfoIntent = new Intent(Intent.ACTION_VIEW);
                moreinfoIntent.setData(Uri.parse("https://www.dlt.go.th/th/"));
                startActivity(moreinfoIntent);
            }
        });

        aboutButton = findViewById(R.id.btn_about);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutIntent = new Intent(MainActivity.this, Aboutme.class);
                startActivity(aboutIntent);
            }
        });



    }//end class onCreate
}//end class Main
