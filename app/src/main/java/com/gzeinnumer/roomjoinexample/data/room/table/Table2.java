package com.gzeinnumer.roomjoinexample.data.room.table;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_2")
public class Table2 {

    public Table2(int id, @NonNull String name, int table_1_id) {
        this.id = id;
        this.name = name;
        this.table_1_id = table_1_id;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @NonNull
    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "table_1_id")
    public int table_1_id;

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }
}
