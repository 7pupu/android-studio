package com.example.ppp180312.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String result;
    Button btn;
    TextView tv;
    EditText et;
    int init=0;
    //
    SQLiteDatabase db;

    //
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this,"onStart", Toast.LENGTH_SHORT).show();
        //
        DisplayMetrics monitorsize =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(monitorsize);
        result="寬x高="+monitorsize.widthPixels+"x"+ monitorsize.heightPixels;
        tv=(TextView)findViewById(R.id.textView);
        tv.setText(""+result);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(MainActivity.this,"onCreate", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        //
        poi();//
        //
        tv=(TextView)findViewById(R.id.textView2);
        result="";
        for(int i=0;i<100;i++){
            result+="\r\n"+"中文"+i;
        }
        tv.setText(""+result);

        //poi();
        tv=(TextView)findViewById(R.id.textView3);
        result="";
        try {
            myDBHelper dbService= new myDBHelper(this);
            db = dbService.getWritableDatabase();
            result+="db.getVersion()=";
            result+=db.getVersion()+"\r\n";
            result+="db.getPageSize()=";
            result+=db.getPageSize()+"\r\n";
            result+="db.getMaximumSize()=";
            result+=db.getMaximumSize()+"\r\n";

            if(db.isOpen()){db.close();}
        }
        catch (Exception e){
            Toast.makeText(this,""+e.getMessage(), Toast.LENGTH_SHORT).show();
            result+="\r\n"+e.getClass();
            result+="\r\n"+e.getMessage();
        }
        finally {
            tv.setText(""+result);
        }

    }

    private void poi() {
        btn = findViewById(R.id.button_page);
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this  , Main2Activity.class);
            startActivity(intent);
        }});
        btn = findViewById(R.id.button_cart);
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this  , Main3Activity.class);
            startActivity(intent);
        }});
    }


}


