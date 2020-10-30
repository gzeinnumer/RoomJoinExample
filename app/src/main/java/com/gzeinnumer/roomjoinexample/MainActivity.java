package com.gzeinnumer.roomjoinexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.gzeinnumer.roomjoinexample.data.room.AppDatabase;
import com.gzeinnumer.roomjoinexample.data.room.join.Table1_Table2;
import com.gzeinnumer.roomjoinexample.data.room.table.Table1;
import com.gzeinnumer.roomjoinexample.data.room.table.Table2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Table1> dataTable1 = new ArrayList<>();
    List<Table2> dataTable2 = new ArrayList<>();

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase appDatabase = AppDatabase.getInstance(getApplication());

        dataTable1.add(new Table1(1, "M. Fadli 1"));
        dataTable1.add(new Table1(2, "M. Fadli 2"));
        dataTable1.add(new Table1(3, "M. Fadli 3"));
        dataTable1.add(new Table1(4, "M. Fadli 4"));

        appDatabase.sampleTable1Dao().insertAll(dataTable1);

        dataTable2.add(new Table2(1, "Zein 1", 1));
        dataTable2.add(new Table2(2, "Zein 2",2));
        dataTable2.add(new Table2(3, "Zein 3",3));
        dataTable2.add(new Table2(4, "Zein 4",4));

        appDatabase.sampleTable2Dao().insertAll(dataTable2);

        List<Table1_Table2> list = appDatabase.sampleTable1Dao().getJOin();

        for (int i=0; i<list.size(); i++){
            String name1 = list.get(i).getName();
            String name2 = list.get(i).getName2();

            Log.d(TAG, "list: "+i+"_"+name1+"_"+name2);
        }
    }
}