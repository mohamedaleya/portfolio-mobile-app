package tn.medtech.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FeedbackActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://192.168.1.5:3000/";
    private Button ViewFeedbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        findViewById(R.id.b_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSubmitDialog();

            }
        });
        
    }

    private void handleSubmitDialog() {
        Button b_submit = findViewById(R.id.b_submit);
        final EditText t_name = findViewById(R.id.t_name);
        final EditText t_email = findViewById(R.id.t_email);
        final EditText t_input = findViewById(R.id.t_input);

        b_submit.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                HashMap<String, String> map = new HashMap<>();

                map.put("name", t_name.getText().toString());
                map.put("email", t_email.getText().toString());
                map.put("input", t_input.getText().toString());

                Call<Void> call = retrofitInterface.executeSubmit(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(FeedbackActivity.this,
                                "Thank you for your feedback!",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(FeedbackActivity.this,t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

}
