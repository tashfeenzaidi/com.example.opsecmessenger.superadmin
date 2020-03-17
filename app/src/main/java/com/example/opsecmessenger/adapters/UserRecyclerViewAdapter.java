package com.example.opsecmessenger.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opsecmessenger.R;
import com.example.opsecmessenger.models.UserRecyclerViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private List<UserRecyclerViewModel> mUser= new ArrayList<>();
	private Context mContext;

	public UserRecyclerViewAdapter(Context mContext,List<UserRecyclerViewModel> mUser) {
		this.mUser = mUser;
		this.mContext = mContext;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_user_singal_item_view, parent, false);
		ViewHolder vh = new ViewHolder(view);
		return vh;
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
		// Set the name of the 'NicePlace'
		((ViewHolder)holder).userName.setText(mUser.get(position).getName());
		((ViewHolder)holder).shortDescription.setText(mUser.get(position).getShortDescription());

	}

	@Override
	public int getItemCount() {
		return mUser.size();
	}

	private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

		private TextView userName, shortDescription;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);

			userName = itemView.findViewById(R.id.user_name);
			shortDescription = itemView.findViewById(R.id.short_description);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View view) {
			Navigation.findNavController(view).navigate(R.id.action_home_to_chatUser);
		}
	}

}