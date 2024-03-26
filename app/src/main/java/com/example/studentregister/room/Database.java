package com.example.studentregister.room;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.studentregister.data.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student_database";
    private static final String TABLE_NAME = "student_table";
    private static final int DATABASE_VERSION = 1;


    private static final String NAME = "info";
    private static final String EMAIL = "Email";
    private static final String ADDRESS = "address";
    private static final String ID = "id";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableCreate = "CREATE TABLE  " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " TEXT, " +
                EMAIL + " TEXT, " +
                ADDRESS + " TEXT)";

        db.execSQL(tableCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public long registerAdd(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cs = new ContentValues();
        cs.put(NAME, student.getInfo());
        cs.put(EMAIL, student.getEmail());
        cs.put(ADDRESS, student.getAddress());

        long id = db.insert(TABLE_NAME, null, cs);
        db.close();
        return id;
    }


    public List<Student> allRegister() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[]{NAME, EMAIL, ADDRESS};
        Cursor cursor = db.query(TABLE_NAME,column,null,null,null,null,null);
        int name = cursor.getColumnIndex(NAME);
        int email = cursor.getColumnIndex(EMAIL);
        int address = cursor.getColumnIndex(ADDRESS);

        List<Student> studentList = new ArrayList<>();
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Student student = new Student();
            student.setInfo(cursor.getString(name));
            student.setEmail(cursor.getString(email));
            student.setAddress(cursor.getString(address));


            studentList.add(student);

        }

        db.close();

        return studentList;
    }
}
