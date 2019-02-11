package com.example.franchette.braintrain;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.franchette.braintrain.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Franchette on 3/16/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{

    public static String DATABASE_QUESTION="questionBank.db";

    private static final int DATABASE_VERSION=1;
    private static final String TABLE_QUESTION="QuestionBank";
    private static final String KEY_ID="id";
    private static final String QUESTION="question";
    private static final String CHOICE1="choice1";
    private static final String CHOICE2="choice2";
    private static final String CHOICE3="choice3";
    private static final String CHOICE4="choice4";
    private static final String ANSWER="answer";

    private static final String CREATE_TABLE_QUESTION="CREATE TABLE "
            +TABLE_QUESTION + "("+KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + QUESTION + " TEXT,"
            + CHOICE1 + "TEXT," + CHOICE2 +"TEXT," + CHOICE3 +"TEXT, "+
            CHOICE4 + "TEXT, " + ANSWER + " TEXT);";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(CREATE_TABLE_QUESTION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS QuestionBank");
        onCreate(sqLiteDatabase);
    }
}

