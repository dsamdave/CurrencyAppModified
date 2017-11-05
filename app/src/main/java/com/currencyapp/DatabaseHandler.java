package com.currencyapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Davidchosen on 03/11/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;


    public DatabaseHandler(Context context) {
        super(context, CurrencyContract.DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + CurrencyContract.CurrencyEntry.TABLE_CURRENCY + " ("
                + CurrencyContract.CurrencyEntry._ID + " INTEGER PRIMARY KEY," +
                CurrencyContract.CurrencyEntry.COLUMN_CURRENCY_NAME + " TEXT," +
                CurrencyContract.CurrencyEntry.COLUMN_BTC_RATE + " REAL," +
                CurrencyContract.CurrencyEntry.COLUMN_ETH_RATE + " REAL)";
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String delete_table = "DROP TABLE IF EXISTS " + CurrencyContract.CurrencyEntry.TABLE_CURRENCY;
        db.execSQL(delete_table);
        onCreate(db);
    }
}
