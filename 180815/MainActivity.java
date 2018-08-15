package com.example.ppp180312.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
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
        try{if(1==0){
            result="";
            result+="\r\n"+this.getResources();
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
        try{if(1==1){
            result="";

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;

            //從檔案路徑
            //String fn=new File(getFilesDir(), "ppp.png").getAbsolutePath();
            //InputStream in = getContentResolver().openInputStream( Uri.parse(fn));
            //BitmapFactory.decodeStream(in, null, options);

            //BitmapFactory.decodeFile(fn,options);

            //從資源路徑
            //Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.ppp, options);
            options.inJustDecodeBounds = false;
            Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.ppp, options);

            result+="\r\n"+bmp;
            result+="\r\n"+options.outWidth +"x"+options.outHeight;
            result+="\r\n";


            String html="<img src='"+R.drawable.ppp+"' width='100' height='100'/>";
            //Spanned sp
            Html.ImageGetter ig =new Html.ImageGetter() {
                @Override
                public Drawable getDrawable(String source) {
                    int id = Integer.parseInt(source);
                    Drawable d = getResources().getDrawable(id);
                    //d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
                    d.setBounds(0, 0, d.getIntrinsicWidth() /2, d.getIntrinsicHeight() /2);
                    //d.setBounds(0, 0, 100, 100);

                    return d;
                }
            };
            //CharSequence charSequence = Html.fromHtml(html,ig, null);





            //this.getResources();

            //Toast toast = Toast.makeText(MainActivity.this,""+result, Toast.LENGTH_LONG);
            //toast.show();


            tv = (TextView)findViewById(R.id.aaa);
            tv.setText(""+result);
            tv.append(Html.fromHtml(html,ig, null));

        }}
        catch (Exception e){
            result="";
            result+="\r\n"+e.getClass();
            result+="\r\n"+e.getMessage();

            Toast toast = Toast.makeText(MainActivity.this,""+result, Toast.LENGTH_LONG);
            toast.show();

            tv = (TextView)findViewById(R.id.aaa);
            tv.setText(""+result);

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
