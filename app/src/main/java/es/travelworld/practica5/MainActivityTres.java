package es.travelworld.practica5;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import es.travelworld.practica5.databinding.ActivityMainTresBinding;

public class MainActivityTres extends AppCompatActivity {

    private ActivityMainTresBinding binding;

    private ViewPager2 viewPager2Home;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainTresBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager2Home = binding.contentVp2Home;
        tabLayout = binding.activityMainThreeTablayout;

        PagerDosAdapter adapterDos = new PagerDosAdapter(this);
        binding.contentVp2Home.setAdapter(adapterDos);

        new TabLayoutMediator(tabLayout, viewPager2Home, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setIcon(R.drawable.baseline_add_a_photo_24);
                    break;
                case 1:
                    tab.setIcon(R.drawable.baseline_directions_car_24);
                    break;
                case 2:
                    tab.setIcon(R.drawable.baseline_landscape_24);
                    break;
                case 3:
                    tab.setIcon(R.drawable.baseline_face_24);
                    break;
            }

        }).attach();

    }

}


