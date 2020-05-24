package com.example.thebluejackkost;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "DBHelper";
    private static final int DB_VER = 1;
    private static final String DB_NAME = "kostManager";

    private static final String TABLE_USER = "users";
    private static final String TABLE_BOOKING = "bookings";

    private static final String USER_ID = "userId";
    private static final String USER_NAME = "userName";
    private static final String USER_PASS = "userPass";
    private static final String USER_PHONE = "userPhone";
    private static final String USER_DOB = "userDob";
    private static final String USER_GENDER = "userGender";

    private static final String BOOKING_ID = "bookingId";
    private static final String BOOKING_USERID = "userId";
    private static final String BOOKING_KOSTDATA = "kostId";
    private static final String BOOKING_DATE = "bookingDate";

    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "(" +
            USER_ID + " STRING PRIMARY KEY, " + USER_NAME + " STRING, " + USER_PASS + " STRING," +
            USER_PHONE + " STRING, " + USER_GENDER + " STRING, " + USER_DOB + " STRING );";

    private static final String CREATE_TABLE_BOOKING = "CREATE TABLE " + TABLE_BOOKING + "(" +
            BOOKING_ID + " STRING PRIMARY KEY, " + BOOKING_DATE + " STRING, " + BOOKING_USERID +
            "STRING, " + BOOKING_KOSTDATA + " STRING );";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_BOOKING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKING);
        onCreate(db);
    }

    public boolean tableUserInsertData(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USER_ID, user.getId());
        cv.put(USER_NAME, user.getUsername());
        cv.put(USER_PASS, user.getPassword());
        cv.put(USER_PHONE, user.getPhoneNo());
        cv.put(USER_GENDER, user.getGender());
        cv.put(USER_DOB, user.getDob());

        long result = db.insert(TABLE_USER, null, cv);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public long getTableUserRowCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, TABLE_USER);
        db.close();
        Log.d(TAG, "Table User Row Count: " + count);
        return count;
    }

    public Cursor getTableUserData(String pos){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] selectionArgs = {pos};
        Cursor res = db.rawQuery("SELECT " + USER_NAME + " FROM " + TABLE_USER, selectionArgs);
        return res;
    }
}
