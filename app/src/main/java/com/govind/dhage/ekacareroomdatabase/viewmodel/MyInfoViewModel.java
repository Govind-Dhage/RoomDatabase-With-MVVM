package com.govind.dhage.ekacareroomdatabase.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.govind.dhage.ekacareroomdatabase.model.MyInfo;
import com.govind.dhage.ekacareroomdatabase.repository.MyInfoRepository;

import java.util.List;

public class MyInfoViewModel extends ViewModel {

    private MyInfoRepository myInfoRepository;
    private LiveData<List<MyInfo>> allUsers;

    public MyInfoViewModel(MyInfoRepository myInfoRepository) {
        this.myInfoRepository = myInfoRepository;
        allUsers = myInfoRepository.getAllUsers();
    }


    public LiveData<List<MyInfo>> getAllUsers() {
        return allUsers;
    }

    public void insert(MyInfo myinfo) {
        myInfoRepository.insert(myinfo);
    }

    public static class MyInfoModelFactory implements ViewModelProvider.Factory {
        private final MyInfoRepository repository;

        public MyInfoModelFactory(MyInfoRepository repository) {
            this.repository = repository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            if (modelClass.isAssignableFrom(MyInfoViewModel.class)) {
                return (T) new MyInfoViewModel(repository);
            }
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
