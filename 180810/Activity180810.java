package com.example.ppp180312.myapplication;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity180810 extends Activity {
    String result;
    Button btn;
    TextView tv;
    EditText et,et2;
    int cc=0;
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(Activity180810.this,"onStart", Toast.LENGTH_SHORT).show();
        //
        tv= (TextView)findViewById(R.id.textView5);
        et = (EditText)findViewById(R.id.editText);
        et.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                cc++;
                result="";
                et2=(EditText)view;
                et2.setBackgroundColor(Color.rgb(255,255,0));

                //Toast.makeText(Activity180810.this,"onTouch", Toast.LENGTH_SHORT).show();
                result+="\r\n"+cc;
                result+="\r\n"+"onTouch";
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        result+="\r\n"+"touched down";
                        result+="\r\n"+x+","+y;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        result+="\r\n"+"touched move";
                        result+="\r\n"+x+","+y;
                        break;
                    case MotionEvent.ACTION_UP:
                        result+="\r\n"+"touched up";
                        result+="\r\n"+x+","+y;
                        break;
                }
                tv.setText(""+result);
                //Toast.makeText(Activity180810.this,""+result, Toast.LENGTH_SHORT).show();

                //result+="\r\n"+view.toString();
                //AlertDialog.Builder builder = new AlertDialog.Builder(Activity180810.this);builder.setMessage(""+result);builder.show();

                return false;
            }
        });
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Toast.makeText(Activity180810.this,"beforeTextChanged", Toast.LENGTH_SHORT).show();
                result="beforeTextChanged";
                //AlertDialog.Builder builder = new AlertDialog.Builder(Activity180810.this);builder.setMessage(""+result);builder.show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(Activity180810.this,"onTextChanged", Toast.LENGTH_SHORT).show();
                result="onTextChanged";
                //AlertDialog.Builder builder = new AlertDialog.Builder(Activity180810.this);builder.setMessage(""+result);builder.show();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Toast.makeText(Activity180810.this,"afterTextChanged", Toast.LENGTH_SHORT).show();
                result="afterTextChanged";
                //AlertDialog.Builder builder = new AlertDialog.Builder(Activity180810.this);builder.setMessage(""+result);builder.show();
            }
        });
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_180810);
        //

    }

}
