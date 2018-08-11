package com.example.ppp180312.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        tv=(TextView)findViewById(R.id.textView2);
        result="";
        for(int i=0;i<200;i++){
            result+="\r\n"+"中文";
        }
        tv.setText(""+result);

        //poi();
        tv=(TextView)findViewById(R.id.textView7);
        result="";
        try {
            myDBHelper dbService= new myDBHelper(this);
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
            result+="\r\n"+e.getClass();
            result+="\r\n"+e.getMessage();
        }
        finally {
            tv.setText(""+result);
        }

    }


}

class myDBHelper extends SQLiteOpenHelper {
    String sql;
    SQLiteDatabase db;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mysql";
    private static final String TABLE_NAME = "mytable";

    public myDBHelper(Context context) {//DatabaseErrorHandler errorHandler
        //super(context, name, factory, version);
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        db=sqLiteDatabase;
        sql = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" (var1 TEXT,var2 TEXT,var3 TEXT )";
        db.execSQL(sql);
        sql = "insert into "+TABLE_NAME+" values('001','建立資料庫','成功')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        final String SQL = "DROP TABLE " + TABLE_NAME;
    }
}


