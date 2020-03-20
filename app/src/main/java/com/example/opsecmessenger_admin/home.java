package com.example.opsecmessenger_admin;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.opsecmessenger_admin.adapters.UserRecyclerViewAdapter;
import com.example.opsecmessenger_admin.viewmodels.HomeViewModel;
import com.example.opsecmessenger_admin.viewmodels.MainActivityViewModel;

public class home extends Fragment implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private UserRecyclerViewAdapter mAdapter;
    MainActivityViewModel mainActivityViewModel;
    private HomeViewModel mViewModel;

    public static home newInstance() {
        return new home();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
            View view =  inflater.inflate(R.layout.fragment_home, container, false);
            mRecyclerView = view.findViewById(R.id.recycler_view);
            return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        mainActivityViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        initRecyclerView();


        mainActivityViewModel.getUsersData().observe(getActivity(),
                userRecyclerViewModels -> mAdapter.notifyDataSetChanged());

        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void initRecyclerView(){
        mainActivityViewModel.init();
        mAdapter = new UserRecyclerViewAdapter(getActivity(),mainActivityViewModel.getUsersData().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {

//        switch (view.getId())
//        {
//            case R.id.search:
////                Navigation.findNavController(view).navigate(R.id.action_home_to_searchFragment);
//                //Navigation.findNavController(getActivity(),R.id.nav_graph).navigate(R.id.action_home_to_searchFragment);
//        }
    }
}
