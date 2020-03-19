package com.example.opsecmessenger_admin.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.opsecmessenger_admin.models.UserRecyclerViewModel;
import com.example.opsecmessenger_admin.repositories.UserRepository;

import java.util.List;

public class MainActivityViewModel  extends ViewModel {

    private MutableLiveData<List<UserRecyclerViewModel>>mUsers;
    private UserRepository userRepository;

    public void init(){
            if (mUsers != null){
                return;
            }

            userRepository = UserRepository.getInstence();
            mUsers = userRepository.getUserData();
    }


    public LiveData<List<UserRecyclerViewModel>> getUsersData(){
        return mUsers;
    }
}
