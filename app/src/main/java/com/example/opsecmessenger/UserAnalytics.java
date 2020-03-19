package com.example.opsecmessenger;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.opsecmessenger.adapters.AnalyticsPagerViewAdapter;
import com.example.opsecmessenger.models.AnalyticsViewPagerModel;
import com.example.opsecmessenger.viewmodels.UserAnalyticsViewModel;

import java.util.ArrayList;

public class UserAnalytics extends Fragment {

    private UserAnalyticsViewModel mViewModel;
    ViewPager2 viewPager;

    public static UserAnalytics newInstance() {
        return new UserAnalytics();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.user_analytics_fragment, container, false);
        viewPager = view.findViewById(R.id.view_pager);
        ArrayList<AnalyticsViewPagerModel> list = new ArrayList<>();
        list.add(new AnalyticsViewPagerModel("TOKEN KEY", getResources().getDrawable(R.drawable.ic_active_state_icon)));
        list.add(new AnalyticsViewPagerModel("SOLD KEYS", getResources().getDrawable(R.drawable.ic_key_icon)));
        list.add(new AnalyticsViewPagerModel("TOTAL USER", getResources().getDrawable(R.drawable.ic_key_icon)));
        viewPager.setAdapter(new AnalyticsPagerViewAdapter(viewPager, list));
        viewPager.setOffscreenPageLimit(3);
        viewPager.setClipToPadding(false);
        viewPager.setClipChildren(false);
        viewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer pageTransformer = new CompositePageTransformer();
        pageTransformer.addTransformer(new MarginPageTransformer(20));


        viewPager.setPageTransformer(pageTransformer);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UserAnalyticsViewModel.class);
        // TODO: Use the ViewModel

    }

}
