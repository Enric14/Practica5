package es.travelworld.practica5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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

        binding.main3Toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.menu_eurodisney) {
                    Intent intentEurodisney = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.disneylandparis.com/es-es/?country=es&ecid=SEM_IP_S_3681537557-c-98352306134-88087225-661075406384-Exact&gclsrc=aw.ds&&mkwid=9yQLWOgc&gclid=EAIaIQobChMIqpzEwYn__wIVyzfUAR3EYgp7EAAYASAAEgLFNPD_BwE&pcrid=661075406384&pmt=e&pkw=eurodisney"));
                    startActivity(intentEurodisney);

                } else {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    MainTresFragment mainTresFragment = new MainTresFragment();
                    transaction.add(binding.main3ContentFragment.getId(),mainTresFragment);
                    transaction.commitAllowingStateLoss();

                }
                return false;
            }
        });
    }
}