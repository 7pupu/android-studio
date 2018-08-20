package com.example.ppp180312.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    String result;
    TextView tv;
    ImageView iv;
    Bitmap bmp;
    //
    Toast toast;
    SQLiteDatabase db;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Toast.makeText(MainActivity.this,"onCreate", Toast.LENGTH_SHORT).show();

        poi();
        //
        handler=new Handler(){
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Bundle data = msg.getData();
                String val = data.getString("value");

                //Toast.makeText(MainActivity.this,""+val, Toast.LENGTH_LONG).show();
                tv=(TextView)findViewById(R.id.textView);
                tv.setText(""+data.getString("response"));
            }
        };
    }

    private void poi() {
        tv=(TextView)findViewById(R.id.textView);
        tv.post(new Runnable() { //捲軸元件scrollView
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,"run", Toast.LENGTH_SHORT).show();
                //xopowo();
                //ypa();
                //www();
                //qwq();
                //ouo();//讀取json
                //owo();
                //HttpUrlConnection networkonmainthreadexception
                //viewrootimpl$calledfromwrongthreadexception
                owo2();
                //haha(); //extends AsyncTask

            }
        });
    }

    private void owo2() {
        result="123";
        new Thread(new Runnable(){public void run(){
            try{
                //
                String ss="http://sora.komica.org/00/index.htm";
                URL url = new URL(ss);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(6*1000); conn.setReadTimeout(6 * 1000);
                int response = conn.getResponseCode();
                String responseMsg = conn.getResponseMessage();
                //InputStream in = conn.getInputStream();
                conn.disconnect();

                //
                Message msg = new Message();
                Bundle data = new Bundle();
                data.putString("value","副執行緒");
                data.putString("response",""+response);
                msg.setData(data);
                handler.sendMessage(msg);
            }
            catch (Exception ee){
                Message msg = new Message();
                Bundle data = new Bundle();
                data.putString("value","副執行緒");
                msg.setData(data);
                handler.sendMessage(msg);
            }

        }}).start();
        //
        tv=(TextView)findViewById(R.id.textView);
        tv.setText(""+result);
    }

    private void haha() {
        //int ii = new MyDownloadTask();//
    }


    private void owo() {
        //Runnable mutiThread =
        //new Thread(new Runnable(){public void run(){}}).start();


        Thread thread =new Thread(new Runnable(){public void run(){
            try{
                String ss="https://www.google.com/";
                URL url = new URL(ss);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setConnectTimeout(6*1000); conn.setReadTimeout(6 * 1000);
                int response = conn.getResponseCode();
                String responseMsg = conn.getResponseMessage();
                //InputStream in = conn.getInputStream();
                conn.disconnect();

                result="1";
                result+="\r\n1"+response;
                result+="\r\n1"+responseMsg;

            }
            catch (Throwable e){
                result="2";
                result+="\r\n2"+e;
                result+="\r\n2"+e.getClass();
                result+="\r\n2"+e.getMessage();
            }
        }});
        thread.start();
        tv=(TextView)findViewById(R.id.textView);
        tv.setText(""+result);
    }

    private void ouo() {
        try{
            StringBuilder builder = new StringBuilder();
            builder.append("{\"id\":123,\"name\":\"Tom\",\"say\":\"don't move\"}");
            JSONObject testjson = new JSONObject(builder.toString());
            result="";
            result+="\r\n"+testjson.getString("id");
            result+="\r\n"+testjson.getString("name");

            tv=(TextView)findViewById(R.id.textView);
            tv.setText(""+result);
        }
        catch (JSONException ee){
            result="";
            result+="\r\n"+ee.getMessage();
            tv=(TextView)findViewById(R.id.textView);
            tv.setText(""+result);
        }



    }

    private void qwq() {
        tv=(TextView)findViewById(R.id.textView);
        handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                //要做的事情
                Calendar c = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
                String time = dateFormat.format(Calendar.getInstance().getTime());
                tv.setText(""+time);
                //
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);//每两秒执行一次runnable.
        //        handler.removeCallbacks(runnable);

    }

    private void www() {
        //handler = new Handler();
        tv=(TextView)findViewById(R.id.textView);
        //
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Calendar c = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
                String time = dateFormat.format(Calendar.getInstance().getTime());
                tv.setText(""+time);
            }}, 2000);
    }

    private void ypa() {
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                Calendar c = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
                String time = dateFormat.format(Calendar.getInstance().getTime());
                tv=(TextView)findViewById(R.id.textView);
                tv.setText("剩下" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                Calendar c = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
                String time = dateFormat.format(Calendar.getInstance().getTime());
                tv=(TextView)findViewById(R.id.textView);
                tv.setText("結束");
            }
        }.start();


    }

    private void xopowo() {
        tv=(TextView)findViewById(R.id.textView);
        result="";
        try {
            DBHelper dbService= new DBHelper(this);
            db = dbService.getWritableDatabase();
            result+="db.getVersion()="+"\r\n";
            result+=db.getVersion()+"\r\n";
            result+="db.getPageSize()="+"\r\n";
            result+=db.getPageSize()+"\r\n";
            result+="db.getMaximumSize()="+"\r\n";
            result+=db.getMaximumSize()+"\r\n";
            result+="db.getPath()="+"\r\n";
            result+=db.getPath()+"\r\n";
            if(db.isOpen()){db.close();}

        }
        catch (Exception e){
            Toast.makeText(this,""+e.getMessage(), Toast.LENGTH_SHORT).show();
            result=""+e.getMessage();
        }
        finally {
            tv.setText(""+result);
        }
    }
}
///
class MyDownloadTask extends AsyncTask<Void,Void,String>{
    @Override
    protected String doInBackground(Void... voids) {
        try{
            URL url = new URL("http://www.google.com");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            String responseMsg = con.getResponseMessage();
            int response = con.getResponseCode();
            return ""+response;
        }
        catch (Exception ee){
            return ""+ee.getClass();
        }
    }
}
///
class DBHelper extends SQLiteOpenHelper {
    String sql;
    SQLiteDatabase db;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mysql";
    private static final String TABLE_NAME = "mytable";
    //
    //public DBService(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {//DatabaseErrorHandler errorHandler
    public DBHelper(Context context) {//DatabaseErrorHandler errorHandler
        //super(context, name, factory, version);
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        sql = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" (var1 TEXT,var2 TEXT,var3 TEXT )";
        db.execSQL(sql);
        sql = "insert into "+TABLE_NAME+" values('001','peter','peter@hotmail.com')";
        db.execSQL(sql);
    }
    private void addData(String str_01, String str_02, String str_03) {
        ContentValues cv=new ContentValues(3);
        cv.put("var1", str_01);
        cv.put("var1", str_02);
        cv.put("var1", str_03);

        db.insert(TABLE_NAME, null, cv);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        final String SQL = "DROP TABLE " + TABLE_NAME;
    }
}

