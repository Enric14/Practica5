package es.travelworld.practica5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import es.travelworld.practica5.databinding.ActivityMainOnboardingBinding;

public class MainOnboardingActivity extends AppCompatActivity {

    private ActivityMainOnboardingBinding binding;

    private ViewPager2 viewPager2;

    private final static int NUM_PAGES = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainOnboardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager2 = binding.contentVp2;

        PagerAdapter adapter = new PagerAdapter(this);
        binding.contentVp2.setAdapter(adapter);

    }

    public void moveToNextPage() {
        int nextItem = viewPager2.getCurrentItem() + 1;
        if (nextItem < NUM_PAGES) {
            viewPager2.setCurrentItem(nextItem);
        }
    }
}