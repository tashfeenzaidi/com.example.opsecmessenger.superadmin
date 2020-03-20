package com.example.opsecmessenger_admin.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.opsecmessenger_admin.R;
import com.example.opsecmessenger_admin.models.AnalyticsViewPagerModel;

import java.util.ArrayList;

public class AnalyticsPagerViewAdapter extends RecyclerView.Adapter<AnalyticsPagerViewAdapter.PagerViewHolder> {

    private ViewPager2 viewPager2;
    ArrayList<AnalyticsViewPagerModel> list;

    public AnalyticsPagerViewAdapter(ViewPager2 viewPager2, ArrayList<AnalyticsViewPagerModel> list) {
        this.viewPager2 = viewPager2;
        this.list = list;
    }

    @NonNull
    @Override
    public PagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.analytics_viewpager_item, parent, false);
        AnalyticsPagerViewAdapter.PagerViewHolder vh = new AnalyticsPagerViewAdapter.PagerViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PagerViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
        holder.imageView.setImageDrawable(list.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PagerViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        public PagerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item);
            imageView = itemView.findViewById(R.id.image);

        }
    }

}
