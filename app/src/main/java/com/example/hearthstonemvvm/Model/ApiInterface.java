package com.example.hearthstonemvvm.Model;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface ApiInterface {

    @Headers({
        "x-rapidapi-host: omgvamp-hearthstone-v1.p.rapidapi.com",
                "x-rapidapi-key: 7afc17c527mshe16c80e24abb5fcp12ba64jsn7e8ac0a27b1f"
    })
    @GET("cards")
    Observable<ResultsPojo> getCardData();

}
