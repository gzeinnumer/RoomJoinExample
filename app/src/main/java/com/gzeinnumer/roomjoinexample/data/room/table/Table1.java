package com.gzeinnumer.roomjoinexample.data.room.table;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_1")
public class Table1 {

    public Table1(int id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @NonNull
    @ColumnInfo(name = "name")
    public String name;

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }
}
