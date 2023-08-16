package es.travelworld.practica5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import es.travelworld.practica5.databinding.FragmentHomeOneBinding;

public class HomeOneFragment extends Fragment {

    private FragmentHomeOneBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeOneBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CarAdapter carAdapter = new CarAdapter(RepositoryCars.getListCar(), new CarAdapter.OnCarItem() {

            @Override
            public void onStartClick(Car itemSelected) {
                
            }

            @Override
            public void onCarClick(Car itemSelected) {
                Toast.makeText(getActivity(), "El transporte seleccionado es el " +itemSelected.getNameCar(), Toast.LENGTH_SHORT).show();

            }
        });

        binding.carsRv.setHasFixedSize(true);
        binding.carsRv.setAdapter(carAdapter);
    }
}