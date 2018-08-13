package com.example.ppp180312.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

/*
購物車
資料儲存在SharedPreferences
*/
public class Main3Activity extends AppCompatActivity {
    String result;
    Button btn;
    TextView tv;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //
        poi();
        //
        result="";
        tv=(TextView)findViewById(R.id.textView4);

        SharedPreferences myprefs = getSharedPreferences("mydata" ,MODE_PRIVATE);
        Set words =new HashSet();
        words.add("111");
        words.add("宿你媽懶覺啦");
        words.add("反正,也,吃不死人");
        words.add(new person("Justin", "B835031"));

        for(Object token : words) {
            result+="\r\n"+token;
        }
        tv.setText(result);
        //myprefs.edit().putStringSet("字串集合",words);
    }

    private void poi() {
        btn = findViewById(R.id.button_back);
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){
            //Intent intent = new Intent();
            //intent.setClass(Main2Activity.this  , Main3Activity.class);
            //startActivity(intent);
            Main3Activity.this.finish();//返回上一頁
        }});
    }
}

class person {
    private String name;
    private String number;
    person(String name, String number) {
        this.name = name;
        this.number = number;
    }
    @Override
    public String toString()  {
        return String.format("(%s, %s)", name, number);
    }
}

