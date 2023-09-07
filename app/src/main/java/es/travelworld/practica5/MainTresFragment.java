package es.travelworld.practica5;

import static android.content.Context.MODE_PRIVATE;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textview.MaterialTextView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;

import es.travelworld.practica5.databinding.FragmentMainBinding;
import es.travelworld.practica5.databinding.FragmentMainTresBinding;

public class MainTresFragment extends Fragment {

    private FragmentMainTresBinding binding;
    private ConstraintLayout constraintLayout;
    private String dato_recibido;

    private static final String ARG_PARAM1 = "param1";

    public MainTresFragment() {
        // Required empty public constructor
    }

    public static MainTresFragment newInstance(Bundle param1) {
        MainTresFragment fragment = new MainTresFragment();
        fragment.setArguments(param1);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestPermissions();

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

        Log.d("depurando", "Llega a MainTresFragment el dato a través de Bundle: " + dato_recibido);

        Intent intent = getActivity().getIntent();
        String nombre = getActivity().getIntent().getStringExtra("NOMBRE");
        String apellidos = getActivity().getIntent().getStringExtra("APELLIDOS");

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyApp", MODE_PRIVATE);
        String username = sharedPreferences.getString("NOMBRE", null);
        String password = sharedPreferences.getString("APELLIDOS", null);

        Log.d("HomeActivity", "NOMBRE: " + nombre + ", APELLIDOS: " + apellidos);

    }

    private void requestPermissions() {
        Dexter.withContext(getActivity()).withPermissions(Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {

                if (multiplePermissionsReport.areAllPermissionsGranted()) {
                    Toast.makeText(getActivity(), "Accediendo a la Home...", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "Es necesario aceptar los permisos para continuar...", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();

            }
        }).check();
    }

}

