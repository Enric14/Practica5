package es.travelworld.practica5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.appbar.MaterialToolbar;

import es.travelworld.practica5.databinding.ActivityMainThreeBinding;

public class MainActivityTres extends AppCompatActivity {

    private ActivityMainThreeBinding binding;
    private MaterialToolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainThreeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.main3_content_fragment, MainTresFragment.class, null)
                    .commit();

        }

    }
}

