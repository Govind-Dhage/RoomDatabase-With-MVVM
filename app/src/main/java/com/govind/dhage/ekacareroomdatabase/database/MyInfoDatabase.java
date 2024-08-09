package com.govind.dhage.ekacareroomdatabase.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.govind.dhage.ekacareroomdatabase.interfaces.MyInfoDao;
import com.govind.dhage.ekacareroomdatabase.model.MyInfo;

@Database(entities = MyInfo.class, version = 3, exportSchema = false)
public abstract class MyInfoDatabase extends RoomDatabase {

    private static MyInfoDatabase instance;

    public abstract MyInfoDao myInfoDao();

    public static synchronized MyInfoDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MyInfoDatabase.class, "MyDb")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack).build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallBack =new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
}
