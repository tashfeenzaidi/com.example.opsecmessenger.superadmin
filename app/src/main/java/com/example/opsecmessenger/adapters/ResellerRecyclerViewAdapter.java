package com.example.opsecmessenger.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opsecmessenger.R;
import com.example.opsecmessenger.models.ResellerModel;
import com.example.opsecmessenger.models.UserRecyclerViewModel;

import java.util.ArrayList;
import java.util.List;

public class ResellerRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ResellerModel> list = new ArrayList<>();
    private Context mContext;

    public ResellerRecyclerViewAdapter(Context mContext, List<ResellerModel> list) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reseller_list_item_layout, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // Set the name of the 'NicePlace'
        ((ViewHolder) holder).user_name.setText(list.get(position).getName());
        ((ViewHolder) holder).keys.setText(String.valueOf(list.get(position).getKeys()));
        ((ViewHolder) holder).tokens.setText(String.valueOf(list.get(position).getKeys()));
        ((ViewHolder) holder).messages.setText(String.valueOf(list.get(position).getKeys()));
        ((ViewHolder) holder).profiles.setText(String.valueOf(list.get(position).getKeys()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView user_name, keys, tokens, messages, profiles;
        private ImageView picture_frame;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            user_name = itemView.findViewById(R.id.user_name);
            keys = itemView.findViewById(R.id.keys);
            tokens = itemView.findViewById(R.id.tokens);
            messages = itemView.findViewById(R.id.messages);
            profiles = itemView.findViewById(R.id.profiles);
            picture_frame = itemView.findViewById(R.id.picture_frame);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Navigation.findNavController(view).navigate(R.id.resellerFragment);
        }
    }

}