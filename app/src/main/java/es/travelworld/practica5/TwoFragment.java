package es.travelworld.practica5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;

import es.travelworld.practica5.databinding.FragmentOneBinding;
import es.travelworld.practica5.databinding.FragmentTwoBinding;

public class TwoFragment extends Fragment {

    private FragmentTwoBinding binding;
    private MaterialButton materialButtonOne;
    private MaterialButton materialButtonTwo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTwoBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        materialButtonOne = binding.mainBtnOnboardingDosOneApp;
        materialButtonTwo = binding.mainBtnOnboardingDosTwoApp;

        materialButtonOne.setOnClickListener(view1 -> NavHostFragment.findNavController(TwoFragment.this)
                .navigate(R.id.action_twoFragment_to_mainFragment));

        materialButtonTwo.setOnClickListener(view12 -> NavHostFragment.findNavController(TwoFragment.this)
                .navigate(R.id.action_twoFragment_to_threeFragment));

    }


}
