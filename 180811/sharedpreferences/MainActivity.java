package com.example.ppp180312.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String result;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        result="";
        tv=(TextView)findViewById(R.id.textView);
        SharedPreferences mypref = getSharedPreferences("mydata" ,MODE_PRIVATE);
        mypref.edit().putString("名稱","內容").commit();//.apply();
        mypref.edit().putString("222","bbb").commit();
        result+="\r\n"+mypref.getString("名稱","資料為空時的回傳內容");

        Map<String, ?> map = mypref.getAll();
        for(Map.Entry<String,?> entry : map.entrySet()){
            //Log.d("map values",entry.getKey() + ": " + entry.getValue().toString());
            result+="\r\n"+entry.getKey()+","+entry.getValue().toString();
        }

        tv.setText(""+result);



    }
}
