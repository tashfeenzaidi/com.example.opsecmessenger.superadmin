package com.example.opsecmessenger_admin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.opsecmessenger_admin.adapters.LicenseKeysRecyclerViewAdapter;
import com.example.opsecmessenger_admin.models.LicenseKeysModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LicenseKeysFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LicenseKeysFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Adapter
    private RecyclerView mRecyclerView;
    private LicenseKeysRecyclerViewAdapter mAdapter;


    public LicenseKeysFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LicenseKeysFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LicenseKeysFragment newInstance(String param1, String param2) {
        LicenseKeysFragment fragment = new LicenseKeysFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View view =  inflater.inflate(R.layout.fragment_license_keys, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();

    }

    private void initRecyclerView(){
        List<LicenseKeysModel> licenseKeysList = new ArrayList<>();
        licenseKeysList.add(new LicenseKeysModel("sadfasf",false));
        licenseKeysList.add(new LicenseKeysModel("sadfasf",false));
        licenseKeysList.add(new LicenseKeysModel("sadfasf",false));
        licenseKeysList.add(new LicenseKeysModel("sadfasf",false));
        mAdapter = new LicenseKeysRecyclerViewAdapter(getActivity(),licenseKeysList);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}
