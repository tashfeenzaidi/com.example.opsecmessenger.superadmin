package com.example.opsecmessenger;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.opsecmessenger.adapters.ResellerRecyclerViewAdapter;
import com.example.opsecmessenger.adapters.UserRecyclerViewAdapter;
import com.example.opsecmessenger.models.NoteModal;
import com.example.opsecmessenger.models.ResellerModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResellersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResellersFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ResellerRecyclerViewAdapter mAdapter;
    private RecyclerView mRecyclerView;

    public ResellersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResellersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResellersFragment newInstance(String param1, String param2) {
        ResellersFragment fragment = new ResellersFragment();
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
        View view =  inflater.inflate(R.layout.fragment_resellers, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    private void initRecyclerView(){
        List<ResellerModel> resellerList = new ArrayList<>();
        resellerList.add(new ResellerModel(4,4,4,4,"MARK","image"));
        resellerList.add(new ResellerModel(4,4,4,4,"ZEN","image"));
        resellerList.add(new ResellerModel(4,4,4,4,"ANNA","image"));
        resellerList.add(new ResellerModel(4,4,4,4,"ALE IMAN","image"));
        mAdapter = new ResellerRecyclerViewAdapter(getActivity(),resellerList);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.floating_action_button).setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();

    }

    @Override
    public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.createResellerFragment);
    }

}
