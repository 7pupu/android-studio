package com.example.ppp180312.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        Toast.makeText(MainActivity.this,"onCreate", Toast.LENGTH_LONG).show();

        poi();
    }

    private void poi() {
        tv=(TextView)findViewById(R.id.textView);
        tv.post(new Runnable() { //捲軸元件scrollView
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,"run", Toast.LENGTH_LONG).show();
                //xopowo();
                //ypa();
                //www();
                qwq();

            }
        });
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

