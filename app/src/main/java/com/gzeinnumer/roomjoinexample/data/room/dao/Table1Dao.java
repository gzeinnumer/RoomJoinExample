package com.gzeinnumer.roomjoinexample.data.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.gzeinnumer.roomjoinexample.data.room.join.Table1_Table2;
import com.gzeinnumer.roomjoinexample.data.room.table.Table1;

import java.util.List;

@Dao
public interface Table1Dao {

    @Query("SELECT * FROM table_1")
    List<Table1> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<Table1> table1s);

    @Delete
    void delete(Table1 table1);

//    @Query("SELECT table_1.*, table_2.* FROM table_1 LEFT JOIN table_2 ON table_2.table_1_id = table_1.id;")
//    List<Table_1_X_Table_2> getJOin();

    @Query("SELECT table_1.id, table_1.name, table_2.id as id2, table_2.name as name2, table_2.table_1_id FROM table_1 LEFT JOIN table_2 ON table_2.table_1_id = table_1.id;")
    List<Table1_Table2> getJOin();

}
