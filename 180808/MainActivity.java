package com.example.ppp180312.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn;
    String result;
    TextView tv;
/*
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this,"onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this,"onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this,"onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this,"onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this,"onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this,"onRestart", Toast.LENGTH_SHORT).show();
    }


*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //


        //poi();
        //poi2();
        poi3();
        page2();
        page3();
        poi4();

    }

    private void poi4() {
        result="";
        tv=findViewById(R.id.textView3);
        tv.setText("poi4");
        btn = findViewById(R.id.button5_list);
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){
            try{
                //List arr = Arrays.asList("1", 2.2, 3);
                List arr=new ArrayList();

                arr.add("aaa");
                arr.add("aaa02");
                arr.add("aaa03");
                arr.add(4);
                arr.add(true);
                arr.add(null);
                arr.add(0);

                result+="大小="+arr.size()+"\r\n";
                for(int i=0;i<arr.size();i++){
                    result+=arr.get(i)+"\r\n";
                }

            }
            catch(Exception e){
                result+=e.getMessage();
            }
            finally {
                tv.setText(result);
            }

        }});


    }

    private void page3() {
        btn = findViewById(R.id.button_sql);
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this  , Page3.class);
            startActivity(intent);
        }});
    }


    private void page2() {
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this  , Main2Activity.class);
            startActivity(intent);
        }});

    }

    private void poi3() {
        result="";
        //result+=this.getClass().toString();
        result+=this.getApplication()+"\r\n";
        result+=this.getApplicationContext()+"\r\n";
        btn = findViewById(R.id.button3);
        //btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){}});
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){
            if(1==0){
                Toast.makeText(MainActivity.this,""+result, Toast.LENGTH_SHORT).show();
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("對話視窗");
                builder.setMessage("這是一個對話視窗"+"\r\n"+result);
                //new DialogInterface.OnClickListener(){}
                builder.setPositiveButton("是",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "yes",Toast.LENGTH_SHORT).show();
                    }});
                builder.setNegativeButton("否",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "no",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("取消",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(MainActivity.this, "???",Toast.LENGTH_SHORT).show();
                        new AlertDialog.Builder(MainActivity.this).setMessage("訊息" ).show();
                    }
                });
                builder.show();
            }
        }});
    }//poi3(

    private void poi2() {
        OnClickListener ClickHere = new OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        };



        btn = findViewById(R.id.button3);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                result="";
                result +="id="+btn.getId()+"\r\n";
                result +="top="+btn.getTop()+"\r\n";
                result +="left="+btn.getLeft()+"\r\n";
                result +="test="+btn.getText()+"\r\n";

                //AlertDialog.Builder MyAlertDialog = new AlertDialog.Builder(this);
                //com.example.ppp180312.myapplication.MainActivity.this
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("對話視窗");
                builder.setMessage("這是一個對話視窗"+"\r\n"+result);
                builder.show();
                //AlertDialog dialog = builder.create();

            }
        } );

    }//poi2(

    public void poi() {
        btn = findViewById(R.id.button3);
        result="";
        result +="id="+btn.getId()+"\r\n";
        result +="top="+btn.getTop()+"\r\n";
        result +="left="+btn.getLeft()+"\r\n";
        result +="test="+btn.getText()+"\r\n";

        btn.setOnClickListener(new OnClickListener() {
            //btn.setOnClickListener(new OnClickListener() {
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
                //MainActivity.this
                //view.getContext()
                //getApplicationContext()

                Toast toast = Toast.makeText(MainActivity.this,""+result, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });
    }//poi(
}
