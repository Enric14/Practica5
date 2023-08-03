package es.travelworld.practica5;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

import es.travelworld.practica5.databinding.FragmentOneBinding;
import es.travelworld.practica5.databinding.FragmentTwoBinding;

public class TwoFragment extends Fragment {

    private FragmentTwoBinding binding;

    private MaterialButton materialButton;

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

        materialButton = binding.mainBtnOnboardingDosTwoApp;

        view.findViewById(R.id.main_btn_onboarding_dos_one_app).setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(),MainActivity.class);
            startActivity(intent);

        });

        materialButton.setOnClickListener(view12 -> ((MainOnboardingActivity) getActivity()).moveToNextPage());

    }
}
