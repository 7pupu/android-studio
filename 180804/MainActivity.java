package com.example.ppp180312.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //


        poi();
    }

    public void poi() {
        btn = (Button)findViewById(R.id.button3);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
/*
Toast.LENGTH_SHORT持續2秒
Toast.LENGTH_LONG 持續 3.5秒
*/
                //Toast.makeText(MainActivity.this,"Hello world!", Toast.LENGTH_SHORT).show();
/*
Gravity.TOP　　 ：上
Gravity.BOTTOM：下
Gravity.LEFT　   ：左
Gravity.RIGHT　：右
Gravity.CENTER ：中
*/
                Toast toast = Toast.makeText(MainActivity.this,"Hello world!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });
    }
}
