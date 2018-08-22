package com.example.ppp180312.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String result;
    Button btn;
    TextView tv;
    EditText et;
    GridView gv;
    int init=0;
    //
    SQLiteDatabase db;

    //
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this,"onStart", Toast.LENGTH_SHORT).show();
        //
        DisplayMetrics monitorsize =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(monitorsize);
        result="寬x高="+monitorsize.widthPixels+"x"+ monitorsize.heightPixels;
        tv=(TextView)findViewById(R.id.textView);
        tv.setText(""+result);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(MainActivity.this,"onCreate", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        //
        gv = (GridView) findViewById(R.id.gridView);
        gv.setFocusable(false);
        //
        poi();//
        _gridview();
        //
        tv=(TextView)findViewById(R.id.textView2);
        result="";
        for(int i=0;i<100;i++){
            result+="\r\n"+"中文"+i;
        }
        tv.setText(""+result);

        //poi();
        tv=(TextView)findViewById(R.id.textView3);
        result="";
        try {
            myDBHelper dbService= new myDBHelper(this);
            db = dbService.getWritableDatabase();
            result+="db.getVersion()=";
            result+=db.getVersion()+"\r\n";
            result+="db.getPageSize()=";
            result+=db.getPageSize()+"\r\n";
            result+="db.getMaximumSize()=";
            result+=db.getMaximumSize()+"\r\n";

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

    private void _gridview() {
        //http://givemepass.blogspot.com/2011/11/gridview.html

        String[] name = { "剑萧舞蝶", "张三", "hello", "诗情画意" };
        String[] desc = { "魔域玩家", "百家执行", "高级的富一代", "妹子请过来..一个善于跑妹子的。。" };

        List<Map<String, Object>> items = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("image",R.drawable.image);
            item.put("name",name[i]);
            item.put("desc",desc[i]);
            items.add(item);
        }
        //新建一個gridview_item.xml
        SimpleAdapter adapter = new SimpleAdapter(this,
                items, R.layout.gridview_item, new String[]{"image","name", "desc"},
                new int[]{R.id.image,R.id.name, R.id.desc});
        GridView gv = (GridView) findViewById(R.id.gridView);
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                result="";
                result+="\r\n"+position;
                //result+="\r\n"+parent.getCount();
                HashMap<String, Object> item = (HashMap<String, Object>) parent.getItemAtPosition(position);
                result+="\r\n"+item.get("name");
                Toast.makeText(MainActivity.this, ""+result , Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void poi() {

        btn = findViewById(R.id.button_cart);
        btn.setOnClickListener(new Button.OnClickListener() {public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this  , Main3Activity.class);
            startActivity(intent);
        }});
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
