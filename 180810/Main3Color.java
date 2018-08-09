package com.example.ppp180312.myapplication;

import android.app.AlertDialog;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main3Color extends AppCompatActivity {
    Button btn;
    String result;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_color);
        //
        result="";

        poi();
        poi2();


    }

    private void poi2() {
        btn=findViewById(R.id.button7);
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){  //}});
            result="";
            try{

                result+="\r\n"+"按下了"+v.getId();
                ConstraintLayout ll = (ConstraintLayout)findViewById(R.id.ooo);
                TextView tv = new TextView(Main3Color.this);
                //tv.setId(index++);
                tv.setText("Hello World");
                tv.setRight(10);
                ll.addView(tv);
                result+="\r\n"+"新增了一段TextView";
                ll.removeView((View) v);
                result+="\r\n"+"移除了按鈕";
            }
            catch (Exception e){
                result+="\r\n"+"錯誤";
                result+="\r\n"+e.getMessage();
                result+="\r\n"+e.getClass();
            }
            finally {
                AlertDialog.Builder builder=new AlertDialog.Builder(Main3Color.this);
                builder.setMessage(""+result).show();
            }
        }});

    }

    private void poi() {
/*
Color.BLACK
Color.BLUE
Color.CYAN
Color.DKGRAY
Color.GRAY
Color.GREEN
Color.LTGRAY
Color.MAGENTA
Color.RED
Color.TRANSPARENT
Color.WHITE
Color.YELLOW
* */
        tv = this.findViewById(R.id.textView4);
        result="";
        //result=""+getApplicationContext().getApplicationInfo();

        //tv.setTextColor(android.graphics.Color.RED);
        tv.setBackgroundColor(Color.rgb(255,255,0));
        int pp=Color.parseColor("#FF0000");
        //result=""+pp;
        tv.setTextColor(pp);
        tv.setTextSize(50);//14sp=default
        result=""+findViewById(R.id.all);


        AlertDialog.Builder builder = new AlertDialog.Builder(Main3Color.this);
        //builder.setTitle("對話視窗");
        builder.setMessage(""+result);
        //builder.show();


    }
}
