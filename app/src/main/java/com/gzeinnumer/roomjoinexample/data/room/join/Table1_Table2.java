package com.gzeinnumer.roomjoinexample.data.room.join;


import androidx.annotation.NonNull;

import com.gzeinnumer.roomjoinexample.data.room.table.Table1;

public class Table1_Table2 extends Table1 {

    //https://developer.android.com/training/data-storage/room/accessing-data.html#query-multiple-tables
    //https://stackoverflow.com/questions/45059942/return-type-for-android-room-joins

    int id2;
    String name2;
    int table_1_id;

    public Table1_Table2(int id, @NonNull String name) {
        super(id, name);
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getTable_1_id() {
        return table_1_id;
    }

    public void setTable_1_id(int table_1_id) {
        this.table_1_id = table_1_id;
    }
}
