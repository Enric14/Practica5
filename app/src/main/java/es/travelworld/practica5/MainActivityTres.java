package es.travelworld.practica5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

import es.travelworld.practica5.databinding.ActivityMainThreeBinding;

public class MainActivityTres extends AppCompatActivity {

    private ActivityMainThreeBinding binding;

    private TabLayout tabLayout;
    private ViewPager2 viewPager2Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainThreeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tabLayout = binding.activityMainThreeTablayout;
        viewPager2Home = binding.contentVp2Home;

        PagerDosAdapter adapterDos = new PagerDosAdapter(this);
        binding.contentVp2Home.setAdapter(adapterDos);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2Home.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2Home.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

    }

}


