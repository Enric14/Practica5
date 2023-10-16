package es.travelworld.practica5;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {
    @GET("listHotels")
    Call<List<HotelResult>> getHotels();
}
