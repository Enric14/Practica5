package es.travelworld.practica5;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.button.MaterialButton;

import es.travelworld.practica5.databinding.FragmentThreeBinding;
import es.travelworld.practica5.databinding.FragmentTwoBinding;

public class ThreeFragment extends Fragment {

    private FragmentThreeBinding binding;

    private MaterialButton materialButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentThreeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        materialButton = binding.mainBtnOnboardingTresApp;

        materialButton.setOnClickListener(view1 -> NavHostFragment.findNavController(ThreeFragment.this)
                .navigate(R.id.action_threeFragment_to_mainFragment));


    }
}
