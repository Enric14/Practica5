package es.travelworld.practica5;

import static android.content.Context.MODE_PRIVATE;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import es.travelworld.practica5.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private ConstraintLayout constraintLayout;
    private EditText name, surnames;
    private Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        constraintLayout = binding.mainContent1Fragment;
        name = binding.mainUsername;
        surnames = binding.mainPassword;


        view.findViewById(R.id.main_create_new_account).setOnClickListener(view1 -> {
            NavHostFragment.findNavController(MainFragment.this)
                    .navigate(R.id.action_mainFragment_to_mainDosFragment);
            constraintLayout.setVisibility(View.GONE);
        });

        TextWatcher textWatcher = new TextWatcher() {
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

        name.addTextChangedListener(textWatcher);
        surnames.addTextChangedListener(textWatcher);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyApp", MODE_PRIVATE);

        view.findViewById(R.id.main_btn).setOnClickListener(view12 -> {
            String nombreGuardado = sharedPreferences.getString("NOMBRE", null);
            String apellidosGuardados = sharedPreferences.getString("APELLIDOS", null);
            String nombreActual = name.getText().toString();
            String apellidosActual = surnames.getText().toString();

            if (nombreGuardado != null && apellidosGuardados != null) {
                if (nombreActual.equals(nombreGuardado) && apellidosActual.equals(apellidosGuardados)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("nombre", "****dato prueba****");
                    Intent intent = new Intent(getActivity(), MainActivityTres.class);
                    intent.putExtra("dato_a_Activity_Tres", bundle);
                    startActivity(intent);
                    getParentFragmentManager().setFragmentResultListener("dato_main_dos_fragment", this, new FragmentResultListener() {
                        @Override
                        public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                            Log.d("depurando", result.getString("nombre"));
                        }
                    });
                } else {
                    new AlertDialog.Builder(getContext())
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

            }

        });

    }

}

