package com.example.opsecmessenger_admin;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.opsecmessenger_admin.adapters.NewLicenseKeyRecyclerViewAdapter;
import com.example.opsecmessenger_admin.adapters.UserRecyclerViewAdapter;
import com.example.opsecmessenger_admin.viewmodels.HomeViewModel;
import com.example.opsecmessenger_admin.viewmodels.MainActivityViewModel;


public class NewLicenseKeyFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView mRecyclerView;
    private NewLicenseKeyRecyclerViewAdapter  mAdapter;
    MainActivityViewModel mainActivityViewModel;
    private HomeViewModel mViewModel;

    public NewLicenseKeyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_new_license_key, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        view.findViewById(R.id.floating_action_button).setOnClickListener(this);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().findViewById(R.id.bottom_navigation).setVisibility(View.VISIBLE);

    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().findViewById(R.id.bottom_navigation).setVisibility(View.GONE);
    }

    private void initRecyclerView(){
        mainActivityViewModel.init();
        mAdapter = new NewLicenseKeyRecyclerViewAdapter(getActivity(),mainActivityViewModel.getUsersData().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
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
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.floating_action_button:
                Navigation.findNavController(view).navigate(R.id.action_newLicenseKeyFragment_to_generateLicenseKeyFragment);
                break;
        }


    }
}
