package com.tudose.mihai.mobileecloud;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGM=(Button)findViewById(R.id.Btn_maps);




        btnGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, MapsActivity.class);
                myIntent.putExtra("key", "ciao"); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });
        Button btnFB=(Button)findViewById(R.id.btn_fb);
        btnFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
