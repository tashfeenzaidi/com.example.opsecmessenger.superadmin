package com.example.opsecmessenger_admin;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class WelcomeActivity extends AppCompatActivity implements
        View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    NavController navController;

    public Toolbar toolbar;

    public DrawerLayout drawerLayout;

    public NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setupNavigation();

//        findViewById(R.id.nav_drawer_icon).setOnClickListener(this);

//        findViewById(R.id.search).setOnClickListener(this);

        TabLayout tabLayout = findViewById(R.id.bottom_navigation);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {

                    case 0:
                        navController.navigate(R.id.adminFragment);
                        break;
                    case 1:
                        navController.navigate(R.id.profileFragment);
                        break;
                    case 2:
                        navController.navigate(R.id.userAnalytics);
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        NavHostFragment navHost = (NavHostFragment)  getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
//        NavController navController = navHost.getNavController();
//
//        NavInflater navInflater = navController.getNavInflater();
//        NavGraph graph = navInflater.inflate(R.navigation.nav_graph);
//
//        graph.setStartDestination(R.id.adminFragment);
//
//        navController.setGraph(graph);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search:
                navController.navigate(R.id.searchFragment);
                break;

//            case R.id.nav_drawer_icon:
//                DrawerLayout navDrawer = findViewById(R.id.drawer_layout);
//                // If the navigation drawer is not open then open it, if its already open then close it.
//                if (!navDrawer.isDrawerOpen(GravityCompat.START))
//                    navDrawer.openDrawer(GravityCompat.START);
//                else navDrawer.closeDrawer(GravityCompat.END);
//                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            navController.navigate(R.id.searchFragment);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);

        drawerLayout.closeDrawers();

        int id = item.getItemId();

        switch (id) {

            case R.id.license_key:
                navController.navigate(R.id.newLicenseKeyFragment);
                break;

            case R.id.reseller_list:
                navController.navigate(R.id.resellersFragment);

                break;

            case R.id.chat_user:
                navController.navigate(R.id.home);
                break;
            case R.id.pass_reset:
                navController.navigate(R.id.resetPasswordFragment);
                break;
            case R.id.language:
                navController.navigate(R.id.chooseLanguageFragment);
                break;
            case R.id.modify_token:
                navController.navigate(R.id.modifyTokenFragment);
                break;

           case R.id.logout:
                    navController.navigate(R.id.fragment_login);
                    break;

            }
        return true;

    }

    // Setting Up One Time Navigation
    private void setupNavigation() {

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("welcome");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.navigationView);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);

        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(this);

        View view =  navigationView.getHeaderView(0);
        ImageView imageView = view.findViewById(R.id.picture);
        Glide.with(this).load(R.drawable.picture).into(imageView);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), drawerLayout);
    }

}
