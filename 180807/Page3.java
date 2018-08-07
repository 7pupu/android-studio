package com.example.ppp180312.myapplication;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Page3 extends AppCompatActivity {
    Button btn;
    String result;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        //
/*
private DBHelper dbhelper;
private SQLiteDatabase db;
dbhelper = new DBHelper(this, "test", null, 1);
db = dbhelper.getReadableDatabase();
*/
        tv= findViewById(R.id.textView2);
        result="";
try {
    DBHelper dbService= new DBHelper(this);
    SQLiteDatabase db = dbService.getWritableDatabase();
    result+="db.getVersion()="+"\r\n";
    result+=db.getVersion()+"\r\n";
    result+="db.getPageSize()="+"\r\n";
    result+=db.getPageSize()+"\r\n";
    result+="db.getMaximumSize()="+"\r\n";
    result+=db.getMaximumSize()+"\r\n";
    result+="db.getPath()="+"\r\n";
    result+=db.getPath()+"\r\n";

    if(db.isOpen()){db.close();}
    tv.setText(""+result);

}
catch (Exception e){
    Toast.makeText(this,""+e.getMessage(), Toast.LENGTH_SHORT).show();
    tv.setText(""+e.getMessage());
}

    }
}

class DBHelper extends SQLiteOpenHelper {
    String sql;
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

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        final String SQL = "DROP TABLE " + TABLE_NAME;
    }
}

