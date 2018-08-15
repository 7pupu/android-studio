package com.example.ppp180312.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    String result;
    TextView tv;
    ///
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        try{if(1==1){}}
        catch (Exception e){}
        //
        try{if(1==1){
            result="";
            result+="\r\n"+this.getFilesDir();
            String fname=new File(getFilesDir(), "ppp.png").getAbsolutePath();
            result+="\r\n"+fname;

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;

            Bitmap bMap = BitmapFactory.decodeFile(fname,options);
            result+="\r\n"+options.outWidth +"x"+options.outHeight;

            //this.getResources();

            //Toast toast = Toast.makeText(MainActivity.this,""+result, Toast.LENGTH_LONG);
            //toast.show();
            tv = (TextView)findViewById(R.id.aaa);
            tv.setText(""+result);

        }}
        catch (Exception e){
            result="";
            result+="\r\n"+e.getClass();
            result+="\r\n"+e.getMessage();

            Toast toast = Toast.makeText(MainActivity.this,""+result, Toast.LENGTH_LONG);
            toast.show();

        }

        //
        try{if(1==0){
            TextView textDrawable = (TextView) findViewById(R.id.aaa);
            Drawable drawableLeft = getResources().getDrawable(R.drawable.ppp);
            textDrawable.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,null, null, null);
            textDrawable.setCompoundDrawablePadding(4);
        }
        }
        catch (Exception e){

        }

        //




    }
}
