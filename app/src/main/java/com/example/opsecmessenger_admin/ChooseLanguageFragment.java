package com.example.opsecmessenger_admin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.opsecmessenger_admin.models.LanguageModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChooseLanguageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseLanguageFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private AutoCompleteTextView editTextFilledExposedDropdown;
    private TextInputLayout textInputLayout;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChooseLanguageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChooseLanguageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChooseLanguageFragment newInstance(String param1, String param2) {
        ChooseLanguageFragment fragment = new ChooseLanguageFragment();
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

//        View view =  getActivity().getCurrentFocus();
//        if (view != null){
//
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_choose_language, container, false);
        editTextFilledExposedDropdown =
                view.findViewById(R.id.lan_filled_exposed_dropdown);
        textInputLayout = view.findViewById(R.id.textInputLayout);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //dropdown items  adapter
        String[] COUNTRIES = new String[] {"English", "Dutch"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        getContext(),
                        R.layout.choose_language_dropdown_layout,
                        COUNTRIES);

        //LanguageArrayAdapter adapter = new LanguageArrayAdapter(getActivity(), 0,fillCountryList());
        editTextFilledExposedDropdown.setAdapter(adapter);
        editTextFilledExposedDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // editTextFilledExposedDropdown.setCompoundDrawables(R.drawable.flag_usa,0,0,0);
            }
        });
        InputMethodManager methodManager = (InputMethodManager) getActivity().getSystemService(getContext().INPUT_METHOD_SERVICE);
        methodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
        Button submit = view.findViewById(R.id.submit);
        submit.setText(R.string.save);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.lan_filled_exposed_dropdown:
                break;
            case R.id.submit:
                Navigation.findNavController(view).navigate(R.id.action_chooseLanguageFragment_to_home);
                break;
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().findViewById(R.id.bottom_navigation).setVisibility(View.GONE);
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().findViewById(R.id.bottom_navigation).setVisibility(View.VISIBLE);

    }

        private List<LanguageModel>  fillCountryList() {
        List<LanguageModel> list = new ArrayList<>();
        list.add(new LanguageModel(R.drawable.flag_us,"English"));
        list.add(new LanguageModel(R.drawable.flag_dutch,"English"));
        return list;
    }

}
