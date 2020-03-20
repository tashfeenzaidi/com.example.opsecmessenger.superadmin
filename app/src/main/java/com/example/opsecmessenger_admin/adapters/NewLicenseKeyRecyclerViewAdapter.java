package com.example.opsecmessenger_admin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.opsecmessenger_admin.R;
import com.example.opsecmessenger_admin.models.UserRecyclerViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewLicenseKeyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private List<UserRecyclerViewModel> mUser= new ArrayList<>();
	private Context mContext;

	public NewLicenseKeyRecyclerViewAdapter(Context mContext, List<UserRecyclerViewModel> mUser) {
		this.mUser = mUser;
		this.mContext = mContext;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_license_key_single_item, parent, false);
		ViewHolder vh = new ViewHolder(view);
		return vh;
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
		// Set the name of the 'NicePlace'
		((ViewHolder)holder).userName.setText(mUser.get(position).getName());
		((ViewHolder)holder).shortDescription.setText(mUser.get(position).getShortDescription());
		ImageView imageView = ((ViewHolder) holder).picture_frame;
		Glide.with(mContext).load(R.drawable.picture).into(imageView);



	}

	@Override
	public int getItemCount() {
		return mUser.size();
	}

	private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

		private TextView userName, shortDescription;
		private ImageView picture_frame;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);

			userName = itemView.findViewById(R.id.user_name);
			shortDescription = itemView.findViewById(R.id.short_description);
			picture_frame = itemView.findViewById(R.id.picture_frame);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View view) {
			Navigation.findNavController(view).navigate(R.id.action_home_to_chatUser);
		}
	}

}