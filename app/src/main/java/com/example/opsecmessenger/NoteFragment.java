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
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.opsecmessenger.adapters.NoteRecyclerViewAdapter;
import com.example.opsecmessenger.models.NoteModal;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView mRecyclerView;
    private NoteRecyclerViewAdapter mAdapter;

    public NoteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NoteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NoteFragment newInstance(String param1, String param2) {
        NoteFragment fragment = new NoteFragment();
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
        View view =  inflater.inflate(R.layout.fragment_note, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView =  getActivity().findViewById(R.id.action_bar_title);
//        ImageButton nav_draw =  getActivity().findViewById(R.id.nav_drawer_icon);
//        ImageButton search =  getActivity().findViewById(R.id.search);
//        textView.setText("Note");
//        nav_draw.setImageResource(R.drawable.ic_back_arrow_icon);
//        search.setVisibility(View.INVISIBLE);
        view.findViewById(R.id.floating_action_button).setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
    }

    private void  initRecyclerView(){
        List<NoteModal> noteList = new ArrayList<>();
        noteList.add(new NoteModal("2-5-2019","Lorem Ipsum","Lorem Ipsum is simply dummy"));
        noteList.add(new NoteModal("2-5-2019","Lorem Ipsum","Lorem Ipsum is simply dummy"));
        noteList.add(new NoteModal("2-5-2019","Lorem Ipsum","Lorem Ipsum is simply dummy"));
        noteList.add(new NoteModal("2-5-2019","Lorem Ipsum","Lorem Ipsum is simply dummy"));

        mAdapter = new NoteRecyclerViewAdapter(getContext(),noteList);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_noteFragment_to_editNoteFragment);
    }
}
