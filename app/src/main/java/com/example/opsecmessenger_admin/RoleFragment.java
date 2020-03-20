package com.example.opsecmessenger_admin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoleFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Role identifier variable
    public static String role;


    public RoleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RoleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RoleFragment newInstance(String param1, String param2) {
        RoleFragment fragment = new RoleFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_role, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.admin).setOnClickListener(this);
        view.findViewById(R.id.super_admin).setOnClickListener(this);

    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().findViewById(R.id.bottom_navigation).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.toolbar).setVisibility(View.VISIBLE);

    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().findViewById(R.id.bottom_navigation).setVisibility(View.GONE);
        getActivity().findViewById(R.id.toolbar).setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.admin:
                role = getString(R.string.admin);
                break;

            case R.id.super_admin:
                role = getString(R.string.super_admin);
                break;
        }



    }
}
