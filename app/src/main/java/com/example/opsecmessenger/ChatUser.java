package com.example.opsecmessenger;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.opsecmessenger.viewmodels.ChatUserViewModel;

public class ChatUser extends Fragment implements View.OnClickListener{

    private ChatUserViewModel mViewModel;

    public static ChatUser newInstance() {
        return new ChatUser();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.chat_user_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.license_key).setOnClickListener(this);
        view.findViewById(R.id.change_password).setOnClickListener(this);
        Glide.with(this).load(R.drawable.profile_pic).into((ImageView) view.findViewById(R.id.picture));

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ChatUserViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().findViewById(R.id.toolbar).setVisibility(View.GONE);
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().findViewById(R.id.toolbar).setVisibility(View.VISIBLE);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.license_key:
                Navigation.findNavController(view).navigate(R.id.action_chatUser_to_licenseKey);
                break;
            case R.id.change_password:
                Navigation.findNavController(view).navigate(R.id.action_chatUser_to_changePasswordFragment);
                break;
        }

    }

}
