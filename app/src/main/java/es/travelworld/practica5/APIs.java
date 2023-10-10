package es.travelworld.practica5;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {
    String BASE_URL = "https://01394d44-8918-4a1d-8059-629c50c25e87.mock.pstmn.io/";

    @GET("listHotels")
    Call<List<HotelResult>> getHotels();
}
