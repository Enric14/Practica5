package es.travelworld.practica5;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    public static Retrofit getClient () {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://01394d44-8918-4a1d-8059-629c50c25e87.mock.pstmn.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
