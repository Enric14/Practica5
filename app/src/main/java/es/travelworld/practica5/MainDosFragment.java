package es.travelworld.practica5;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import es.travelworld.practica5.databinding.FragmentMainDosBinding;

public class MainDosFragment extends Fragment {

    private FragmentMainDosBinding binding;
    private MaterialButton photoButton;
    private MaterialTextView materialTextView;

    private TextInputEditText name, password;
    private Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainDosBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        photoButton = binding.main2Btn2;
        materialTextView = binding.main2TextView2;
        name = binding.main2InputName;
        password = binding.main2InputPassword;
        AutoCompleteTextView ageAutoCompleteTextView = binding.main2Ages;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ages));

        ageAutoCompleteTextView.setAdapter(arrayAdapter);

        photoButton.setOnClickListener(view1 -> {
            Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivity(i);
        });

        materialTextView.setOnClickListener(view12 -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developers.google.com/ml-kit/terms"));
            startActivity(i);
        });

        TextWatcher textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text1 = binding.main2InputName.getText().toString().trim();
                String text2 = binding.main2InputPassword.getText().toString().trim();
                binding.main2Btn.setEnabled(!text1.isEmpty() && !text2.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        name.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);

        view.findViewById(R.id.main2_btn).setOnClickListener(view13 -> {
            String inputTextName = name.getText().toString();
            String inputTextPassword = password.getText().toString();
            String ageSelected = ageAutoCompleteTextView.getText().toString();

            if (inputTextName.contains(".") || inputTextName.contains("@")) {
                name.setError("Ups, no creo que sea correcto, revísalo");

            } else if (inputTextPassword.contains(".") || inputTextPassword.contains("@")) {
                password.setError("Ups, no creo que sea correcto, revísalo");

            } else if (!ageSelected.contains("18-99")) {
                ageAutoCompleteTextView.setError("Esta app no es para ti");

            } else {
                String nombre = name.getText().toString();
                String contraseña = password.getText().toString();
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyApp", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("NOMBRE", nombre);
                Bundle bundle = new Bundle();
                bundle.putString("nombre", nombre);
                getParentFragmentManager().setFragmentResult("dato_main_dos_fragment", bundle);

                editor.putString("PASSWORD", contraseña);
                editor.apply();
                NavHostFragment.findNavController(MainDosFragment.this)
                        .navigate(R.id.action_mainDosFragment_to_mainFragment);
            }
        });
    }
}