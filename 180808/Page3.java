package com.example.ppp180312.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Page3 extends AppCompatActivity {
    Button btn;
    String result;
    TextView tv;
    SQLiteDatabase db;
//
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mysql";
    private static final String TABLE_NAME = "mytable";



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
//
        poi();//寫入
        //poi2b();//讀取
        poi2c();//讀取
    }

    private void poi2c() {
        tv= findViewById(R.id.textView2);
        result="";
        btn = findViewById(R.id.button5);
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){  // }});
            try{
                DBHelper dbService= new DBHelper(Page3.this);
                db = dbService.getReadableDatabase();
                Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
                int cc=0;
                if (c.moveToFirst()){
                    do {
                        cc++;
                        result+=cc+", ";
                        for(int i=0;i<c.getColumnCount();i++){
                            result+=c.getString(i)+", ";
                        }
                        result+="\r\n";
                    } while(c.moveToNext());
                }

                db.close();

                result=
                        "行數="+cc+"\r\n"+
                        "資料內容="+"\r\n"+result;


            }
            catch(Exception e){
                result=e.getMessage();
            }
            finally {
                tv.setText(""+result);
            }
        }});

    }

    //讀取
    private void poi2b() {
        tv= findViewById(R.id.textView2);
        result="";
        btn = findViewById(R.id.button5);
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){  // }});
            try{
                DBHelper dbService= new DBHelper(Page3.this);
                db = dbService.getReadableDatabase();
                //Cursor cursor = db.rawQuery("SELECT  * FROM "+ TABLE_NAME, null);
                //int count = cursor.getCount();
                //cursor.close();
                int  count =db.rawQuery("SELECT  * FROM "+ TABLE_NAME, null).getCount();
                db.close();

                result="行數(b)="+count;


            }
            catch(Exception e){
                result=e.getMessage();
            }
            finally {
                tv.setText(""+result);
            }
        }});
    }
    private void poi2() {
        tv= findViewById(R.id.textView2);
        result="";
        btn = findViewById(R.id.button5);
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){  // }});
            try{
                DBHelper dbService= new DBHelper(Page3.this);
                db = dbService.getReadableDatabase();
                //StringBuffer sql = new StringBuffer();
                //sql.append("(_id int PRIMARY KEY,name varchar,gender int,age int,phoneNumber varchar,address varchar)");
                //db.execSQL(sql.toString());
                long count = DatabaseUtils.queryNumEntries(db, TABLE_NAME);
                db.close();
                result="行數="+count;


            }
            catch(Exception e){
                result=e.getMessage();
            }
            finally {
                tv.setText(""+result);
            }
        }});
    }

    private void poi(){
        btn = findViewById(R.id.button4);
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){
            result="";
            result="poi";
            try{
                DBHelper dbService= new DBHelper(Page3.this);
                db = dbService.getWritableDatabase();

                ContentValues cv=new ContentValues();  //建立 ContentValues 物件並呼叫 put(key,value) 儲存欲新增的資料，key 為欄位名稱  value 為對應值。
                cv.put("var1","var1qq");
                cv.put("var2","var2qq");
                cv.put("var3","var3qq");
                db.insert(TABLE_NAME,null,cv);
                result+="ok";

                if(db.isOpen()){db.close();}
/*
SQLiteStatement sqLiteStatement = db.compileStatement("insert into msgTable(uid, msg) values(?, ?)");
sqLiteStatement.bindLong(1, 12);
sqLiteStatement.bindString(3, "text");
*/

            }
            catch (Exception e){
                result=e.getMessage();
            }
            finally {
                tv= findViewById(R.id.textView2);
                tv.setText(""+result);
            }

        }});//ClickListener
    }

}

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

