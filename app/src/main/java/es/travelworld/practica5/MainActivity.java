package es.travelworld.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.google.android.material.button.MaterialButton;


import es.travelworld.practica5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    EditText name, surnames;
    MaterialButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        name = binding.mainUsername;
        surnames = binding.mainPassword;
        btn = binding.mainBtn;

        binding.mainUsername.addTextChangedListener(textWatcher);
        binding.mainPassword.addTextChangedListener(textWatcher);

        SharedPreferences sharedPreferences =getSharedPreferences("MyApp", MODE_PRIVATE);

        btn.setOnClickListener(view -> {
            String nombreGuardado = sharedPreferences.getString("NOMBRE", null);
            String apellidosGuardados = sharedPreferences.getString("APELLIDOS", null);
            String nombreActual = name.getText().toString();
            String apellidosActual = surnames.getText().toString();

            if(nombreGuardado != null && apellidosGuardados != null) {
                if (nombreActual.equals(nombreGuardado) && apellidosActual.equals(apellidosGuardados)) {
                Intent intent = new Intent(getApplicationContext(),MainActivityTres.class);
                startActivity(intent);
            } else {
                    new AlertDialog.Builder(this)
                            .setTitle("ERROR")
                            .setMessage("Verifique los datos")
                            .setNeutralButton(R.string.main_btn_message, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .show();
            }

        } else {
                surnames.setError("Guarde nombre y apellidos");
        }

        });

    }
    public void textviewCreateNew (View view) {
        Intent intentExplicito = new Intent(this, MainActivityDos.class);
        startActivity(intentExplicito);
    }


    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String text1 = binding.mainUsername.getText().toString().trim();
            String text2 = binding.mainPassword.getText().toString().trim();
            binding.mainBtn.setEnabled(!text1.isEmpty() && !text2.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}