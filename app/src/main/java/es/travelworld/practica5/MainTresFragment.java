package es.travelworld.practica5;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import es.travelworld.practica5.databinding.FragmentMainBinding;
import es.travelworld.practica5.databinding.FragmentMainTresBinding;

public class MainTresFragment extends Fragment {

    private FragmentMainTresBinding binding;
    private ConstraintLayout constraintLayout;
    private MaterialToolbar materialToolbar;
    private ConstraintLayout constraintFragmentTres;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainTresBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        constraintLayout = binding.main3Constraint;
        materialToolbar = binding.main3Toolbar;
        constraintFragmentTres = binding.main3Constraint;

        materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menu_eurodisney) {
                    Intent intentEurodisney = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.disneylandparis.com/ es-es/?country=es&ecid=SEM_IP_S_3681537557-c-98352306134-88087225-661075406384-Exact&gclsrc=aw.ds&&mkwid=9yQLWOgc&gclid=EAIaIQobChMIqpzEwYn__wIVyzfUAR3EYgp7EAAYASAAEgLFNPD_BwE&pcrid=661075406384&pmt=e&pkw=eurodisney"));
                    startActivity(intentEurodisney);

                } else {
                    getActivity().getSupportFragmentManager().beginTransaction();
                    NavHostFragment.findNavController(MainTresFragment.this)
                            .navigate(R.id.action_mainTresFragment_to_mainCuatroFragment);
                    constraintFragmentTres.setVisibility(View.GONE);

                }
                return false;
            }
        });


        Intent intent = getActivity().getIntent();
        String nombre = getActivity().getIntent().getStringExtra("NOMBRE");
        String apellidos = getActivity().getIntent().getStringExtra("APELLIDOS");

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyApp", MODE_PRIVATE);
        String username = sharedPreferences.getString("NOMBRE", null);
        String password = sharedPreferences.getString("APELLIDOS", null);

        Log.d("HomeActivity", "NOMBRE: " + nombre + ", APELLIDOS: " + apellidos);

        Snackbar.make(constraintLayout, "NOMBRE: null, APELLIDOS: null", Snackbar.LENGTH_LONG).show();

    }
}