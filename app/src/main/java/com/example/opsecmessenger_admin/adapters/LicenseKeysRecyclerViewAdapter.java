package com.example.opsecmessenger_admin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opsecmessenger_admin.R;
import com.example.opsecmessenger_admin.models.LicenseKeysModel;

import java.util.ArrayList;
import java.util.List;

public class LicenseKeysRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private List<LicenseKeysModel> mlicenseKeys= new ArrayList<>();
	private Context mContext;

	public LicenseKeysRecyclerViewAdapter(Context mContext, List<LicenseKeysModel> mlicenseKeys) {
		this.mlicenseKeys = mlicenseKeys;
		this.mContext = mContext;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.license_key_single_item, parent, false);
		ViewHolder vh = new ViewHolder(view);
		return vh;
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
		// Set the name of the 'NicePlace'
//		((ViewHolder)holder).licenseKey.setText(mlicenseKeys.get(position).getLicense_key());
		//((ViewHolder)holder).shortDescription.setText(mlicenseKeys.get(position).isStatus());

//		if (mlicenseKeys.get(position).isStatus()){
//			LayerDrawable shape = (LayerDrawable) ContextCompat.getDrawable(mContext,R.drawable.radio_button	);
//			try {
//				shape.findDrawableByLayerId(R.id.second).setTint(mContext.getResources().getColor(R.color.colorAccent));
//
//			}catch (Exception e){
//
//			}
//
//		}
	}

	@Override
	public int getItemCount() {
		return mlicenseKeys.size();
	}

	private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

		private TextView licenseKey;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);

			licenseKey = itemView.findViewById(R.id.license_key);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View view) {
			Navigation.findNavController(view).navigate(R.id.adminFragment);
		}
	}

}