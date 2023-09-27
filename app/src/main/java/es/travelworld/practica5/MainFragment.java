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

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import es.travelworld.practica5.databinding.FragmentMainBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private ConstraintLayout constraintLayout;
    private EditText username, password;
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
        username = binding.mainUsername;
        password = binding.mainPassword;


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

        username.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);

        view.findViewById(R.id.main_btn).setOnClickListener(view12 -> {
            login();

        });

    }

    public void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    startActivity(new Intent(getActivity(), MainActivityTres.class).putExtra("data", loginResponse.getNombre()));

                } else {
                    Snackbar snackbar = Snackbar.make(constraintLayout, "Acceso denegado, revisa los datos...", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Snackbar snackbar = Snackbar.make(constraintLayout, "Throwable "+t.getLocalizedMessage(), Snackbar.LENGTH_LONG);
                snackbar.show();

            }
        });
    }

}

