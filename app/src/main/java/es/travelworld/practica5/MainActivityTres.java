package es.travelworld.practica5;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import es.travelworld.practica5.databinding.ActivityMainThreeBinding;

public class MainActivityTres extends AppCompatActivity {

    private ActivityMainThreeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainThreeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String nombre = getIntent().getStringExtra("NOMBRE");
        String apellidos = getIntent().getStringExtra("APELLIDOS");

        SharedPreferences sharedPreferences = getSharedPreferences("MyApp", MODE_PRIVATE);
        String username = sharedPreferences.getString("NOMBRE", null);
        String password = sharedPreferences.getString("APELLIDOS", null);

        Log.d("HomeActivity", "NOMBRE: " + nombre + ", APELLIDOS: " + apellidos);

    }



}