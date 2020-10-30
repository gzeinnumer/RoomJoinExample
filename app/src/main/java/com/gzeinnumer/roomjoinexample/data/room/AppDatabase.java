package com.gzeinnumer.roomjoinexample.data.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.gzeinnumer.roomjoinexample.data.room.dao.Table1Dao;
import com.gzeinnumer.roomjoinexample.data.room.dao.Table2Dao;
import com.gzeinnumer.roomjoinexample.data.room.table.Table1;
import com.gzeinnumer.roomjoinexample.data.room.table.Table2;

@Database(entities = {Table1.class, Table2.class}, version = 8)
public abstract class AppDatabase extends RoomDatabase {

    private static final String TAG = "AppDatabase";
    public static String dbName = "sample.db";

    public abstract Table1Dao sampleTable1Dao();
    public abstract Table2Dao sampleTable2Dao();

    public static synchronized AppDatabase getInstance(Context context) {
        return Room.databaseBuilder(context,AppDatabase.class, dbName)
                .allowMainThreadQueries()
                .build();
    }
}
