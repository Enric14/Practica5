package es.travelworld.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.android.material.textfield.TextInputEditText;

import es.travelworld.practica5.databinding.ActivityMainDosBinding;

public class MainActivityDos extends AppCompatActivity {

    private ActivityMainDosBinding binding;
    EditText name, surnames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainDosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AutoCompleteTextView autoCompleteTextView = binding.main2Ages;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivityDos.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ages));

        autoCompleteTextView.setAdapter(arrayAdapter);

        EditText nameEditText = binding.main2InputName;
        EditText surnamesEditText = binding.main2InputSurnames;
        AutoCompleteTextView ageAutoCompleteTextView = binding.main2Ages;
        Button submitbutton = binding.main2Btn;
        binding.main2InputName.addTextChangedListener(textWatcher);
        binding.main2InputSurnames.addTextChangedListener(textWatcher);

        submitbutton.setOnClickListener(view -> {
            String inputTextName = nameEditText.getText().toString();
            String inputTextSurnames = surnamesEditText.getText().toString();
            String ageSelected = ageAutoCompleteTextView.getText().toString();
            ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(MainActivityDos.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ages));

            if (inputTextName.contains(".") || inputTextName.contains("@")) {
                nameEditText.setError("Ups, no creo que sea correcto, revísalo");

            } else if (inputTextSurnames.contains(".") || inputTextSurnames.contains("@")) {
                surnamesEditText.setError("Ups, no creo que sea correcto, revísalo");

            } else if (!ageSelected.contains("18-99")) {
                ageAutoCompleteTextView.setError("Esta app no es para ti");

            } else {
                String nombre = nameEditText.getText().toString();
                String apellidos = surnamesEditText.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("MyApp", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("NOMBRE", nombre);
                editor.putString("APELLIDOS", apellidos);
                editor.apply();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("NOMBRE", nombre);
                intent.putExtra("APELLIDOS", apellidos);
                startActivity(intent);

            }
        });

    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String text1 = binding.main2InputName.getText().toString().trim();
            String text2 = binding.main2InputSurnames.getText().toString().trim();
            binding.main2Btn.setEnabled(!text1.isEmpty() && !text2.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void abrirPolitica(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developers.google.com/ml-kit/terms"));
        startActivity(i);
    }

    public void abrirCamara(View view) {
        Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(i);
    }

}