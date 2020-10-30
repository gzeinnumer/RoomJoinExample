package com.gzeinnumer.roomjoinexample.data.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.gzeinnumer.roomjoinexample.data.room.table.Table1;
import com.gzeinnumer.roomjoinexample.data.room.table.Table2;

import java.util.List;

@Dao
public interface Table2Dao {

    @Query("SELECT * FROM table_2")
    List<Table2> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<Table2> table2s);

    @Delete
    void delete(Table2 table2);
}
