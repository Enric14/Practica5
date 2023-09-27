package es.travelworld.practica5;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("authenticate/")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

}
