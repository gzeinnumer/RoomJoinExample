# RoomJoinExample
 
References
- [Room Join](https://developer.android.com/training/data-storage/room/accessing-data.html#query-multiple-tables)
- [Embedded](https://stackoverflow.com/questions/45059942/return-type-for-android-room-joins) only if your table use difference entity.

Enable Room with this code [Room Java](https://github.com/gzeinnumer/AndroidJetpackRoom) & [Room Kotlin](https://github.com/gzeinnumer/AndroidJetpackRoomKT)

- Table1
```java
@Entity(tableName = "table_1")
public class Table1 {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @NonNull
    @ColumnInfo(name = "name")
    public String name;
    
    //constructor
    
    //getter setter
}
```

- Table2
```java
@Entity(tableName = "table_2")
public class Table2 {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @NonNull
    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "table_1_id")
    public int table_1_id;
    
    //constructor
    
    //getter setter
}
```

- Table1 Join with Table2
```java
@Dao
public interface Table1Dao {

    @Query("SELECT " +
     "table_1.id, " +
      "table_1.name, " +
       "table_2.id as id2, " +
        "table_2.name as name2, " +
         "table_2.table_1_id " +
          "FROM table_1 " +
           "LEFT JOIN table_2 ON table_2.table_1_id = table_1.id;")
    List<Table1_Table2> getJOin();

}
```

- Joined Entity
```java
public class Table1_Table2 extends Table1 {

    int id2;
    String name2;
    int table_1_id;
    
    //getter setter
}
```

- Use on your activity
```java
AppDatabase appDatabase = AppDatabase.getInstance(getApplication());

List<Table1_Table2> list = appDatabase.sampleTable1Dao().getJOin();

for (int i=0; i<list.size(); i++){
    String name1 = list.get(i).getName();
    String name2 = list.get(i).getName2();

    Log.d(TAG, "list: "+i+"_"+name1+"_"+name2);
}
```

- Example
```java
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
```
[Example Project](https://github.com/gzeinnumer/RoomJoinExample)

- Preview
|![](https://github.com/gzeinnumer/RoomJoinExample/blob/master/preview/example1.JPG)|
|--|
---

```
Copyright 2020 M. Fadli Zein
```
