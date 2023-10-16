package es.travelworld.practica5;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

import es.travelworld.practica5.databinding.FragmentMainTresBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainTresFragment extends Fragment {

    private FragmentMainTresBinding binding;
    private RecyclerView recyclerView;
    private List<HotelResult> hotelResults;
    private HotelAdapter hotelAdapter;
    private ConstraintLayout constraintLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestPermissions();

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

        Intent intent = getActivity().getIntent();
        if (intent.getExtras()!= null) {
            
        }
        String usuario = intent.getStringExtra("login");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Notification", "Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(), "Notification");
        builder.setContentTitle("Bienvenido/a "+usuario);
        builder.setContentText("Nos alegra verte en este paraíso");
        builder.setSmallIcon(R.drawable.baseline_beach_access_24);
        builder.setAutoCancel(true);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.notification_img);
        builder.setLargeIcon(bitmap);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null));

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getActivity());
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        managerCompat.notify(1, builder.build());

        constraintLayout = binding.main3Constraint;
        recyclerView = binding.hotelsRv;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        showHotels();
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

    private void showHotels() {
        Call<List<HotelResult>> call = RetrofitClient.getClient().create(APIs.class).getHotels();
        call.enqueue(new Callback<List<HotelResult>>() {
            @Override
            public void onResponse(Call<List<HotelResult>> call, Response<List<HotelResult>> response) {
                if (response.isSuccessful()) {
                    hotelResults= response.body();
                    hotelAdapter = new HotelAdapter((Context) hotelResults, (List<HotelResult>) getActivity().getApplicationContext());
                    recyclerView.setAdapter(hotelAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<HotelResult>> call, Throwable t) {
                Snackbar snackbar = Snackbar.make(constraintLayout, "No se han encontrado hoteles... ", Snackbar.LENGTH_LONG);
                snackbar.show();

            }
        });
    }
}

