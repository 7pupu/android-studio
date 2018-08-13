package com.example.ppp180312.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
商品介紹
*/
public class Main2Activity extends AppCompatActivity {
    String result;
    Button btn;
    TextView tv;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //
        poi();
    }

    private void poi() {
        btn = findViewById(R.id.button_back);
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){
            //Intent intent = new Intent();
            //intent.setClass(Main2Activity.this  , Main3Activity.class);
            //startActivity(intent);
            Main2Activity.this.finish();//返回上一頁
        }});
    }
}
