package com.example.shivkailash.finalwala;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class DatabaseHalper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="contacts.db";
    private static final String TABLE_NAME="contacts";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_UNAME="uname";
    private static final String COLUMN_PASS="pass";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null ,"+
            "name text not null,email text not null,uname text not null,pass text not null);";
    public Contact c;

    public DatabaseHalper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;

    }
    public void insertContact(Contact c){
        db = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query,null);
        int count  = cursor.getCount();
        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_PASS,c.getPass());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
//   public  String searchPass(String uname)
//   {
//       db = this.getReadableDatabase();
//       String query ="select uname,pass FROM" + TABLE_NAME;
//       Cursor cursor = db.rawQuery(query,null);
//       String a,b;
//       b="not found";
//       if(cursor.moveToFirst()){
//           do{
//               a=cursor.getString(0);
//
//               if(a.equals(uname))
//               {
//                   b=cursor.getString(1);
//                   break;
//
//               }
//           }
//           while (cursor.moveToNext());
//
//       }
//           return b;
//   }
public String searchPass(String uname) {
    db = this.getReadableDatabase();
    String query = "select * from " + TABLE_NAME;
    Cursor cursor = db.rawQuery(query, null);
    String a, b;
    b = "not found";
    if (cursor.moveToFirst()) {

        do {
            a = cursor.getString(cursor.getColumnIndex(COLUMN_UNAME));

            if (a.equals(uname)) {
                b = cursor.getString(cursor.getColumnIndex(COLUMN_PASS));
                break;
            }
        }
        while(cursor.moveToNext());
    }
    return b; // b is the returned password
}

    @Override
//    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newversion) {
//
//           db.execSQL("DROP TABLE IF EXISTS TABLE_NAME");
//           this.onCreate(db);
//    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS TABLE_NAME");
        onCreate(db);
    }
}
