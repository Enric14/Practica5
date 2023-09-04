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
import com.google.android.material.textview.MaterialTextView;

import es.travelworld.practica5.databinding.FragmentMainBinding;
import es.travelworld.practica5.databinding.FragmentMainTresBinding;

public class MainTresFragment extends Fragment {

    private FragmentMainTresBinding binding;
    private ConstraintLayout constraintLayout;

    private String dato_recibido;


    /**
     * VictorVergel.
     * Añadimos el constructor estático para crear el Fragment y le metemos como parámetro del bundle
     */

    private static final String ARG_PARAM1 = "param1";

    public MainTresFragment() {
        // Required empty public constructor
    }

    public static MainTresFragment newInstance(Bundle param1) {
        MainTresFragment fragment = new MainTresFragment();
        /*Bundle args = new Bundle();
        args.putBundle(ARG_PARAM1,param1);*/
        fragment.setArguments(param1);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dato_recibido = getArguments().getString("nombre");
        }
    }


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

        /** VictorVergel
         * Recuperamos el dato metido en el Bundle
         */
        Log.d("depurando", "Llega a MainTresFragment el dato a través de Bundle: " + dato_recibido);


        Intent intent = getActivity().getIntent();
        String nombre = getActivity().getIntent().getStringExtra("NOMBRE");
        String apellidos = getActivity().getIntent().getStringExtra("APELLIDOS");

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyApp", MODE_PRIVATE);
        String username = sharedPreferences.getString("NOMBRE", null);
        String password = sharedPreferences.getString("APELLIDOS", null);

        Log.d("HomeActivity", "NOMBRE: " + nombre + ", APELLIDOS: " + apellidos);

        //Snackbar.make(constraintLayout, "NOMBRE: null, APELLIDOS: null", Snackbar.LENGTH_LONG).show();

    }
}