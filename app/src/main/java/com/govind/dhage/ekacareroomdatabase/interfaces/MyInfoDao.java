package com.govind.dhage.ekacareroomdatabase.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.govind.dhage.ekacareroomdatabase.model.MyInfo;

import java.util.List;

@Dao
public interface MyInfoDao {


    @Insert
    void insert(MyInfo myInfo);

    @Query("SELECT * FROM myinfo_table")
    LiveData<List<MyInfo>> getAllUsers();
}
