package com.example.ppp180312.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String result;
    Button btn;
    TextView tv;
    EditText et;
    int init=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        tv=(TextView)findViewById(R.id.textView2);
        result="";
        for(int i=0;i<200;i++){
            result+="\r\n"+"中文";
        }
        tv.setText(""+result);


    }
}
