package com.example.investmentideas;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    Long insertTask(Stock stock);

    @Query("SELECT * FROM Stock ORDER BY id")
    LiveData<List<Stock>> fetchAllTask();

    @Query("SELECT * FROM Stock WHERE id =:taskId")
    LiveData<Stock> getTask(int taskId);

    @Update
    void updateTask(Stock stock);

    @Delete
    void deleteTask(Stock stock);

}
