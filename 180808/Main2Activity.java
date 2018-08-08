package com.example.ppp180312.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends Activity {
    Button btn;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //
        page();
    }


    private void page() {
        btn = findViewById(R.id.button2);
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(Main2Activity.this  , MainActivity.class);
            startActivity(intent);
        }});

    }


}
