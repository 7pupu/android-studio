package com.example.ppp180312.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    String result;
    TextView tv;
    ImageView iv;
    Bitmap bmp;
    Toast toast;
    ///
    public void onWindowFocusChanged(boolean hasFocus){
        int width=iv.getWidth();
        int height=iv.getHeight();
        //
        Toast.makeText(MainActivity.this,"onWindowFocusChanged", Toast.LENGTH_LONG).show();

    }
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Toast.makeText(MainActivity.this,"onCreate", Toast.LENGTH_LONG).show();

        //
        try{if(1==1){}}
        catch (Exception e){}
        //
        try{if(1==1){
            iv = (ImageView) findViewById(R.id.imageView);
            //iv.setImageResource(R.drawable.p2);
            if(false){}
            if(false){
                bmp=BitmapFactory.decodeResource(getResources(),R.drawable.p2);//image is your image
                int width=100;
                int height=100;
                bmp=Bitmap.createScaledBitmap(bmp, width,height, true);
                iv.setImageBitmap(bmp);
                iv.setLayoutParams(new ConstraintLayout.LayoutParams(100, 100));

            }
            if(false){
                int width = iv.getDrawable().getIntrinsicWidth();
                int height = iv.getDrawable().getIntrinsicHeight();
                result+="\r\n"+width+"x"+height;
            }
            if(false){
                result+="\r\n"+ getResources().getDisplayMetrics().widthPixels;//寬
                result+="\r\n"+ getResources().getDisplayMetrics().heightPixels;//高
                result+="\r\n"+ getResources().getDisplayMetrics().density;//密度
                result+="\r\n"+ getResources().getDisplayMetrics().densityDpi;//dpi

            }
            if(false){
                DisplayMetrics mDisplayMetrics = new DisplayMetrics();// 先取得DisplayMetrics資訊
                getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
                result+="\r\n"+ mDisplayMetrics.widthPixels;// 手機的寬度(像素)
                result+="\r\n"+ mDisplayMetrics.heightPixels;// 手機的高度(像素)
                result+="\r\n"+ mDisplayMetrics.density;// 手機的密度
                result+="\r\n"+ mDisplayMetrics.densityDpi;// 手機的DPI

            }

            iv.post(new Runnable() {
                @Override
                public void run() {
                    int width = iv.getMeasuredWidth();
                    int height = iv.getMeasuredHeight();
                    //tv.setText(""+width+"x"+height);

                }
            });


            result="";
            //result+="\r\n"+iv.getMaxWidth()+"x"+iv.getMaxWidth();


            tv = (TextView)findViewById(R.id.aaa);
            tv.setText(""+result);


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
            result="";
            //result+="\r\n"+this.getResources();
            result+="\r\n"+getContext();
            //Bitmap bmp = BitmapFactory.decodeFile (path);
            Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.ppp);
            int oldwidth = bmp.getWidth();
            int oldheight = bmp.getHeight();
            Bitmap resizebmp = Bitmap.createBitmap(bmp, 0, 0, 200,200);
            BitmapDrawable bmp_draw = new BitmapDrawable(getResources(),resizebmp);
            //TextView textDrawable = (TextView) findViewById(R.id.aaa);
            //tv.setCompoundDrawablePadding(4);

            tv = (TextView)findViewById(R.id.aaa);
            tv.setText(""+result);
            //tv.setBackgroundResource(R.drawable.ppp);
            //tv.setCompoundDrawablesWithIntrinsicBounds(bmp,null, null, null);


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
            Drawable drawableLeft = getResources().getDrawable(R.drawable.ppp);
            TextView textDrawable = (TextView) findViewById(R.id.aaa);
            textDrawable.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,null, null, null);
            textDrawable.setCompoundDrawablePadding(4);
        }}
        catch (Exception e){

        }

        //




    }
}
