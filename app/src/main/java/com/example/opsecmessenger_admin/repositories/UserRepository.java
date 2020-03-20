package com.example.opsecmessenger_admin.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.opsecmessenger_admin.models.UserRecyclerViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    /**
     * Singleton pattern
     */

    private static UserRepository instence;
    private ArrayList<UserRecyclerViewModel> dataSet = new ArrayList<>();

    public static UserRepository getInstence(){
        if (instence == null){
            return new UserRepository();
        }
        return instence;
    }

    public MutableLiveData<List<UserRecyclerViewModel>> getUserData(){
        setUsersData();
        MutableLiveData <List<UserRecyclerViewModel>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setUsersData() {

        dataSet.add(new UserRecyclerViewModel("MARK","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        dataSet.add(new UserRecyclerViewModel("MARK","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        dataSet.add(new UserRecyclerViewModel("MARK","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        dataSet.add(new UserRecyclerViewModel("MARK","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        dataSet.add(new UserRecyclerViewModel("MARK","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        dataSet.add(new UserRecyclerViewModel("MARK","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
    }

}
