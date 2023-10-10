package es.travelworld.practica5;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @POST("login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);
}
