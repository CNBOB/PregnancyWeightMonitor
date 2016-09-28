package com.namilili.pregnancyweightmonitor;

/**
 * Created by BOB on 2016/9/26.
 */
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

public class PregnancyWeightDBHelper extends SQLiteOpenHelper  {

    private static final String DATABASE_NAME="PregnancyWeight.db";//数据库名称
    private static final int SCHEMA_VERSION=2;//版本号,则是升级之后的,升级方法请看onUpgrade方法里面的判断

    public PregnancyWeightDBHelper(Context context) {//构造函数,接收上下文作为参数,直接调用的父类的构造函数
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//创建的是一个午餐订餐的列表,id,菜名,地址等等
        db.execSQL("CREATE TABLE IF NOT EXISTS PregnancyWeight (_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, weight TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion==1 && newVersion==2) {//升级判断,如果再升级就要再加两个判断,从1到3,从2到3
            db.execSQL("ALTER TABLE PregnancyWeight ADD weight TEXT;");
        }
    }

    public Cursor getAll(String where, String orderBy) {//返回表中的数据,where是调用时候传进来的搜索内容,orderby是设置中传进来的列表排序类型
        StringBuilder buf=new StringBuilder("SELECT _id, date, weight from PregnancyWeight");

        if (where!=null && where != "") {
            buf.append(" WHERE ");
            buf.append(where);
        }

        if (orderBy!=null && orderBy != "") {
            buf.append(" ORDER BY ");
            buf.append(orderBy);
        }

        return(getReadableDatabase().rawQuery(buf.toString(), null));
    }

    public Cursor getById(String id) {//根据点击事件获取id,查询数据库
        String[] args={id};

        return(getReadableDatabase()
                .rawQuery("SELECT _id, date, weight FROM PregnancyWeight WHERE _ID=?",
                        args));
    }

    public void insert(String date, String weight) {
        ContentValues cv=new ContentValues();

        cv.put("date", date);
        cv.put("weight", weight);

        getWritableDatabase().insert("PregnancyWeight", "date", cv);
    }

    public void update(String date, String weight) {
        ContentValues cv=new ContentValues();
        String[] args={date};

        cv.put("date", date);
        cv.put("weight", weight);

        getWritableDatabase().update("PregnancyWeight", cv, "_ID=?",
                args);
    }

    public String getDate(Cursor c) {
        return(c.getString(1));
    }

    public String getWeight(Cursor c) {
        return(c.getString(2));
    }

}
