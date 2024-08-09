package com.govind.dhage.ekacareroomdatabase.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.govind.dhage.ekacareroomdatabase.database.MyInfoDatabase;
import com.govind.dhage.ekacareroomdatabase.interfaces.MyInfoDao;
import com.govind.dhage.ekacareroomdatabase.model.MyInfo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyInfoRepository  {
    private MyInfoDao myInfoDao;

    private LiveData<List<MyInfo>> allUsers;
    private ExecutorService executorService;

    public MyInfoRepository(Application application){
        MyInfoDatabase myInfoDatabase=MyInfoDatabase.getInstance(application);
        myInfoDao=myInfoDatabase.myInfoDao();
        allUsers=myInfoDao.getAllUsers();
        executorService = Executors.newSingleThreadExecutor();
    }




    public LiveData<List<MyInfo>> getAllUsers() {
        return allUsers;
    }

    public void insert(MyInfo user) {
        executorService.execute(() -> myInfoDao.insert(user));
    }



}

