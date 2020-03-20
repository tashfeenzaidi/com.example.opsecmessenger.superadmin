package com.example.opsecmessenger_admin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.PopupMenu;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.opsecmessenger_admin.R;
import com.example.opsecmessenger_admin.models.UserRecyclerViewModel;

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
		ImageView imageView = ((ViewHolder) holder).picture_frame;
		ImageView imageViewDots = ((ViewHolder) holder).dots;
		Glide.with(mContext).load(R.drawable.picture).into(imageView);

		imageViewDots.setOnClickListener(view -> {

			showMenu(imageViewDots);

		});

	}

	public boolean showMenu(View anchor) {
		PopupMenu popup = new PopupMenu(mContext, anchor);
		popup.getMenuInflater().inflate(R.menu.chat_user_menu, popup.getMenu());
		popup.show();
		popup.setOnMenuItemClickListener(item -> {
			switch (item.getItemId()) {
				case R.id.edit:
					//handle menu1 click
					return true;
				case R.id.block_user:
					//handle menu2 click
					return true;
				default:
					return false;
			}
		});
		return true;
	}

	@Override
	public int getItemCount() {
		return mUser.size();
	}

	private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

		private TextView userName, shortDescription;
		private ImageView picture_frame, dots;


		public ViewHolder(@NonNull View itemView) {
			super(itemView);

			userName = itemView.findViewById(R.id.user_name);
			shortDescription = itemView.findViewById(R.id.short_description);
			picture_frame = itemView.findViewById(R.id.picture_frame);
			dots = itemView.findViewById(R.id.dots);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View view) {
			Navigation.findNavController(view).navigate(R.id.action_home_to_chatUser);
		}
	}

}