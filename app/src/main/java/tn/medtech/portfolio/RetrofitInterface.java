package tn.medtech.portfolio;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("/api/feedbacks")
    Call<Void> executeSubmit(@Body HashMap<String, String> map);

}
